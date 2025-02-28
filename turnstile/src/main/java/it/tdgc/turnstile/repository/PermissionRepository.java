package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}