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

import com.repaso.apirest.model.Cargos;
import com.repaso.apirest.repository.CargosRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CargosController {

	@Autowired
	private CargosRepository repository;
	
	@GetMapping("/cargo")
	public List<Cargos> getAll()
	{
		return repository.findAll();
	}
	
	@GetMapping("/cargo/{id}")
	public Cargos getById(@PathVariable("id") Integer id)
	{
		System.out.println(id);
		return repository.getOne(id);
	}
	
	@PostMapping("/cargo")
	public Cargos save(@RequestBody Cargos t)
	{
		return repository.save(t);
	}
	
	@PutMapping("/cargo")
	public Cargos edit(@RequestBody Cargos t)
	{
		return repository.save(t);
	}
	
	@DeleteMapping("/cargo/{id}")
	public Cargos remove(@PathVariable("id") Integer id)
	{
		Cargos t = repository.getOne(id);
		repository.delete(t);
		return t;
	}
	
}
