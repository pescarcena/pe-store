package com.pe.store.pestore.repository;

import com.pe.store.pestore.entity.BillingHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface BillingRespository extends JpaRepository<BillingHeader, Long> {

   Optional<BillingHeader> findById(Long id);
}
