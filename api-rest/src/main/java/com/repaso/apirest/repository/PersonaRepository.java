package com.repaso.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.apirest.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
}
