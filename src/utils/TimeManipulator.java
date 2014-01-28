package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeManipulator {

	public static long findTimeDifferenceMins(String startTime, String endTime) {
		long diff = 0;

		if (startTime == null || startTime.equals("") || endTime == null
				|| endTime.equals(""))
			return 0;

		diff = ((getDate(endTime).getTime() / 60000) - (getDate(startTime)
				.getTime() / 60000));
		return diff;

	}

	public static Date getDate(final String date) {
		final Calendar cal = Calendar.getInstance();
		final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");
		format.setCalendar(cal);

		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String addTime(String time, String addition) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");
		Date d = null;
		try {
			d = df.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, (int) Double.parseDouble(addition));

		String updatedTime = df.format(cal.getTime());
		return updatedTime;
	}

	public static String addTimeToDateTime(String dateTime, String addition) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");
		Date d = null;
		try {
			d = df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, (int) Double.parseDouble(addition));

		String updatedTime = df.format(cal.getTime());
		return updatedTime;
	}

	public static void main(String[] args) {
		String st = "12/31/2013 23:30 PM", add = "5";
		System.out.println(addTimeToDateTime(st, add));
	}
}
