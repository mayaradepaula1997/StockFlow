package com.java.stockflow.entity;

import com.java.stockflow.enums.UserEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 150)
   private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

   @Enumerated(EnumType.STRING)
   @Column(name = "role", nullable = false)
   private UserEnum role;


    //CONSTRUTOR
    public User() {
    }

    public User(String name, String email, String password, UserEnum role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEnum getRole() {
        return role;
    }

    public void setRole(UserEnum role) {
        this.role = role;
    }
}
