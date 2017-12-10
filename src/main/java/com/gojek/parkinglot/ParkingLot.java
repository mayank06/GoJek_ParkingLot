package com.gojek.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

	int MAX_SIZE = 0;
	
	private class Car{
		private String regNo;
		private String color;

		public Car(String regNo, String color) {
			this.regNo = regNo;
			this.color = color;
		}
	}
	
	// List of available slots
    ArrayList<Integer> availableSlots;
    // Map of Slot - Car
    Map<String, Car> carMap;
    // Map of RegNo - Slot
    Map<String, String> slotRegMap;
    // Map of Color - List of RegNo
    Map<String, ArrayList<String>> colorRegMap;


    public void createParkingLot(String slots) {
        try {
            this.MAX_SIZE = Integer.parseInt(slots);
        } catch (Exception e) {
            System.out.println("Invalid slot count");
            System.out.println();
        }
        this.availableSlots = new ArrayList<Integer>() {};
        for (int i=1; i<= this.MAX_SIZE; i++) {
            availableSlots.add(i);
        }
        this.carMap = new HashMap<String, Car>();
        this.slotRegMap = new HashMap<String, String>();
        this.colorRegMap = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking slot with " + slots + " slots");
        System.out.println();
    }
    
   
	
	
	
}
