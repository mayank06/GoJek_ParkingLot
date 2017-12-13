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
        System.out.println("Created parking lot with " + slots + " slots");
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
        	
        	Car leavingCar = this.carMap.get(slot);
        	if(leavingCar != null) {
        		this.carMap.remove(slot);
        		this.colorRegMap.remove(leavingCar.regNo);
        		ArrayList<String> regNoList = this.colorRegMap.get(leavingCar.color);
        		if(regNoList.contains(leavingCar.regNo)) {
        			regNoList.remove(leavingCar.regNo);
        		}
        		
        		this.availableSlots.add(Integer.parseInt(slot));
        		System.out.println("Slot no " + slot + " is free");
        		System.out.println();
        	} else {
        		System.out.println("Parking slot is already empty.");
        	}
        }
    	else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
    
    public void status() {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.carMap.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            Car car;
            for (int i = 1; i <= this.MAX_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.carMap.containsKey(key)) {
                    car = this.carMap.get(key);
                    System.out.println(i + "\t" + car.regNo + "\t" + car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
    public void getRegistrationNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.colorRegMap.containsKey(color)) {
            ArrayList<String> regNoList = this.colorRegMap.get(color);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.colorRegMap.containsKey(color)) {
            ArrayList<String> regNoList = this.colorRegMap.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.slotRegMap.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
	
	public void getSlotNumberFromRegNo(String regNo) {
		if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if(slotRegMap.containsKey(regNo)) {
        	System.out.println(slotRegMap.get(regNo));
        } else {
        	System.out.println("Not found");
            System.out.println();
        }
	}
}
