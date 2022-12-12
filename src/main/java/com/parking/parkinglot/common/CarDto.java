package com.parking.parkinglot.common;

import java.util.List;



public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    String ownerName;

    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }

    public Long getId() {return id;}

    public String getLicensePlate() {return licensePlate;}

    public String getParkingSpot() { return parkingSpot;}

    public String getOwnerName() {return ownerName;}


}
