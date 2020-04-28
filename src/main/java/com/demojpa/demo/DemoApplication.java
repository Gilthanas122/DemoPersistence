package com.demojpa.demo;

import com.demojpa.demo.domain.Car;
import com.demojpa.demo.domain.Owner;
import com.demojpa.demo.service.CarService;
import com.demojpa.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private CarService carService;
    private OwnerService ownerService;

    @Autowired
    public DemoApplication(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        carService.addCar(new Car("Audi", 100));
        carService.addCar(new Car("Rower", 200));
        carService.addCar(new Car("BMW", 200));

        ownerService.addOwner(new Owner("kata"));
        ownerService.addOwner(new Owner("pepsi"));
        ownerService.addOwner(new Owner("vanMeg"));

        carService.addCar(new Car("BMW", 200));
    }
}
