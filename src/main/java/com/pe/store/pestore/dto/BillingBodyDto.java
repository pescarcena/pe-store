package com.pe.store.pestore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillingBodyDto {

    private Long id;

    private Integer count;

    private String item;

    private BigDecimal price;
}
