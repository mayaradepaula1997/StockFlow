package com.java.stockflow.entity;

//CLASSE DE FORNECEDOR

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tbl_supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //CPF OU CNPJ
    //Define o tanhamo maximo do numero do documento
    @Column(name = "document", length = 14, unique = true, nullable = false)
    private String document;

    //Define o tamanho maxino do endereco de email
    @Email //Valida o formato do email
    @Column(name = "email", length = 150, nullable = false)
    private String email;

    //Define a tamanho maximo do numero de telefone
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    //CONSTRUTOR
    public Supplier() {
    }

    public Supplier(String name, String document, String email, String phone, String address) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
