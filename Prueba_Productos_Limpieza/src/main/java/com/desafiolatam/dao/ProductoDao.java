package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Producto;

public interface ProductoDao {

	public List<Producto> listarProductos();
	public Producto buscarProducto(int id);
	public boolean modificarProducto(Producto p);
	public int obtenerUltimoId();
	public boolean registrarProducto(Producto p);
	public boolean eliminarProducto(int id);
	
	
}
