package it.tdgc.turnstile.employee;


import java.util.Set;

import it.tdgc.turnstile.employeerole.EmployeeRole;
import it.tdgc.turnstile.logs.Log;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee", schema="public")
public class Employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name", nullable=false)
    private String name;

    @Column(name = "surname", nullable=false)
    private String surname;

    @Column(name = "email", nullable=false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private EmployeeRole role;

    @OneToMany(mappedBy = "employee")
    private Set<Log> logs;
    
    public Employee(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Employee(long id, String name, String surname, String email, EmployeeRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }   

    

    public Employee() {}

   



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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return EmployeeRole return the role
     */
    public EmployeeRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(EmployeeRole role) {
        this.role = role;
    }


    /**
     * @return Set<Log> return the logs
     */
    public Set<Log> getLogs() {
        return logs;
    }

    /**
     * @param logs the logs to set
     */
    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

}
