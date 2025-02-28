package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}