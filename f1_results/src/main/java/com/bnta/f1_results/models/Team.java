package com.bnta.f1_results.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties({"team", "races"})
    private List<Driver> teamDrivers;

    // TODO: 18/05/2022 Work out how this list is populated

    // todo: make ManyToMany Join with teams_races, along with teamPoints.

//    @ManyToMany(mappedBy = "teams")
//    @JsonIgnoreProperties({"teams"})
//    private List<Race> races;

    protected Team() {
    }

    public Team(String name) {
        this.name = name;
        this.teamDrivers = new ArrayList<>();
//        this.races = new ArrayList<>();
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
//
//    public List<Race> getRaces() {
//        return races;
//    }
//
//    public void setRaces(List<Race> races) {
//        this.races = races;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamDrivers=" + teamDrivers +
                '}';
    }
}
