package com.turnos.barberia.service;

import com.turnos.barberia.dto.request.BarberoRequest;
import com.turnos.barberia.model.Barbero;
import com.turnos.barberia.repository.BarberoRepository;
import lombok.RequiredArgsConstructor;
import com.turnos.barberia.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberoService {

    private final BarberoRepository barberoRepository;

    public Barbero alta(Barbero barbero) {
        return barberoRepository.save(barbero);
    }

    public Barbero baja(Long id){
        Barbero barbero = barberoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barbero not found with id " + id));
        barberoRepository.delete(barbero);
        return barbero;
    }

    public Barbero recuperarPassword(Long id, String password){
        Barbero barbero= barberoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("no se encontro barbero con esa id"));
        barbero.setPassword(password);
        return  barberoRepository.save(barbero);
    }
}
