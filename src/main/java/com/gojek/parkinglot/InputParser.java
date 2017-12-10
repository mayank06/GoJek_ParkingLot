package com.gojek.parkinglot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputParser {
	
	private Commands commands;
	private ParkingLot parkingLot;
	
	public InputParser() {
		commands = new Commands();
		parkingLot = new ParkingLot();
	}
	
	public void parseTextInput(String inputString) {
        // Split the input string to get command and input value
        String[] inputs = inputString.split(" ");
        switch (inputs.length) {
            case 1:
                try {
                    Method method = commands.commandsMap.get(inputString);
                    if (method != null) {
                        method.invoke(parkingLot);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Method method = commands.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Method method = commands.commandsMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1], inputs[2]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

}
