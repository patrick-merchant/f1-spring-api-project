package com.bnta.f1_results.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column
    private String nationality;

    @ManyToMany(mappedBy = "")
    @JsonIgnoreProperties(value = "drivers")
    @JoinTable(
            name = "drivers_races",
            joinColumns = {@JoinColumn(name = "driver_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "race_id", nullable = false)}
    )
    private List<Race> races;

    public Driver() {
    }

    public Driver(String name, Team team, String nationality) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
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
