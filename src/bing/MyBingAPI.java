package bing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import pojo.distance.driving.BingDrivingDistance;
import pojo.distance.transit.BingTransitDistance;
import pojo.distance.walking.BingWalkingDistance;
import pojo.reversegeocoding.Bing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyBingAPI {

	private static String bingMapsKey = "AvQXdJy1sxa5GerehrQvNK2yGtlyh1T_gb0oyruUz3n8-Ylo_MrDiz0-W7WmNXfq";

	private static ObjectMapper mapper = new ObjectMapper();

	private static final String rootUrl = "https://dev.virtualearth.net/REST/v1/";

	public static String getKey() {
		return bingMapsKey;
	}

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}

	public static String getRootUrl() {
		return rootUrl;
	}

	public static String getLocationName(double latitude, double longitude) {

		// This implementation assumes that out of all the Resources returned as
		// a response, the first one is the exact match

		String response;
		try {
			String url = rootUrl + "Locations/" + latitude + "," + longitude
					+ "?o=json&key=" + bingMapsKey;

			response = sendGet(url);

			if (response != null) {

				// convert json response to POJO
				Bing bingRootObj = mapper.readValue(response, Bing.class);

				if (bingRootObj.getResourceSets().size() != 0
						&& bingRootObj.getResourceSets().get(0).getResources()
								.size() != 0)
					return bingRootObj.getResourceSets().get(0).getResources()
							.get(0).getName();
				else
					return null;

			} else {
				System.out.println("OOPS something bad has happened");
				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	public List getNearbyPlacesOfInterest(double latitude, double longitude) {
		// TODO

		return null;
	}

	public static Map<String, String> getDrivingDistance(double latitude1,
			double longitude1, double latitude2, double longitude2,
			Map<String, String> result) {
		return getDistanceForType(latitude1, longitude1, latitude2, longitude2,
				"driving", null, null, result);

	}

	public static Map<String, String> getWalkingDistance(double latitude1,
			double longitude1, double latitude2, double longitude2,
			Map<String, String> result) {

		return getDistanceForType(latitude1, longitude1, latitude2, longitude2,
				"walking", null, null, result);
	}

	public static Map<String, String> getTransitDistance(double latitude1,
			double longitude1, double latitude2, double longitude2,
			String timeType, String dateTime, Map<String, String> result) {

		return getDistanceForType(latitude1, longitude1, latitude2, longitude2,
				"transit", timeType, dateTime, result);
	}

	public static Map<String, String> getDistanceForType(double latitude1,
			double longitude1, double latitude2, double longitude2,
			String type, String timeType, String dateTime,
			Map<String, String> result) {

		String url = "";
		String response = "";

		if (type.equals("walking")) {
			url = rootUrl + "Routes/Driving?o=json&wp.0=" + latitude1 + ","
					+ longitude1 + "&wp.1=" + latitude2 + "," + longitude2
					+ "&key=" + bingMapsKey;

		} else if (type.equals("driving")) {
			url = rootUrl + "Routes/Walking?o=json&wp.0=" + latitude1 + ","
					+ longitude1 + "&wp.1=" + latitude2 + "," + longitude2
					+ "&key=" + bingMapsKey;

		} else if (type.equals("transit")) {
			// dateTime = "3:00:00PM";
			if (!timeType.equalsIgnoreCase("Departure")
					&& !timeType.equalsIgnoreCase("Arrival")) {
				timeType = "Departure";

			}
			url = rootUrl + "Routes/Transit?o=json&timeType=" + timeType
					+ "&dateTime=" + dateTime + "&wp.0=" + latitude1 + ","
					+ longitude1 + "&wp.1=" + latitude2 + "," + longitude2
					+ "&key=" + bingMapsKey;

		}

		try {

			response = sendGet(url);

			if (response != null) {
				if (type.equals("walking")) {
					// convert json response to POJO
					BingWalkingDistance bingRootObj1 = mapper.readValue(
							response, BingWalkingDistance.class);
					if (bingRootObj1.getResourceSets().size() != 0
							&& bingRootObj1.getResourceSets().get(0)
									.getResources().size() != 0) {
						result.put("travelDistance", bingRootObj1
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDistance().toString());
						result.put("travelDuration", bingRootObj1
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDuration().toString());
						result.put("travelDurationTraffic", bingRootObj1
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDurationTraffic().toString());
						result.put("statusDescription",
								bingRootObj1.getStatusDescription());
						return result;
					} else {
						System.out.println("error in walking API");
						result.put("error", "yes");
						result.put("statusDescription",
								bingRootObj1.getStatusDescription());
						return result;
					}
				} else if (type.equals("driving")) {
					BingDrivingDistance bingRootObj2 = mapper.readValue(
							response, BingDrivingDistance.class);
					if (bingRootObj2.getResourceSets().size() != 0
							&& bingRootObj2.getResourceSets().get(0)
									.getResources().size() != 0) {
						result.put("travelDistance", bingRootObj2
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDistance().toString());
						result.put("travelDuration", bingRootObj2
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDuration().toString());
						result.put("travelDurationTraffic", bingRootObj2
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDurationTraffic().toString());
						result.put("statusDescription",
								bingRootObj2.getStatusDescription());
						return result;
					} else {
						System.out.println("error in driving API");
						result.put("error", "yes");
						result.put("statusDescription",
								bingRootObj2.getStatusDescription());
						return result;
					}
				} else if (type.equals("transit")) {
					BingTransitDistance bingRootObj3 = mapper.readValue(
							response, BingTransitDistance.class);
					if (bingRootObj3.getResourceSets().size() != 0
							&& bingRootObj3.getResourceSets().get(0)
									.getResources().size() != 0) {
						result.put("travelDistance", bingRootObj3
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDistance().toString());
						result.put("travelDuration", bingRootObj3
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDuration().toString());
						result.put("travelDurationTraffic", bingRootObj3
								.getResourceSets().get(0).getResources().get(0)
								.getTravelDurationTraffic().toString());
						result.put("statusDescription",
								bingRootObj3.getStatusDescription());
						return result;
					} else {
						System.out.println("error in transit API");
						result.put("error", "yes");
						result.put("statusDescription",
								bingRootObj3.getStatusDescription());
						return result;
					}
				}

			} else {
				System.out
						.println("No response for the " + type + " REST call");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// This method acts as a simple HTTP client that does the REST request and
	// returns the json response
	public static String sendGet(String url) {
		StringBuffer response = null;
		try {
			URL obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

//			 System.out.println("GET : " + url);
			int responseCode = con.getResponseCode();
			// System.out.println("Response Code : " + responseCode);

			if (responseCode != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ responseCode);
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		// System.out.println("Got response for "+url);
		return response != null ? response.toString() : null;

	}

	// Utility method to beautify JSON response
	public static void prettyPrint(Object obj) {
		// pretty print json

		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	// Test method.. Use it to test code
	public static void main(String[] args) {

		MyBingAPI testObj = new MyBingAPI();
		String url = "http://10.40.76.54/tcc/login?username=tccadmin&orgname=tcc&password=tcc4ever!";
		System.out.println(sendGet(url));
	}

}
