package com.repaso.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repaso.apirest.model.Persona;
import com.repaso.apirest.repository.PersonaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	PersonaRepository repository;
	
	@GetMapping("/persona")
	public List<Persona> getAll()
	{
		return repository.findAll();
	}
	
	@GetMapping("/persona/{id}")
	public Persona getById(@PathVariable("id") Integer id)
	{
		System.out.println(id);
		return repository.getOne(id);
	}
	
	@PostMapping("/persona")
	public Persona save(@RequestBody Persona t)
	{
		return repository.save(t);
	}
	
	@PutMapping("/persona")
	public Persona edit(@RequestBody Persona t)
	{
		return repository.save(t);
	}
	
	@DeleteMapping("/persona/{id}")
	public Persona remove(@PathVariable("id") Integer id)
	{
		Persona t = repository.getOne(id);
		repository.delete(t);
		return t;
	}

}
