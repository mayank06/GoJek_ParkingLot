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
    
    public void park(String regNo, String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.carMap.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlots);
            String slot = availableSlots.get(0).toString();
            Car car = new Car(regNo, color);
            this.carMap.put(slot, car);
            this.slotRegMap.put(regNo, slot);
            if (this.colorRegMap.containsKey(color)) {
                ArrayList<String> regNoList = this.colorRegMap.get(color);
                this.colorRegMap.remove(color);
                regNoList.add(regNo);
                this.colorRegMap.put(color, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNo);
                this.colorRegMap.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlots.remove(0);
        }
    }
   
    public void leave(String slot) {
    	
    	if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if(this.carMap.size() > 0){
        	
        	
        	
        	
        	
        	System.out.println("Slot no " + slot + "is free");
        }
    	else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	
	
	
}
