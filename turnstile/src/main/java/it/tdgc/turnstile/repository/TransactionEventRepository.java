package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.TransactionEvent;

@Repository
public interface TransactionEventRepository extends JpaRepository<TransactionEvent, Long> {

}