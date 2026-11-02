package com.java.stockflow.repository;

import com.java.stockflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Retornar o usuario pelo email
    Optional<User> findByEmail(String email);

    //Verificar se o email existe ou não no BD
    boolean existsByEmail(String email);
}
