package com.pe.store.pestore.controller;

import com.pe.store.pestore.dto.BillingHeaderDto;
import com.pe.store.pestore.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/store/v1/billing")
public class StoreController {


    private BillingService billingService;

    @Autowired
    public StoreController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<BillingHeaderDto> getById() {

        return billingService.getAll();
    }

    @PostMapping
    private void add(@RequestBody BillingHeaderDto dto) {
        billingService.add(dto);
    }
}
