package algo;

public class Activity {
	double latitude;
	double longitude;
	String latLong;
	String activity;
	String dateTime;
	long timeSpent;
	String locationComment;
	String meta;

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public Activity() {
		this.activity = "DEFAULT_ACTIVITY";
		this.locationComment = "DEFAULT_COMMENT";
	}

	@Override
	public String toString() {
		String toString = getLatLong() + "," + getActivity() + ","
				+ getDateTime() + "," + getTimeSpent() + ","
				+ getLocationComment();
		return toString;
	}

	public String toStringWithMeta() {
		return toString() + "," + getMeta();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLatLong() {
		return getLatitude() + "," + getLongitude();
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getLocationComment() {
		return locationComment;
	}

	public void setLocationComment(String locationComment) {
		this.locationComment = locationComment;
	}

}
