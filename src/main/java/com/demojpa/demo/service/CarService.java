package com.demojpa.demo.service;

import com.demojpa.demo.domain.Car;
import com.demojpa.demo.domain.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> returnAllCars();
    void addCar(Car car);
    void addOwnerToCar(Owner owner, Car car);
    Car findById(long id);

}
