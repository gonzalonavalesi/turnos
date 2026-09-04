package com.turnos.barberia.model;


import com.turnos.barberia.enums.TipoCorte;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cortes")
@Setter
@Getter

public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCorte tipoCorte;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
}
