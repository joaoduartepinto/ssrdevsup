package com.joaoduartepinto.desvendas.controllers;

import com.joaoduartepinto.desvendas.dto.SaleDTO;
import com.joaoduartepinto.desvendas.dto.SaleSuccessDTO;
import com.joaoduartepinto.desvendas.dto.SalesSumDTO;
import com.joaoduartepinto.desvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {

        Page<SaleDTO> salePage = saleService.findAll(pageable);

        return ResponseEntity.ok(salePage);
    }

    @GetMapping("/sum-by-seller")
    public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller() {

        List<SalesSumDTO> amountGroupedBySeller = saleService.amountGroupedBySeller();

        return ResponseEntity.ok(amountGroupedBySeller);
    }

    @GetMapping("/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {

        List<SaleSuccessDTO> successGroupedBySeller = saleService.successGroupedBySeller();

        return ResponseEntity.ok(successGroupedBySeller);
    }
}
