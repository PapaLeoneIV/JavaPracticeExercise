package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.InsideOffice;

@Repository
public interface InsideOfficeRepository extends JpaRepository<InsideOffice, Long> {

}