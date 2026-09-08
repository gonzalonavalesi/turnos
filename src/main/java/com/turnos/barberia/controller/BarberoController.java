package com.turnos.barberia.controller;

import com.turnos.barberia.dto.request.BarberoRequest;
import com.turnos.barberia.dto.response.BarberoResponse;
import com.turnos.barberia.model.Barbero;
import com.turnos.barberia.service.BarberoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/barberos")
@RequiredArgsConstructor
public class BarberoController {

    private final BarberoService barberoService;

    @PostMapping
    public BarberoResponse crearBarbero(@RequestBody Barbero barbero){
        return barberoService.alta(barbero);
    }

    @DeleteMapping("/{id}")
    public BarberoResponse baja(@PathVariable Long id){
        return barberoService.baja(id);
    }

    @GetMapping("/{id}")
    public BarberoRequest mostrarXid(@PathVariable Long id){
        return barberoService.mostrarXid(id);
    }

    @GetMapping
    public List<BarberoRequest> mostrarTodos(){
        return barberoService.mostrarTodos();
    }
}


