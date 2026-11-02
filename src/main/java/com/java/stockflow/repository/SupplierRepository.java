package com.java.stockflow.repository;

import com.java.stockflow.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository  extends JpaRepository<Supplier, Long> {


    //Verificar se o fornecer existe ou não no BD
    boolean existsByDocument(String document);
}
