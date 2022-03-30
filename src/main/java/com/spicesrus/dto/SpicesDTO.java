package com.spicesrus.dto;

import com.spicesrus.model.Spices;

import java.util.List;

public class SpicesDTO {

    private String name;
    private String category;
    private String description;
    private Double price;
    private List<Spices> complimentarySpices;
    private String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Spices> getComplimentarySpices() {
        return complimentarySpices;
    }

    public void setComplimentarySpices(List<Spices> complimentarySpices) {
        this.complimentarySpices = complimentarySpices;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
