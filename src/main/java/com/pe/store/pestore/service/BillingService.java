package com.pe.store.pestore.service;

import com.pe.store.pestore.dto.BillingHeaderDto;
import reactor.core.publisher.Flux;

public interface BillingService {
    public void add(BillingHeaderDto billingHeaderDto);

    public Flux<BillingHeaderDto> getAll();

}
