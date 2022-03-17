package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Categoria;

public interface CategoriaDao {

	public List<Categoria> listarCategorias();
	public Categoria buscarCategoria(int id);
	
	
}
