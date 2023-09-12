package com.example.hotelapp.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**********************************
Business logic
***********************************/
@Service
public class CarService {
    
    @Autowired
    CarRepository carRepository;

    public String createCar(Car car) {

        carRepository.save(car);

        return "Car " + car.getMake() + " " +car.getModel()+ " Created!";
        
    }

    public String updateCar(Long id, Car car) {

        car.setId(id);
        carRepository.save(car);

        return "Car " + car.getMake() + " " +car.getModel()+ " Updated!";
        
    }

    public String deleteCar(Long id) {

        Car car = carRepository.findById(id).get(); 
        String msg = "Car " + car.getMake() + " " +car.getModel()+ " Deleted!";
        carRepository.delete(car);

        return msg;
       
    }

    public Car getCar(Long id) {
        Car car = carRepository.findById(id).get();
        return car;
    }


    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);;
        return cars;
    }
}