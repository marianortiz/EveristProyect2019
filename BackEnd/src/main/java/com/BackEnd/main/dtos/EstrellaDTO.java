package com.BackEnd.main.dtos;

public class EstrellaDTO {
	
	private int id;
	private String nombre;
	private float tamanio;
	
	//CONSTRUCTOR DTO
	public EstrellaDTO(String nombre, float tamanio) {
		
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public EstrellaDTO() {
	}
	
	//GETTER AND SETTER
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

	public float getTamanio() {
		return tamanio;
	}

	public void setTamanio(float tamanio) {
		this.tamanio = tamanio;
	}

	
	
	
}
