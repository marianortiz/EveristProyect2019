package com.BackEnd.main.entidades;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table (name = "Planeta")
public class Planeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int id;
	
	@Column(name = "p_nombre", unique = true)
	private String nombre;
	
	@Column(name = "p_dencidad")
	private String dencidad;
	
	@Column(name = "p_tamaño")
	private String tamanio;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "estrella_fk")
	private Estrella estrella;
	
	//CONSTRUCTOR
	public Planeta(String nombre, String dencidad, String tamanio) {
		this.nombre = nombre;
		this.dencidad = dencidad;
		this.tamanio = tamanio;
	}
	
	public Planeta() {
		
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
	public String getDencidad() {
		return dencidad;
	}
	public void setDencidad(String dencidad) {
		this.dencidad = dencidad;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Estrella getEstrella() {
		return estrella;
	}

	public void setEstrella(Estrella estrella) {
		this.estrella = estrella;
	}
	
	
	
	
	
}
