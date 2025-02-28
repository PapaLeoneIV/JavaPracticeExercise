package it.tdgc.turnstile.model;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="transactions", schema="public")
public class Transaction{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_id_seq")
    @SequenceGenerator(name = "transactions_id_seq", sequenceName = "transactions_id_seq", allocationSize = 1)
    @Getter private Long id;
    
    @Column(name = "date", nullable = false)
    @Getter @Setter private LocalDate date;
    
    @Column(name = "enter_time", nullable = false)
    @Getter @Setter private LocalTime enter_time;

    @Column(name = "exit_time")
    @Getter @Setter private LocalTime exit_time;

    @Column(name = "current_state", nullable = false, length=50)
    @Getter @Setter private String current_state;

    @ManyToOne
    @JoinColumn(name = "turnstile_id")
    @Getter @Setter private Turnstile turnstile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private Users user;

    
    public Transaction(LocalDate date, LocalTime enter_time, LocalTime exit_time, String current_state) {
        this.date = date;
        this.enter_time = enter_time;
        this.exit_time = exit_time;
        this.current_state = current_state;
    }

    public Transaction(LocalDate date, LocalTime enter_time, LocalTime exit_time, String current_state, Turnstile turnstile, Users user) {
        this.date = date;
        this.enter_time = enter_time;
        this.exit_time = exit_time;
        this.current_state = current_state;
        this.turnstile = turnstile;
        this.user = user;
    }
    
    
    public Transaction() {
    }


}