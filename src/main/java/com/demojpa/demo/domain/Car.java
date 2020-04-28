package com.demojpa.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id;
    private String brand;
    private int speed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Owner owner;

    public Car() {
    }

    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
