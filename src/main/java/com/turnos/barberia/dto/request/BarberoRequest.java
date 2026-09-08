package com.turnos.barberia.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BarberoRequest {
    private String nombre;
    private String email;
}
