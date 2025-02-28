package it.tdgc.turnstile.model;

import java.time.LocalDateTime;

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
@Table(name = "transaction_event", schema="public")
public class TransactionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_event_id_seq")
    @SequenceGenerator(name = "transaction_event_id_seq", sequenceName = "transaction_event_id_seq", allocationSize = 1)
    @Getter private Long id;

    
    @Column(name = "state", nullable = false)
    @Getter @Setter private String state;
    
    @Column(name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Getter @Setter private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @Getter @Setter private Transaction transaction;

    public TransactionEvent(String state, LocalDateTime created_at) {
        this.state = state;
        this.created_at = created_at;
    }

    public TransactionEvent(String state, LocalDateTime created_at, Transaction transaction) {
        this.state = state;
        this.created_at = created_at;
        this.transaction = transaction;
    }
    
    public TransactionEvent() {
    }


}