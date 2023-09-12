package com.example.hotelapp.car;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**********************************
Use CrudRepository for generic operations (save, create, delete) 
***********************************/
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByMake(String make);

    List<Car> findByModel(String model);
  
    Car findById(long id);

}
