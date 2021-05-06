package com.joaoduartepinto.desvendas.repositories;

import com.joaoduartepinto.desvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
