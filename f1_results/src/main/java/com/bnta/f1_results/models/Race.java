package com.bnta.f1_results.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private int year;

    @ManyToMany(mappedBy = "")
    @JsonIgnoreProperties(value = "races")
    private List<Driver> raceDrivers;

    public Race() {
    }

    public Race(String name, String country, int year) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.raceDrivers = new ArrayList<>();
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Driver> getRaceDrivers() {
        return raceDrivers;
    }

    public void setRaceDrivers(List<Driver> raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", raceDrivers=" + raceDrivers +
                '}';
    }
}
