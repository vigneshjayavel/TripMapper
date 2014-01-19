package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threading.FoursquareLocationGetterTask;
import threading.LocationGetterTask;
import threading.TravelDistanceTimeGetterTask;
import utils.FileManipulator;
import utils.TimeManipulator;
import bing.MyBingAPI;

public class MainApp {
	static MyBingAPI api = new MyBingAPI();
	static Map<String, String> activityMap;
	static {
		activityMap = new HashMap<String, String>();
		activityMap.put("hotel", "HOTEL_STAY");
		activityMap.put("airport", "AIRPORT");
		activityMap.put("tourism", "TOURIST_SPOT");
		activityMap.put("taxi", "TAXI_TRAVEL");
		activityMap.put("bus", "BUS_TRAVEL");
		activityMap.put("train", "TRAIN_TRAVEL");
		activityMap.put("highway", "TAXI_TRAVEL");
		activityMap.put("restaurant", "RESTAURANT");
		activityMap.put("walking", "WALK");
		activityMap.put("driving", "TAXI_TRAVEL/DRIVING");
		activityMap.put("transit", "FLIGHT_TRAVEL");
	}

	public static void main(String[] args) {

		System.out
				.println("Please make sure you have c:/input.txt and c:/output.txt !");

		String inputFileName = "c:/input0.txt";
		String outputFileName = "c:/output.txt";

		List<List<String>> fileRecords = FileManipulator
				.readFile(inputFileName);

		int fileSize = fileRecords.size();
		if (fileSize == 0) {
			System.out.println("Please provide a valid input file!!");
			return;
		}

		long execStarted = System.currentTimeMillis();
		// prepare(fileRecords);
		preprocess(fileRecords);
		FileManipulator.writeFile("C:/prepare-output.txt", fileRecords);
		// FileManipulator.printRecords(fileRecords);
		// firstPassAggregate(fileRecords);
		// System.out.println("xxxxxxxxxxxxAfter Pass1xxxxxxxxxxxxxxxxxxxx");

		pass1(fileRecords);
		FileManipulator.writeFile("C:/firstpass-output.txt", fileRecords);
		// resolveHotelActivities(fileRecords);
		// FileManipulator.writeFile("C:/resolveHotel-output.txt", fileRecords);

		pass2(fileRecords);
		FileManipulator.writeFile("C:/secondpass-output.txt", fileRecords);

		FileManipulator.printRecords(fileRecords);

		FileManipulator.writeFile("C:/output.txt", fileRecords);

		System.out.println("TripMapper took "
				+ (System.currentTimeMillis() - execStarted) / 1000
				+ "seconds to process " + fileSize + " records/activities");

	}

	/**
	 * Primarily uses Bing Maps. For some cases, we may not find the type of the
	 * activity from Bing location. So we may fallback to Foursquare for the
	 * rescue. Foursquare comes to the rescue when "Activity type" cant be
	 * resolved using Bing's result. Uses multithreading for Reverse Geocoding
	 * the lat,long records to get the location names and add them into the
	 * record. The original List of records is modified and no additional space
	 * is used.
	 * 
	 * @param fileRecords
	 * @return
	 */
	public static void preprocess(List<List<String>> fileRecords) {

		// reverse geocode every single point
		System.out
				.println("Please have patience while we are getting response from Bing Maps..\nWe may fallback to Foursquare for additional info..\n");
		long timeSpent = 5;

		ExecutorService executor = Executors.newFixedThreadPool(50);
		boolean fallback = false; // Use foursquare data as fallback
		for (List<String> record : fileRecords) {

			Runnable worker = new LocationGetterTask(record, fallback);
			executor.execute(worker);

		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}
		System.out.println("\nFinished all threads");
		System.out.println("count = " + fileRecords.size());

		// finally set the first record time = 0
		fileRecords.get(0).set(5, "5");

	}

	/*
	 * Activity classification pass. For 2 consequtive records, find the travel
	 * type. Those 2 records have Time diff = 5.
	 * 
	 * We resolveTravelActivities. Activity can be travel related(drive, flight)
	 * or Stay-related (Hotel stay, park, beach,..)
	 */

	public static void pass1(List<List<String>> records) {
		ListIterator<List<String>> itr = records.listIterator();
		String travelType = null;
		while (itr.hasNext()) {
			List cur = itr.next();
			if (itr.hasNext()) {
				List nex = itr.next();
				travelType = getTravelTypeIfAny(cur, nex);
				if (travelType != null) {
					double latitude1, latitude2;
					double longitude1, longitude2;
					latitude1 = Double.valueOf(cur.get(0).toString());
					longitude1 = Double.valueOf(cur.get(1).toString());
					latitude2 = Double.valueOf(nex.get(0).toString());
					longitude2 = Double.valueOf(nex.get(1).toString());

					// same point or place names means STATIC activity
					if ((latitude1 != latitude2 && longitude1 != longitude2)
							|| !(cur.get(6).toString().equals(nex.get(6)
									.toString()))) {
						cur.set(2, findActivityType(travelType));
					} else {
						cur.set(2, "STATIC");
					}
					// itr.remove();
					itr.previous();
				}

			}
		}
	}

	/**
	 * 
	 * Multithreading is used here. 3 API calls are made in parallel. Compares
	 * two records. Finds the mode of transportation (if any) by checking the
	 * distance between them and the time taken.
	 * 
	 * @param record1
	 * @param record2
	 * @return
	 */
	public static String getTravelTypeIfAny(List<String> record1,
			List<String> record2) {
		String travelType = null;
		String startTime = record1.get(4);
		String endTime = record2.get(4);
		long timeDiffFromRecords = 60 * TimeManipulator.findTimeDifferenceMins(
				startTime, endTime);

		// System.out.println("TimeDiff" + timeDiffFromRecords);

		Map drivingResult = new HashMap<String, String>(), walkingResult = new HashMap<String, String>(), transitResult = new HashMap<String, String>();
		Map<String, Map<String, String>> resultsMap = new HashMap<String, Map<String, String>>();

		resultsMap.put("driving", drivingResult);
		resultsMap.put("walking", walkingResult);
		resultsMap.put("transit", transitResult);

		ExecutorService executor = Executors.newFixedThreadPool(5);

		// run the 3 API calls in parallel
		for (Map.Entry<String, Map<String, String>> entry : resultsMap
				.entrySet()) {
			Runnable worker = new TravelDistanceTimeGetterTask(record1,
					record2, entry.getKey(), entry.getValue());
			executor.execute(worker);
		}

		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}

		// the logic is
		// we first find the time,dist between startTime and endTime of 2
		// consecutive records.
		// if we are getting an approximation of traveltime ~ 5mins we zero-in
		// on that mode of travel, viz. Walk,drive,Flight
		// otherwise there is no travel between the 2points/he is static

		Map<String, Long> durations = new HashMap<String, Long>();
		for (Map.Entry<String, Map<String, String>> entry : resultsMap
				.entrySet()) {
			System.out.println(entry.getKey());
			String type = entry.getKey();
			if (entry.getValue() == null) {
				System.out.println("null val for the key " + entry.getKey());
			} else {
				if (entry.getValue().containsKey("error")) {
					System.out.println(entry.getValue()
							.get("statusDescription"));

				} else {
					for (Map.Entry<String, String> resultEntry : entry
							.getValue().entrySet()) {
						// eg. add
						// walkingtravelDistance,walkingtravelDuration,.. in
						// the map
						if (resultEntry.getKey().contains("travel")) {
							durations
									.put(type + resultEntry.getKey(), Long
											.valueOf(round(resultEntry
													.getValue())));
						}
					}
				}
			}
		}

		/*
		 * for (Map.Entry<String, Long> e : durations.entrySet()) {
		 * System.out.println(e.getKey() + ":" + e.getValue()); }
		 */
		long walkingDistance = 0, drivingDistance = 0, transitDistance = 0;
		long walkingDuration = 0, drivingDuration = 0, transitDuration = 0;
		if (durations.containsKey("walkingtravelDistance")) {
			walkingDistance = durations.get("walkingtravelDistance");
			walkingDuration = durations.get("walkingtravelDuration");
		}
		if (durations.containsKey("drivingtravelDistance")) {
			drivingDistance = durations.get("drivingtravelDistance");
			drivingDuration = durations.get("drivingtravelDuration");
		}
		if (durations.containsKey("transittravelDistance")) {
			transitDistance = durations.get("transittravelDistance");
			transitDuration = durations.get("transittravelDuration");
		}

		System.out.println(walkingDistance + "," + walkingDuration + ","
				+ drivingDistance + "," + drivingDuration + ","
				+ transitDistance + "," + transitDuration);

		// who the heck can walk more than 10km/5min
		// who the heck can drive more than that!!
		if (walkingDistance > 10) {
			travelType = "transit";
		} else {
			travelType = findTravelType(timeDiffFromRecords, walkingDuration,
					drivingDuration, transitDuration);
		}

		String log = "<%s,%s> to <%s,%s>";
		log = String.format(log, record1.get(0), record1.get(1),
				record2.get(0), record2.get(1));
		System.out.println(log + travelType);
		return travelType;
	}

	/*
	 * Based on the Check-in time we categorize. IT IS ASSUMED THAT TIMES ARE
	 * LOGGED IN 24 HR FORMAT. (AS GIVEN IN THE SAMPLE TEST CASE) 12 HR FORMAT
	 * IS NOT HANDLED.
	 */

	public static void resolveHotelActivity(List<String> rec) {
		String activity = null;
		long durationStayed = Long.valueOf(rec.get(5));
		int hourIn = Integer.valueOf(rec.get(4).split(":")[0]);

		if (durationStayed >= 100) {
			activity = "HOTEL_STAY";
		} else {
			if (hourIn >= 6 && hourIn <= 11) {
				activity = "BREAKFAST";
			} else if (hourIn >= 11 && hourIn <= 13) {
				activity = "LUNCH";
			} else if (hourIn >= 13 && hourIn <= 19) {
				activity = "COFFEE";
			} else if (hourIn >= 19) {
				activity = "DINNER";

			}
		}

		// update the ACTIVITY
		rec.set(2, activity);

	}

	/**
	 * Aggregation pass. here the duplications are aggregated based on the
	 * geoPoint(lat,longitude), ACTIVITY and location name
	 */
	public static void pass2(List<List<String>> records) {

		ListIterator<List<String>> recordsItr = records.listIterator();
		String currentActivity = null, nextActivity = null;
		while (recordsItr.hasNext()) {
			List<String> current, next;
			/*
			 * // reset strings currentPoint.setLength(0);
			 * currentPlace.setLength(0); nextPoint.setLength(0);
			 * nextPlace.setLength(0); currentActivity.setLength(0);
			 * nextActivity.setLength(0);
			 */
			// current record
			current = recordsItr.next();
			if (recordsItr.hasNext()) {
				// next record
				next = recordsItr.next();

				currentActivity = current.get(2);
				nextActivity = next.get(2);

				// same activity type. Merge it
				if ((currentActivity.toString().equals(nextActivity.toString()))) {

					// increment the time spent in that place by 5 and
					// remove
					// the next record (this record is considered duplicate)
					current.set(5,
							String.valueOf(Integer.valueOf(current.get(5)) + 5));
					current.set(6, current.get(6) + " >>> " + next.get(6));
					recordsItr.remove();
					// move the pointer to the
					// previous record so that we can compare it with the next

				}
				recordsItr.previous();
			}

		}
		// finally add a record for the trip start and end

		List<String> firstRecord = records.get(0);
		String commentField = firstRecord.get(6);
		records.add(0, ((List<String>) Arrays.asList(
				firstRecord.get(0),
				firstRecord.get(1),
				"TRIP_START",
				firstRecord.get(3),
				firstRecord.get(4),
				"0",
				commentField.split(">>>").length > 0 ? commentField
						.split(">>>")[0] : commentField, firstRecord.get(7))));

		List<String> lastRecord = records.get(records.size() - 1);

		// add the time in the prev record to the end record so it is the
		// updated
		// end time
		String endTime = TimeManipulator.addTime(lastRecord.get(4),
				lastRecord.get(5));

		// and TRIP_END and TRIP_END time = 0
		records.add((List<String>) Arrays.asList(lastRecord.get(0),
				lastRecord.get(1), "TRIP_END", lastRecord.get(3), endTime, "0",
				lastRecord.get(6), lastRecord.get(6)));

	}

	/*
	 * 
	 * Util method to calculate the nearest possible travel mode based on
	 * duration from API and input duration
	 */

	public static String findTravelType(long actualDuration,
			long walkingDuration, long drivingDuration, long transitDuration) {

		int diffa = (int) Math.abs(actualDuration - walkingDuration);
		int diffb = (int) Math.abs(actualDuration - drivingDuration);
		int diffc = (int) Math.abs(actualDuration - transitDuration);
		// you are finding which value gives you the minimum diff and return a
		// string based on it

		// Bing doesnot give Transit duration for most of Indian places.
		// so if it is 0, that means, it is "Flight" transit.
		return transitDuration != 0 ? diffa < diffb ? (diffa < diffc ? "walking"
				: "driving")
				: (diffb < diffc ? "driving" : "transit")
				: (diffa < diffb ? "driving" : "walking");

	}

	// to round off a number to a long decimal val
	public static long round(String num) {

		return Math.round(Double.valueOf(num));
	}

	public static String findActivityType(String locationType) {

		locationType = locationType.toLowerCase();
		System.out.println(locationType);
		return activityMap.containsKey(locationType) ? activityMap
				.get(locationType) : "STATIC";

	}

	public static String findLocationType(String location) {
		String locationType = "UnKnown";
		if (location != null) {
			location = location.toLowerCase();
			if (location.contains("hotel") || location.contains("lodge")
					|| location.contains("resort")) {
				locationType = "hotel";
			} else if (location.contains("restaurant")
					|| location.contains("cafe") || location.contains("coffee")) {
				locationType = "restaurant";
			} else if (location.contains("airport")
					&& !location.contains("road")) {
				locationType = "airport";
			} else if (location.contains("bus stand")
					|| location.contains("bus stop")) {
				locationType = "busStand";
			} else if (location.contains("NH") || location.contains("highway")) {
				locationType = "highway";
			} else if (location.contains("rail") || location.contains("train")
					|| location.contains("station")
					|| location.contains("junction")) {
				locationType = "railwayStation";
			} else if (location.contains("park") || location.contains("beach")
					|| location.contains("temple")
					|| location.contains("church")
					|| location.contains("mosque")
					|| location.contains("shore")) {
				locationType = "tourism";
			} else if (location.contains("clinic")
					|| location.contains("hospital")) {
				location = "hospital";

			} else if (location.contains("theater")
					|| location.contains("theatre")
					|| location.contains("hall") || location.contains("mall")
					|| location.contains("shopping")) {
				location = "entertainment";

			} else {
				locationType = "other";
			}
		}
		return locationType;

	}

}
