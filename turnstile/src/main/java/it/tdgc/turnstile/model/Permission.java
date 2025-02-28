package it.tdgc.turnstile.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
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
@Table(name="permissions", schema="public")
public class Permission{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_id_seq")
    @SequenceGenerator(name = "permissions_id_seq", sequenceName = "permissions_id_seq", allocationSize = 1)
    @Getter private Long id;

    @Column(name = "allowed_enter_time", nullable = false)
    @Getter @Setter private LocalTime  allowed_enter_time;

    @Column(name = "allowed_exit_time", nullable = false)
    @Getter @Setter private LocalTime allowed_exit_time;

    @Column(name = "end_of_permission", nullable = false)
    @Getter @Setter private LocalDate end_of_permission;

    @OneToOne
    @JoinColumn(name = "role_id")
    @Getter @Setter private Role role;

    

    public Permission(LocalTime allowed_enter_time, LocalTime allowed_exit_time, LocalDate end_of_permission) {
        this.allowed_enter_time = allowed_enter_time;
        this.allowed_exit_time = allowed_exit_time;
        this.end_of_permission = end_of_permission;
    }

    public Permission(LocalTime allowed_enter_time, LocalTime allowed_exit_time, LocalDate end_of_permission, Role role) {
        this.allowed_enter_time = allowed_enter_time;
        this.allowed_exit_time = allowed_exit_time;
        this.end_of_permission = end_of_permission;
        this.role = role;
    }

    public Permission() {
    }
}