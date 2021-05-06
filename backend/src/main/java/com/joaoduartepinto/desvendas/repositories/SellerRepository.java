package com.joaoduartepinto.desvendas.repositories;

import com.joaoduartepinto.desvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
