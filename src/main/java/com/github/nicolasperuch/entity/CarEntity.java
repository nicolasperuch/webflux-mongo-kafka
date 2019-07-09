package com.github.nicolasperuch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class CarEntity implements Serializable {

    @Id
    private String id;
    private String color;
    private String licensePlate;
    private Integer year;

    public CarEntity() {}

    public CarEntity(String id, String color, String licensePlate, Integer year) {
        this.id = id;
        this.color = color;
        this.licensePlate = licensePlate;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public CarEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarEntity setColor(String color) {
        this.color = color;
        return this;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarEntity setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CarEntity{");
        sb.append("id='").append(id).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", licensePlate='").append(licensePlate).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
