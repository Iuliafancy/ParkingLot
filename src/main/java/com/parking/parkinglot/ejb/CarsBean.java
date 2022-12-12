package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);

        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDto;
        carDto = cars
                .stream()
                .map(x -> new CarDto(x.getId(), x.getLicensePlate(), x.getParkingSpot(), x.getOwner().getUsername())).collect(Collectors.toList());
        return carDto;
    }

    public void createCar( String licensePlate, String parkingSpot, Long userId){
        LOG.info("createCar");

        Car car=new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user=entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);
        entityManager.persist(car);
    }


    public CarDto findById(Long carId) {
        Car car=entityManager.find(Car.class, carId);
        CarDto carDto=new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(),car.getOwner().getUsername());
        return carDto;
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        LOG.info("updateCar");

        Car car=entityManager.find(Car.class,carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        //remove this car from the old owner
        User oldUser =car.getOwner();
        oldUser.getCars().remove(car);

        //add the car to its new owner
        User user =entityManager.find(User.class,userId);
        user.getCars().add(car);
        car.setOwner(user);
    }

    public void deleteCarsByIds(Collection<Long> carIds) {
        LOG.info("deleteCarsByIds");
        for(Long carId : carIds){
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }
}




