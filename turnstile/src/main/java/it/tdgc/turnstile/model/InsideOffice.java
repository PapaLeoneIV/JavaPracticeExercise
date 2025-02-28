package it.tdgc.turnstile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="inside_office", schema="public")
public class InsideOffice{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inside_office_id_seq")
    @SequenceGenerator(name = "inside_office_id_seq", sequenceName = "inside_office_id_seq", allocationSize = 1)
    @Getter private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private Users user;

    public InsideOffice() {
    }

    public InsideOffice(Users user) {
        this.user = user;
    }
}