package com.pe.store.pestore.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class BillingBody {

    public BillingBody() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer count;

    private String item;

    private BigDecimal price;

    @NonNull
    @ManyToOne
    private BillingHeader billingHeader;
}
