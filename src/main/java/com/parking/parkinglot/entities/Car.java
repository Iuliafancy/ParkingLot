package com.parking.parkinglot.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    private User owner;
    private Long id;

    public String licensePlate;

    private String parkingSpot;

    private CarPhoto photo;
@OneToOne(mappedBy="car",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    public CarPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(CarPhoto photo) {
        this.photo = photo;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public  String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }
}