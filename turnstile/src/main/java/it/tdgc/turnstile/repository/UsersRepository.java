package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}