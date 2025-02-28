package it.tdgc.turnstile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "role", schema = "public")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
    @Getter private Long id;

    @Column(name = "level", nullable = false)
    @Getter @Setter private int level;

    @Column(name = "description", nullable = false, length = 100)
    @Getter @Setter private String description;

    public Role(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public Role() {
    }
}