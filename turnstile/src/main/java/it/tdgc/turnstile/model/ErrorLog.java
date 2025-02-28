package it.tdgc.turnstile.model;
import java.time.LocalDate;
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
@Table(name = "error_log", schema = "public")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "error_log_id_seq")
    @SequenceGenerator(name = "error_log_id_seq", sequenceName = "error_log_id_seq", allocationSize = 1)
    @Getter private Long id;

    @Column(name = "date", nullable = false)
    @Getter @Setter private LocalDate date;

    @Column(name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Getter @Setter private LocalDateTime created_at;

    @Column(name = "error_message", nullable = false, length=255)
    @Getter @Setter private String error_message;

    @ManyToOne
    @JoinColumn(name = "turnstile_id")
    @Getter @Setter private Turnstile turnstile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private Users user;

    public ErrorLog(LocalDate date, LocalDateTime created_at, String error_message) {
        this.date = date;
        this.created_at = created_at;
        this.error_message = error_message;
    }

    public ErrorLog(LocalDate date, LocalDateTime created_at, String error_message, Turnstile turnstile, Users user) {
        this.date = date;
        this.created_at = created_at;
        this.error_message = error_message;
        this.turnstile = turnstile;
        this.user = user;
    }
    
    public ErrorLog() {
    }

}