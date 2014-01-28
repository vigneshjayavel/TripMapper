package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algo.Activity;

public class FileManipulator {

	public static List readFile(String inputFileName) {

		BufferedReader br = null;
		String line = "";
		String splitBy = ",";

		List<Activity> records = new ArrayList<Activity>();
		try {

			br = new BufferedReader(new FileReader(inputFileName));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				// we get three fields viz, lat,long and timestamp
				String[] components = line.split(splitBy);
				Activity record = new Activity();
				record.setLatitude(Double.valueOf(components[0]));
				record.setLongitude(Double.valueOf(components[1]));
				record.setDateTime(components[2]);
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
			List<Activity> fileRecords) {
		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter(outputFileName);
			writer = new BufferedWriter(fileWriter);
			StringBuilder data = new StringBuilder();

			char comma = ',';
			for (Activity record : fileRecords) {
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

	public static void printRecords(List<Activity> records) {
		for (Activity record : records) {
			System.out.println(record.toString());
		}
	}

	public static void main(String[] args) {
		FileManipulator o = new FileManipulator();
		List records = o.readFile("c:/input1.txt");
		FileManipulator.printRecords(records);
	}
}
