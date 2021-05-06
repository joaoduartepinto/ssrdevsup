package com.joaoduartepinto.desvendas.controllers;

import com.joaoduartepinto.desvendas.dto.SellerDTO;
import com.joaoduartepinto.desvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> sellersList = sellerService.findAll();

        return ResponseEntity.ok(sellersList);
    }
}
