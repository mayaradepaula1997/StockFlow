package com.java.stockflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    //Definimos a valor inicial como true
    @Column(name = "active", nullable = false)
    private boolean active = true;

   //CONSTRUTOR
    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;

    }

    //GETTER AND SETTER
    public Long getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
