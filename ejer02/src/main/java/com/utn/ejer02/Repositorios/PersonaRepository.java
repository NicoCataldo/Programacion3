package com.utn.ejer02.Repositorios;

import com.utn.ejer02.Entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long> {
}
