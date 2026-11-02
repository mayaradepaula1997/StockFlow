package com.java.stockflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    //precision, quantidade total de digito | scale, quantidade de casas decimais
    @DecimalMin(value = "0.00", inclusive = true)  //Valores nao podem ser negativos
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    //Representa a quantidade atual do estoque
    @Min(0) //Nao é permitido quantidades negativas
    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Min(0)
    //Representa a quantidade minima que o estoque deve ter
    @Column(name = "minimum_quantity",nullable = false)
    private Integer minimumQuantity;

    //RELACIONAMENTO
    //Varios produtos pertencem a uma categoria
    @ManyToOne(fetch = FetchType.LAZY)                   //Categorias carregadas sobre demanda
    @JoinColumn(name = "category_id", nullable = false)  //Nome da coluna na tabela de produto
    private Category category;

    //CONSTRUTOR
    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Integer quantity, Integer minimumQuantity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.category = category;
    }

    //GETTER E SETTER
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
