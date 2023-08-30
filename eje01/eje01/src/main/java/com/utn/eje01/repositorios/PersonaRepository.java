package com.utn.eje01.repositorios;

import com.utn.eje01.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long> {

}
