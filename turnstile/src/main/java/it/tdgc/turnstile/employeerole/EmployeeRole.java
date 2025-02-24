package it.tdgc.turnstile.employeerole;

import java.util.Set;

import it.tdgc.turnstile.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class EmployeeRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_seq", sequenceName = "role_id_seq", allocationSize = 1)
    private long id;
    
    @Column(name ="level", nullable=false)
    private int level;
    @Column(name ="description", nullable=false)
    private String description;
    
    @OneToMany(mappedBy = "role")
    private Set<Employee> employees;

    
    public EmployeeRole(String description, int level) {
        this.description = description;
        this.level = level; 
    }

    public EmployeeRole() {}




    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return int return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }




    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return Set<Employee> return the employees
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
