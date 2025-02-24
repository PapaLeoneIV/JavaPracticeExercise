package it.tdgc.turnstile.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    final private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee entity) {
        employeeRepository.save(entity);
    }

    public void deleteEmployee() {
        // Delete employee
    }

    public void updateEmployee() {
        // Update employee
    }

    public Long getEmployee(Long id) {
        return this.employeeRepository.findById(id).get().getId();
    }
}
