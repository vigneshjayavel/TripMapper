package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {

	public static List readFile(String inputFileName) {

		BufferedReader br = null;
		String line = "";
		String splitBy = ",";

		List<List<String>> records = new ArrayList<List<String>>();
		try {

			br = new BufferedReader(new FileReader(inputFileName));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				// we get three fields viz, lat,long and timestamp
				String[] currentLine = line.split(splitBy);
				List<String> record = new ArrayList<String>();
				int findThirdField = 1;
				for (String s : currentLine) {
					if (findThirdField == 3) {
						// we split the timestamp into date and time
						String temp[] = s.split(" ");
						record.add(temp[0]);
						record.add(temp[1] + " " + temp[2]);
						findThirdField = 1;
					} else {
						record.add(s);
					}
					findThirdField++;
				}
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
			List<List<String>> records) {
		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter(outputFileName);
			writer = new BufferedWriter(fileWriter);
			StringBuilder data = new StringBuilder();

			for (List<String> record : records) {
				int count = 1;
				for (String s : record) {
					if (count == 8) {
						break;
					} else {
						data.append(s).append(",");

						count++;
					}
				}
				data.append("\n");
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

	public static void printRecords(List<List<String>> records) {
		for (List<String> record : records) {
			for (String s : record) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FileManipulator o = new FileManipulator();
		List records = o.readFile("c:/input1.txt");
		FileManipulator.printRecords(records);
	}
}
