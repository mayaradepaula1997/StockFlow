package com.java.stockflow.entity;

import com.java.stockflow.enums.MovementType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Para controlar se o produto está entrando ou saindo
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MovementType movementType;

    //Quantidade movimentada
    @Positive
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    //Observacao do movimento
    @Column(name = "observation")
    private String observation;

    //RELACIONAMENTO
    //Varias movimentacoes podem estar relacionadas a um produto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    //Obs: nullable = true, permite que um movimentacao seja cadastrada sem o fornecedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier;

    // Usuario responsável pela movimentação
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //CONSTRUTOR
    public StockMovement() {
    }

    public StockMovement(MovementType movementType, Integer quantity, String observation, Product product, Supplier supplier, User user) {
        this.movementType = movementType;
        this.quantity = quantity;
        this.observation = observation;
        this.product = product;
        this.supplier = supplier;
        this.user = user;
    }

    @PrePersist //Método deve ser executado antes da persistência
    public void prePersist(){
        this.date = LocalDateTime.now();
    }

    //GETTER AND SETTER

    public Long getId() {
        return id;
    }

   public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
