package com.demojpa.demo.controller;

import com.demojpa.demo.domain.Car;
import com.demojpa.demo.repository.CarRepository;
import com.demojpa.demo.service.CarService;
import com.demojpa.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
  private CarService carService;
  private OwnerService ownerService;
  private CarRepository carRepository;

  @Autowired
  public Controller(CarService carService, OwnerService ownerService, CarRepository carRepository) {
    this.carService = carService;
    this.ownerService = ownerService;
    this.carRepository = carRepository;
  }

  @GetMapping("list-cars")
  @ResponseBody
  public List<Car> listAllCars(){
    return carService.returnAllCars();
  }

  @GetMapping("add-owner-to-car/{id}")
  public String addOwnerToCar(@PathVariable (name = "id") long id){
    carService.addOwnerToCar(ownerService.findById(4l), carService.findById(id));
    return "redirect:/list-cars";
  }

  @GetMapping("query")
  @ResponseBody
  public List<Car> reachQueries(){
    List<Car> carQueries = new ArrayList<>();/*
    carQueries.add(carRepository.findMyFavouriteCar());
    carQueries.add(carRepository.findMyFavouriteCarative());
    carQueries.addAll(carRepository.findMyStudentWithSimilarName("BMW"));
    carQueries.addAll(carRepository.findStudentByAge("Audi", 50));*/
    carQueries.addAll(carRepository.findAllByBrandContaining("A"));
    printZeroArith();

    return carQueries;
  }

  private void printZeroArith() {
    System.out.println(10 / 0);
  }
}
