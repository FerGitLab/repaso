package com.repaso.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private int edad;
	@ManyToOne
	@JoinColumn(name = "cargo")
	private Cargos cargo;
	
	public Persona() {

	}

	public Persona(String nombre, int edad, Cargos cargo) {
		this.nombre = nombre;
		this.edad = edad;
		this.cargo = cargo;
	}

	public Persona(int id) {
		this.id = id;
	}

	public Persona(int id, String nombre, int edad, Cargos cargo) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}
	
	

}
