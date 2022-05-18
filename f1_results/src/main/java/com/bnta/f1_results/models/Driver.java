package com.bnta.f1_results.models;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private Long id;

    private String name;

    private String team;

    private String nationality;

    private List<Race> races;

    public Driver() {
    }

    public Driver(String name, String team, String nationality) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.races = new ArrayList<>();
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
