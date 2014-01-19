package threading;

import java.util.List;

import algo.MainApp;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;
import foursquare.MyFoursquareWrapper;

public class FoursquareLocationGetterTask implements Runnable{


	private List<String> record;

	public FoursquareLocationGetterTask(List record) {
		this.record = record;
	}

	@Override
	public void run() {

		double latitude;
		double longitude;
		latitude = Double.valueOf(record.get(0));
		longitude = Double.valueOf(record.get(1));
		String location = MyFoursquareWrapper.getLocationName(latitude+","+longitude);
		// here the "Activity" is found out intelligently using our algo
		record.add(2, MainApp.findActivityType(MainApp.findLocationType(location)));
		record.add("5");
		record.add(location);
		record.add(MainApp.findLocationType(location)+":Foursquare");
	}
	
	
}