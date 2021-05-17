package com.airline.airline.model;

import javax.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String Location;
    @Column(nullable = false)
    private String Name;

    public Airport() {
    }

    public Airport(Long id, String location, String name) {
        this.id = id;
        Location = location;
        Name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", Location='" + Location + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

