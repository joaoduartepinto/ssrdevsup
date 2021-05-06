package com.joaoduartepinto.desvendas.dto;

import com.joaoduartepinto.desvendas.entities.Seller;

import java.io.Serializable;

public class SalesSumDTO implements Serializable {

    private String sellerName;
    private Double sum;

    public SalesSumDTO(Seller seller, Double sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
