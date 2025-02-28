package it.tdgc.turnstile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tdgc.turnstile.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}