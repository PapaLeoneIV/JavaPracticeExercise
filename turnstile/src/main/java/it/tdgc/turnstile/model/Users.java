package it.tdgc.turnstile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name = "users", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @Getter private Long id;

    @Column(name = "name", nullable = false, length = 50)
    @Getter @Setter private String name;

    @Column(name = "surname", nullable = false, length = 50)
    @Getter @Setter private String surname;

    @Column(name = "email", nullable = false, length = 100)
    @Getter @Setter private String email;

    public Users(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Users() {
    }     
}