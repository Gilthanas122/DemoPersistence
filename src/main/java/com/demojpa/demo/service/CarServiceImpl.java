package com.demojpa.demo.service;

import com.demojpa.demo.domain.Car;
import com.demojpa.demo.domain.Owner;
import com.demojpa.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
  CarRepository carRepository;

  @Autowired
  public CarServiceImpl(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public List<Car> returnAllCars() {
    List<Car> cars = new ArrayList<>();
    carRepository
            .findAll()
            .forEach(cars::add);
    return cars;
  }

  @Override
  public void addCar(Car car) {
    carRepository.save(car);
  }

  @Override
  public void addOwnerToCar(Owner owner, Car car) {
    car.setOwner(owner);
    List<Car> ownerCars = owner.getCars();
    ownerCars.add(car);
    owner.setCars(ownerCars);
    carRepository.save(car);
  }

  @Override
  public Car findById(long id) {
    return carRepository.findById(id).get();
  }
}
