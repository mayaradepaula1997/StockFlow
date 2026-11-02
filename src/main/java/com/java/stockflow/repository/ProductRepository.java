package com.java.stockflow.repository;

import com.java.stockflow.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    //Buscando o produto pelo nome, utilizamos o Optional, porque esse produto pode existir ou não
   Optional<Product> findByName(String name);


   //Vamos buscar todos os produtos atraves do id da categoria
    List<Product> findByCategoryId(Long categoryId);

    //Verifica se o produto com aquele nome existe no BD
    boolean existsByName(String name);

    //Busca produtos com quantidade inferior ao valor informado
    List<Product> findByQuantityLessThan(Integer quantity);
}
