package com.repaso.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cargos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cargo;
	
	public Cargos() {

	}
	public Cargos(int id) {
		this.id = id;
	}
	public Cargos(String cargo) {
		this.cargo = cargo;
	}
	public Cargos(int id, String cargo) {
		this.id = id;
		this.cargo = cargo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
		
}
