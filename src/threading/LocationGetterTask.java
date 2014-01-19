package threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import foursquare.MyFoursquareWrapper;
import algo.MainApp;
import bing.MyBingAPI;

public class LocationGetterTask implements Runnable {

	private List<String> record;
	private boolean fallback;

	public LocationGetterTask(List record, boolean fallback) {
		this.record = record;
		this.fallback = fallback;
	}

	@Override
	public void run() {

		double latitude;
		double longitude;
		latitude = Double.valueOf(record.get(0));
		longitude = Double.valueOf(record.get(1));
		String location = MyBingAPI.getLocationName(latitude, longitude);
		// System.out.println(longitude + "," + latitude + ":" + location);
		// "record" already contains the point and the timestamp, we need to
		// add the location for the point and the activity carried-out at
		// that point
		// here the "Activity" is found out intelligently using our algo
		String activity = MainApp.findActivityType(MainApp
				.findLocationType(location));
		String trailer = "bing:";

		if (fallback == true) {
			/**
			 * 
			 * For some cases, we may not find the type of the activity from
			 * Bing location. So we use Foursquare for the rescue. The original
			 * List of records is modified and no additional space is used.
			 */
			if (activity.equals("STATIC")) {
				String fourSquareLocation = MyFoursquareWrapper
						.getLocationName(latitude + "," + longitude);
				if (!fourSquareLocation.equals("err")) {
					activity = MainApp.findActivityType(MainApp
							.findLocationType(fourSquareLocation));
					trailer = "Foursquare:";
					location = fourSquareLocation;
				}
			}
		}

		record.add(2, activity);
		record.add("5");
		record.add(location);
		record.add(trailer + MainApp.findLocationType(location));

	}

}