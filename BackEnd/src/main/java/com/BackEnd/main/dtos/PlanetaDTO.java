package com.BackEnd.main.dtos;

import java.io.Serializable;

public class PlanetaDTO implements Serializable{
		private int id;
		private String nombre;
		private String dencidad;
		private String tamanio;
		
		private EstrellaDTO estrellaDTO;
		
		//CONTRUCTOR DTO
		public PlanetaDTO(String nombre, String dencidad, String tamanio, EstrellaDTO estrellaDTO) {
			this.nombre = nombre;
			this.dencidad = dencidad;
			this.tamanio = tamanio;
			this.estrellaDTO = estrellaDTO;
		}
		
		public PlanetaDTO() {
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

		public EstrellaDTO getEstrellaDTO() {
			return estrellaDTO;
		}

		public void setEstrellaDTO(EstrellaDTO estrellaDTO) {
			this.estrellaDTO = estrellaDTO;
		}

		

		
		
		
		
}
