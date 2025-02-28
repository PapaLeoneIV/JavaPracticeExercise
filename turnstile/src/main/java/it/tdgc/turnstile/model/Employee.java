package it.tdgc.turnstile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee", schema = "public")
public class Employee extends Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    @Getter @Setter private Long id;


    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private Users user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @Getter @Setter
    private Company company;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    @Getter @Setter
    private Permission permission;

    @OneToOne
    @JoinColumn(name = "badge_id")
    @Getter @Setter
    private Badge badge;

    public Employee() {
    }

    public Employee(String name, String surname, String email) {
        super(name, surname, email);
    }
    

    public Employee(String name, String surname, String email, Users user, Role role, Company company, Permission permission, Badge badge) {
        super(name, surname, email);
        this.user = user;
        this.role = role;
        this.company = company;
        this.permission = permission;
        this.badge = badge;
    }
}