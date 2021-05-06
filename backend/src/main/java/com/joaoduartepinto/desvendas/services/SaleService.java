package com.joaoduartepinto.desvendas.services;

import com.joaoduartepinto.desvendas.dto.SaleDTO;
import com.joaoduartepinto.desvendas.entities.Sale;
import com.joaoduartepinto.desvendas.repositories.SaleRepository;
import com.joaoduartepinto.desvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SellerRepository sellerRepository;

    // https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        // To avoid making multiple inquiries for each seller
        sellerRepository.findAll();

        Page<Sale> result = saleRepository.findAll(pageable);

        return result.map(sale -> new SaleDTO(sale));
    }
}
