package com.pe.store.pestore.service;

import com.pe.store.pestore.dto.BillingBodyDto;
import com.pe.store.pestore.dto.BillingHeaderDto;
import com.pe.store.pestore.entity.BillingBody;
import com.pe.store.pestore.entity.BillingHeader;
import com.pe.store.pestore.repository.BillingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    private BillingRespository billingRespository;

    @Autowired
    public BillingServiceImpl(BillingRespository billingRespository) {
        this.billingRespository = billingRespository;
    }


    public Flux<BillingHeaderDto> getAll(){
        List<BillingHeaderDto> list = billingRespository.findAll().stream().map(x -> entityToDto(x)).collect(Collectors.toList());
        return Mono.just(list).flatMapMany(Flux::fromIterable);
    }


    private BillingHeaderDto entityToDto(BillingHeader billingHeader){
        BillingHeaderDto dto = new BillingHeaderDto();
        dto.setFirstName(billingHeader.getFirstName());
        dto.setLastName(billingHeader.getLastName());
        dto.setId(billingHeader.getId());
        List<BillingBodyDto> listItems = new ArrayList<>();
        for(BillingBody body : billingHeader.getListItems()){
            BillingBodyDto billingBodyDto = new BillingBodyDto();
            billingBodyDto.setCount(body.getCount());
            billingBodyDto.setItem(body.getItem());
            billingBodyDto.setPrice(body.getPrice());
            billingBodyDto.setId(body.getId());

            listItems.add(billingBodyDto);
        }
        dto.setListItems(listItems);

        return dto;

    }

    @Transactional
    public void add(BillingHeaderDto billingHeaderDto) {
        BillingHeader header = new BillingHeader();
        header.setFirstName(billingHeaderDto.getFirstName());
        header.setLastName(billingHeaderDto.getLastName());

        List<BillingBody> list = new ArrayList<>();
        for (BillingBodyDto billingBodyDto : billingHeaderDto.getListItems()) {
            BillingBody body = new BillingBody();
            body.setCount(billingBodyDto.getCount());
            body.setItem(billingBodyDto.getItem());
            body.setPrice(billingBodyDto.getPrice());
            body.setBillingHeader(header);
            list.add(body);
        }
        header.setListItems(list);

        billingRespository.save(header);

    }


}
