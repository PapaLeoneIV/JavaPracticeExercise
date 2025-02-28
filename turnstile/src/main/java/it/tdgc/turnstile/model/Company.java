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
@Table(name = "company", schema="public")
public class Company{

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "badge_id_seq")
    @SequenceGenerator(name = "badge_id_seq", sequenceName = "badge_id_seq", allocationSize = 1)
    @Getter private Long id;

    @Column(name = "company_name", nullable=false, length=100)
    @Getter @Setter private String companyName;

    @Column(name = "address", nullable=false, length=100)
    @Getter @Setter private String address;

    public Company(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public Company() {
    }
    

}