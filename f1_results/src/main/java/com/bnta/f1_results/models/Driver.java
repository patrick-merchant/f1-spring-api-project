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
    private String team;

    @Column
    private String nationality;

    @ManyToMany()
    @JoinTable(
            name = "drivers_races",
            joinColumns = {@JoinColumn(name = "driver_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "race_id", nullable = false)}
    )
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
