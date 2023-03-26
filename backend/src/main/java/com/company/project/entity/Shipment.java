package com.company.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table
public class Shipment {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    public Shipment() {
    }

    public Shipment(String name) {
        this.name = name;
    }

    public Shipment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipment shipment = (Shipment) o;

        return name.equals(shipment.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
