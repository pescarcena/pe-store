package com.pe.store.pestore.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class BillingHeader {

    public BillingHeader() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "billingHeader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillingBody> listItems;
}
