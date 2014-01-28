package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algo.ActivityRecord;

public class FileManipulator {

	public static List<ActivityRecord> readFile(String inputFileName) {

		BufferedReader br = null;
		String line = "";
		String splitBy = ",";

		List<ActivityRecord> records = new ArrayList<ActivityRecord>();
		try {

			br = new BufferedReader(new FileReader(inputFileName));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				// we get three fields viz, lat,long and timestamp
				String[] components = line.split(splitBy);
				ActivityRecord record = new ActivityRecord.Builder()
						.latitude(Double.valueOf(components[0]))
						.longitude(Double.valueOf(components[1]))
						.dateTime(components[2]).build();
				records.add(record);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done reading file, No of records found : "
				+ records.size());
		return records;
	}

	public static void writeFile(String outputFileName,
			List<ActivityRecord> fileRecords) {
		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter(outputFileName);
			writer = new BufferedWriter(fileWriter);
			StringBuilder data = new StringBuilder();

			char comma = ',';
			for (ActivityRecord record : fileRecords) {
				data.append(record.getLatLong()).append(comma)
						.append(record.getActivity()).append(comma)
						.append(record.getDateTime()).append(comma)
						.append(record.getTimeSpent()).append(comma)
						.append(record.getLocationComment()).append("\n");
			}
			writer.write(data.toString());
			writer.close();
		} catch (IOException e) {
			System.out.println("Write error");
			e.printStackTrace();
		} finally {

			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("File Writing done!");
		}
	}

	public static void printRecords(List<ActivityRecord> records) {
		for (ActivityRecord record : records) {
			System.out.println(record.toString());
		}
	}

	public static void main(String[] args) {
		FileManipulator o = new FileManipulator();
		List records = o.readFile("c:/input1.txt");
		FileManipulator.printRecords(records);
	}
}
