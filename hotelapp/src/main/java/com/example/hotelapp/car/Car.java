package com.example.hotelapp.car;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;

/**********************************
    @Entity(name = "cars") set the DB table lane 
***********************************/
@Entity(name = "cars")
public class Car {

    /**********************************
    @Id indicates that the id field is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) the way of increment for the id field
    field type is int, translated to int(11) in the DB
    ***********************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**********************************
    @NotNull indicates that the id field cannot be empty and the persistent field will be set to not null
    field type is String, translated to varchar(255) in the DB
    ***********************************/
    @NotNull
    private String make;

    /**********************************
    @NotNull indicates that the id field cannot be empty and the persistent field will be set to not null
    field type is String, translated to varchar(255) in the DB
    ***********************************/
    @NotNull
    private String model;


    /**********************************
    Car accessors
    ***********************************/
    protected Car(){}

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**********************************
    Make field Getters and Setters
    ***********************************/
    public String getMake() {
        return make;
    }
    /**********************************
    @Column(nullable = false) Car entity the setMake field cannot be false
    ***********************************/
    @Column(nullable = false)
    public void setMake(String make) {
        this.make = make;
    }


    /**********************************
    Model field Getters and Setters
    ***********************************/
    public String getModel() {
        return model;
    }
    /**********************************
    @Column(nullable = false) Car entity the setModel field cannot be false
    ***********************************/
    @Column(nullable = false)
    public void setModel(String model) {
        this.model = model;
    }


    /**********************************
    Id field Getters and Setters
    ***********************************/
    public Long getId() {
        return id;
    }
    /**********************************
    No need to set this field nullable as incremeented in DB
    ***********************************/
    public void setId(Long id) {
        this.id = id;
    }
}
