package threading;

import algo.Activity;
import algo.MainApp;
import bing.MyBingAPI;
import foursquare.MyFoursquareWrapper;

public class LocationGetterTask implements Runnable {

	private Activity record;
	private boolean canFallback;

	public LocationGetterTask(Activity record2, boolean fallback) {
		this.record = record2;
		this.canFallback = fallback;
	}

	@Override
	public void run() {

		double latitude;
		double longitude;
		latitude = record.getLatitude();
		longitude = record.getLongitude();
		String location = MyBingAPI.getLocationName(latitude, longitude);
		// System.out.println(longitude + "," + latitude + ":" + location);
		// "record" already contains the point and the timestamp, we need to
		// add the location for the point and the activity carried-out at
		// that point
		// here the "Activity" is found out intelligently using our algo
		String activity = MainApp.findActivityType(MainApp
				.findLocationType(location));
		String trailer = "bing:";

		if (canFallback == true) {
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

		record.setActivity(activity);
		record.setTimeSpent(5);
		record.setLocationComment(location);
		record.setMeta(trailer + MainApp.findLocationType(location));

	}

}