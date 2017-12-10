package com.gojek.parkinglot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Commands {

	public Map<String, Method> commandsMap;
	
	public Commands() {
		commandsMap = new HashMap<String, Method>();
		try {
			populateCommandsHashMap();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void populateCommandsHashMap() throws NoSuchMethodException{
		
		commandsMap.put("create_parking_lot", ParkingLot.class.getMethod("createParkingLot", String.class));
		commandsMap.put("park", ParkingLot.class.getMethod("park", String.class, String.class));
		
	}
}
