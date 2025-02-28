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
@Table(name = "badge", schema="public")
public class Badge {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "badge_id_seq")
    @SequenceGenerator(name = "badge_id_seq", sequenceName = "badge_id_seq", allocationSize = 1)
    @Getter private Long id;


    @Column(name = "rfid", nullable=false)
    @Getter @Setter private String rfid;

    public Badge(String rfid) {
        this.rfid = rfid;
    }

    public Badge() {
    }
}
