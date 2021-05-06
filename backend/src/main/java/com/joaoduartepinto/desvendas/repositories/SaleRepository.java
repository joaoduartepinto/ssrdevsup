package com.joaoduartepinto.desvendas.repositories;

import com.joaoduartepinto.desvendas.dto.SaleSuccessDTO;
import com.joaoduartepinto.desvendas.dto.SalesSumDTO;
import com.joaoduartepinto.desvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    // Do a specific Query
    @Query("SELECT new com.joaoduartepinto.desvendas.dto.SalesSumDTO(sale.seller, SUM(sale.amount) ) "
            + "from Sale as sale GROUP BY sale.seller")
    List<SalesSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.joaoduartepinto.desvendas.dto.SaleSuccessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals)) "
            + "from Sale as sale GROUP BY sale.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
