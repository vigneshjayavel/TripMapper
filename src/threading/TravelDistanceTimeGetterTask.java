package threading;

import java.util.Map;

import algo.ActivityRecord;
import bing.MyBingAPI;

public class TravelDistanceTimeGetterTask implements Runnable {

	private ActivityRecord record1, record2;
	private String type;
	private Map<String,String> result;

	
	
	public TravelDistanceTimeGetterTask(ActivityRecord current, ActivityRecord next, String type, Map<String,String> result) {
		this.record1 = current;
		this.record2 = next;
		this.type = type;
		this.result = result;
	}

	@Override
	public void run() {

		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = record1.getLatitude();
		longitude1 = record1.getLongitude();
		latitude2 = record2.getLatitude();
		longitude2 = record2.getLongitude();
		System.out.println("<distance,time> data for <"+latitude1+","+longitude2+"> & <"+latitude2+","+longitude2+">");
		
		if (type.equals("walking")) {
			result = MyBingAPI.getWalkingDistance(latitude1, longitude1,
					latitude2, longitude2, result);
		} else if (type.equals("driving")) {
			result = MyBingAPI.getDrivingDistance(latitude1, longitude1,
					latitude2, longitude2, result);
		} else if (type.equals("transit")) {
			String departDateTime = record1.getDateTime();
			result = MyBingAPI.getTransitDistance(latitude1, longitude1,
					latitude2, longitude2, "departure", departDateTime, result);			
		}

		
	}
}