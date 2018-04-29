package com.design.parkingSystem;

public class Motorcycle extends Vehicle  {

	@Override
	public boolean canFitinSpot(ParkingSpot spot) {
		return false;
	}

}
