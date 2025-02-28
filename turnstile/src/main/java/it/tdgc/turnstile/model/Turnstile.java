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
@Table  (name = "turnstile", schema = "public")
public class Turnstile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnstile_id_seq")
    @SequenceGenerator(name = "turnstile_id_seq", sequenceName = "turnstile_id_seq", allocationSize = 1)
    @Getter private Long id;
    
    @Column(name = "available", columnDefinition = "BOOLEAN DEFAULT TRUE")
    @Getter @Setter private boolean available;

    public Turnstile(boolean available) {
        this.available = available;
    }
 
    public Turnstile() {
    }
}