package com.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoJek {

	public static void main(String[] args) {

		InputParser inputParser = new InputParser();
		switch(args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Waiting for input...");
			// Interactive command-line input/output
			// Run an infinite loop
			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {
						// Do nothing
					} else {
						inputParser.parseTextInput(inputString.trim());
					}
				} catch(IOException e) {
					System.out.println("Oops! Error in reading the input from console.");
					e.printStackTrace();
				}
			}
			break;
		default:
			System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
		}

	}
}

