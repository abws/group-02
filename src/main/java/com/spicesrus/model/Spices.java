package com.spicesrus.model;

import com.spicesrus.dto.SpicesDTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Spices implements Serializable {
    private static final long serialVersionUID = 4261824342100056906L;


    @Id
    private String name;

    private String category;
    private String description;
    private Double price;

    @OneToMany
    @JoinColumn
    private List<Spices> complimentarySpices;
    private String picture;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Spices> getComplimentarySpices() {
        return complimentarySpices;
    }

    public void setComplimentarySpices(List<Spices> complimentarySpices) {
        this.complimentarySpices = complimentarySpices;
    }

    public void addComplimentarySpices(Spices spice) {
        this.complimentarySpices.add(spice);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public double getUserPrice() {
        return price * 0.8; // 20% discount
    }

    public SpicesDTO toDTO() {
        SpicesDTO dto = new SpicesDTO();
        dto.setName(name);
        dto.setDescription(description);
        dto.setCategory(category);
        dto.setPrice(price);
        dto.setPicture(picture);
        dto.setComplimentarySpices(complimentarySpices);
        return dto;
    }

}
