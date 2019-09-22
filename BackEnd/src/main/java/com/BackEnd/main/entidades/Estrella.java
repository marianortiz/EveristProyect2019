package com.BackEnd.main.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estrella")
public class Estrella {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private int id;
	
	@Column(name = "e_nombre", unique =  true)
	private String nombre;
	
	@Column(name = "e_tamaño")
	private float tamanio;
	
	@OneToMany(mappedBy ="estrella")
	private List<Planeta> planeta = new ArrayList<>();
	
	
	//CONSTRUCTOR
	public Estrella(String nombre, float tamanio) {
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public Estrella() {
		
	}
	
	//GETTER AND SETTER
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
