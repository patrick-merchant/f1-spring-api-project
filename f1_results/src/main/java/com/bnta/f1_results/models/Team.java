package com.bnta.f1_results.models;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;

    private String name;

    private List<Driver> teamDrivers;


    public Team() {
    }

    public Team(String name) {
        this.name = name;
        this.teamDrivers = new ArrayList<>();
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

    public List<Driver> getTeamDrivers() {
        return teamDrivers;
    }

    public void setTeamDrivers(List<Driver> teamDrivers) {
        this.teamDrivers = teamDrivers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamDrivers=" + teamDrivers +
                '}';
    }
}
