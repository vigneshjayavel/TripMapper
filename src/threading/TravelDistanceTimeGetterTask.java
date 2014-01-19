package threading;

import java.util.List;
import java.util.Map;

import bing.MyBingAPI;

public class TravelDistanceTimeGetterTask implements Runnable {

	private List<String> record1, record2;
	private String type;
	private Map<String,String> result;

	
	
	public TravelDistanceTimeGetterTask(List<String> record1, List<String> record2, String type, Map<String,String> result) {
		this.record1 = record1;
		this.record2 = record2;
		this.type = type;
		this.result = result;
	}

	@Override
	public void run() {

		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = Double.valueOf(record1.get(0));
		longitude1 = Double.valueOf(record1.get(1));
		latitude2 = Double.valueOf(record2.get(0));
		longitude2 = Double.valueOf(record2.get(1));
		System.out.println("<distance,time> data for <"+latitude1+","+longitude2+"> & <"+latitude2+","+longitude2+">");
		
		if (type.equals("walking")) {
			result = MyBingAPI.getWalkingDistance(latitude1, longitude1,
					latitude2, longitude2, result);
		} else if (type.equals("driving")) {
			result = MyBingAPI.getDrivingDistance(latitude1, longitude1,
					latitude2, longitude2, result);
		} else if (type.equals("transit")) {
			String departDateTime = record1.get(4);
			result = MyBingAPI.getTransitDistance(latitude1, longitude1,
					latitude2, longitude2, "departure", departDateTime, result);			
		}

		
	}
}