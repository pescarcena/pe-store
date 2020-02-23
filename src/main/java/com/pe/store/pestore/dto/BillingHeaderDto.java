package com.pe.store.pestore.dto;

import lombok.Data;

import java.util.List;

@Data
public class BillingHeaderDto {
    private Long id;
    private String firstName;
    private String lastName;

    private List<BillingBodyDto> listItems;
}
