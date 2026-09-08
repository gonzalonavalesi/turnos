package com.turnos.barberia.repository;

import com.turnos.barberia.dto.request.BarberoRequest;
import com.turnos.barberia.model.Barbero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BarberoRepository extends JpaRepository<Barbero, Long> {

    @Query("SELECT new com.turnos.barberia.dto.request.BarberoRequest(b.nombre) FROM Barbero b")
    List<BarberoRequest> findAllBarberoRequests();

    boolean existsByEmail(String email);
}
