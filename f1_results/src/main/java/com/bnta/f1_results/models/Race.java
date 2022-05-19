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
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private int year;


    @ManyToMany
    @JsonIgnoreProperties({"races", "teamDrivers"})
    @JoinTable(
            name = "races_drivers",
            joinColumns = {@JoinColumn(name = "race_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "driver_id", nullable = false)})
    private List<Driver> drivers;
    // todo: Add some points and positions?
//
//    @ManyToMany
//    @JsonIgnoreProperties({"races"})
//    @JoinTable(
//            name = "races_teams",
//            joinColumns = {@JoinColumn(name = "race_id", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false)})
//    private List<Team> teams;

    public Race() {
    }

    public Race(String name, String country, int year, List<Driver> drivers) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.drivers = drivers;
//        this.teams = teams;
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

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

//    public List<Team> getTeams() {
//        return teams;
//    }
//
//    public void setTeams(List<Team> teams) {
//        this.teams = teams;
//    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", drivers=" + drivers +
                '}';
    }
}
