package com.turnos.barberia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "turnos")
@Setter
@Getter

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    private Boolean pago;

    @ManyToOne
    @JoinColumn(name = "barbero_id", nullable = false)
    private Barbero barbero;

    @ManyToOne
    @JoinColumn(name = "corte_id", nullable = false)

}
