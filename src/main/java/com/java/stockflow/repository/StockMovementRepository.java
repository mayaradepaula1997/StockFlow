package com.java.stockflow.repository;

import com.java.stockflow.entity.StockMovement;

import com.java.stockflow.enums.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long>, JpaSpecificationExecutor<StockMovement> {


    //Busca varios movimentos de estoque pelo id do produto
    List<StockMovement> findByProductId(Long productId);

    //Busca varios movimentos de estoque pelo id do fornecedor
    List<StockMovement> findBySupplierId(Long supplierId);

    //Busca varios movimentos de estoque pelo id do usuário
    List<StockMovement> findByUserId(Long userId);

    //Busca varios movimentos de estoque por um periodo de data (inicio e fim)
    List<StockMovement> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //Buscar varios movimento pelo seu tipo (entrada e saída)
    List<StockMovement> findByMovementType(MovementType movementType);
}
