package com.example.PracticoPersistencia.Repositories;

import ch.qos.logback.core.net.server.Client;
import com.example.PracticoPersistencia.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
