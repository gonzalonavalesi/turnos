package com.turnos.barberia.service;

import com.turnos.barberia.dto.request.BarberoRequest;
import com.turnos.barberia.dto.response.BarberoResponse;
import com.turnos.barberia.model.Barbero;
import com.turnos.barberia.repository.BarberoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.turnos.barberia.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BarberoService {

    private final BarberoRepository barberoRepository;

    public BarberoResponse alta(Barbero barbero) {
        if(barberoRepository.existsByEmail(barbero.getEmail())){
            throw new IllegalArgumentException("Ya existe un barbero con ese email");
        }
        Barbero barberoGuardado = barberoRepository.save(barbero);
        BarberoResponse barberoResponse=new BarberoResponse();
        barberoResponse.setNombre(barberoGuardado.getNombre());
        return barberoResponse;
    }

    public BarberoResponse baja(Long id){
        Barbero barbero = barberoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barbero not found with id " + id));
        BarberoResponse barberoResponse=new BarberoResponse();
        barberoResponse.setNombre(barbero.getNombre());
        barberoRepository.deleteById(id);

        return barberoResponse;
    }

    public Barbero recuperarPassword(Long id, String password){
        Barbero barbero= barberoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("no se encontro barbero con esa id"));
        barbero.setPassword(password);
        return  barberoRepository.save(barbero);
    }

    public BarberoRequest mostrarXid (Long id){
        Barbero barbero=barberoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("no se encontro barbero con esa id"));
        BarberoRequest barberoRequest=new BarberoRequest();
        barberoRequest.setNombre(barbero.getNombre());
        return barberoRequest;

    }

    public List<BarberoRequest> mostrarTodos() {
        return barberoRepository.findAllBarberoRequests();
    }
}
