package foursquare;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

public class MyFoursquareWrapper {
	public static String getLocationName(String latLong) {
		FoursquareApi foursquareApi = new FoursquareApi(
				"GED1A53KP5JFNJTVBONXICCIVMCN1DFVX1R5S25S5HLIVPC1",
				"1WBBCXWI2T0Y4W1CEJBCLJYDBARADADQD3KRWUQSSQ30P4XB",
				"Callback URL");

		// After client has been initialized we can make queries.
		Result<VenuesSearchResult> result = null;
		try {
			result = foursquareApi.venuesSearch(latLong, null, null, null,
					"100", null, null, null, null, null, null);
		} catch (FoursquareApiException e) {
			e.printStackTrace();
		}

		if (result.getMeta().getCode() == 200
				&& result.getResult().getVenues().length != 0) {
			// if query was ok we can finally we do something with the data

			return result.getResult().getVenues()[0] != null ? result
					.getResult().getVenues()[0].getName() : "ERR";

		} else {

			if (result.getMeta().getCode() != 200) {
				System.out.println("FourSquare API Error occured: ");
				System.out.println("  code: " + result.getMeta().getCode());
				System.out
						.println("  type: " + result.getMeta().getErrorType());
				System.out.println("  detail: "
						+ result.getMeta().getErrorDetail());
			}
			else{
				System.out.println("No response from Foursquare for the lat,long : "+latLong);
			}
			return "err";
		}

	}
}
