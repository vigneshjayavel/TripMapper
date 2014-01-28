package algo;

public class ActivityRecord {
	private double latitude;
	private double longitude;
	private String latLong;
	private String activity;
	private String dateTime;
	private long timeSpent;
	private String locationComment;
	private String meta;

	/*
	 * Designed a builder to make the construction process easy in the
	 * development front.
	 */
	public static class Builder {
		private double latitude;
		private double longitude;
		private String latLong;
		private String activity;
		private String dateTime;
		private long timeSpent;
		private String locationComment;
		private String meta;

		public Builder latitude(double val) {
			latitude = val;
			return this;
		}

		public Builder longitude(double val) {
			longitude = val;
			return this;
		}

		public Builder latLong(String val) {
			latLong = val;
			return this;
		}

		public Builder activity(String val) {
			activity = val;
			return this;
		}

		public Builder dateTime(String val) {
			dateTime = val;
			return this;
		}

		public Builder timeSpent(long val) {
			timeSpent = val;
			return this;
		}

		public Builder locationComment(String val) {
			locationComment = val;
			return this;
		}

		public Builder meta(String val) {
			meta = val;
			return this;
		}

		public ActivityRecord build() {
			return new ActivityRecord(latitude, longitude, latLong, activity,
					dateTime, timeSpent, locationComment, meta);
		}
	}

	public ActivityRecord(double latitude, double longitude, String latLong,
			String activity, String dateTime, long timeSpent,
			String locationComment, String meta) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.latLong = latLong;
		this.activity = activity;
		this.dateTime = dateTime;
		this.timeSpent = timeSpent;
		this.locationComment = locationComment;
		this.meta = meta;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public ActivityRecord() {
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
