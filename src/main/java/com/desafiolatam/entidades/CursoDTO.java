package com.desafiolatam.entidades;

public class CursoDTO {
	
	private String idCurso;
	
	private String descripcion;
	
	private double precio;
	
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String string) {
		this.idCurso = string;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descricion) {
		this.descripcion = descricion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
