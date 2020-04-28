package com.demojpa.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Car> cars;

    public Owner() {
        cars = new ArrayList<>();
        date = new Date();
    }

    public Owner(String name) {
        this.name = name;
        cars = new ArrayList<>();
        date = new Date();
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
