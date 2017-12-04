package javatest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
	String fileLocation = "src/test/resources/FILE.DAT";

	public void convert() throws IOException {

		BufferedReader bufferedReader = this.getBufferedReader();
		String thisLine = bufferedReader.readLine();
		Map<CountryCredit, List<Double>> map = new HashMap<>();
		while ((thisLine = bufferedReader.readLine()) != null) {
			String[] inputLine = thisLine.split("\t");
			String country = inputLine[3].length() != 0 ? inputLine[3]
					: inputLine[2];
			String creditCode = "-".equals(inputLine[4]) ? "NR" : inputLine[4];
			CountryCredit countryCredit = new CountryCredit(country, creditCode);
			double amount = this.convert(Double.parseDouble(inputLine[6]),
					inputLine[5]);

			if (map.containsKey(countryCredit)) {
				map.get(countryCredit).add(amount);
			} else {
				List<Double> list = new ArrayList<Double>();
				list.add(amount);
				map.put(countryCredit, list);
			}

		}
		for (Map.Entry<CountryCredit, List<Double>> entry : map.entrySet()) {
			double average = this.getAverage(entry.getValue());
			System.out.println(entry.getKey() + " : " + " Average : "
					+ String.format("%.8f", average));
		}
		bufferedReader.close();
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	/**
	 * Method used to get the average of the given list.
	 * 
	 * @param list
	 * @return average
	 */
	private double getAverage(List<Double> list) {
		double average = 0;
		for (double num : list) {
			average += num;
		}
		return average / list.size();
	}

	/**
	 * Loads the file and returns a bufferedReader Object
	 * 
	 * @return bufferedReader
	 * @throws FileNotFoundException
	 */
	private BufferedReader getBufferedReader() throws FileNotFoundException {
		File file = new File(fileLocation);
		FileReader fileReader = new FileReader(file);
		return new BufferedReader(fileReader);
	}

	/**
	 * Converts the input amount to USD.
	 * 
	 * @param amount
	 * @param currency
	 * @return converted amount
	 */
	private double convert(double amount, String currency) {
		if ("CHF".equals(currency)) {
			amount = ConverterUtil.getUSDfromCHF(amount);
		} else if ("GBP".equals(currency)) {
			amount = ConverterUtil.getUSDfromGBP(amount);
		} else if ("EUR".equals(currency)) {
			amount = ConverterUtil.getUSDfromEUR(amount);
		}
		return amount;
	}
}
