package com.desafiolatam.facade;

import java.util.ArrayList;
import java.util.List;
import com.desafiolatam.dao.CategoriaDao;
import com.desafiolatam.dao.CategoriaDaoImpl;
import com.desafiolatam.dao.ProductoCategoriaDao;
import com.desafiolatam.dao.ProductoCategoriaDaoImpl;
import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dao.ProductoDaoImpl;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;
import com.desafiolatam.modelo.ProductoCategoria;

public class Facade {

	ProductoDao productoDao = new ProductoDaoImpl();
	CategoriaDao categoriaDao = new CategoriaDaoImpl();	
	ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImpl();
	Producto producto = new Producto();
	List<Categoria> listaCategorias = new ArrayList<>();
	
	public List<Categoria> listarCategorias() {
		
		listaCategorias = categoriaDao.listarCategorias();
		return listaCategorias;
	}
	
	
	public List<ProductoCategoria> listarProductoCategoria(){
		
		return productoCategoriaDao.listarProductoCategoria();
	}
	
	public boolean registrarProducto(Producto producto) {
		return productoDao.registrarProducto(producto);
	}
	
	public int obtenerUltimoId() {
		return productoDao.obtenerUltimoId();
	}
	
	public boolean modificarProducto(Producto producto) {
		return productoDao.modificarProducto(producto);
	}
	
	public Producto buscarProducto(int id) {
		return productoDao.buscarProducto(id);
	}
	
	public boolean eliminarProducto(int id) {
		return productoDao.eliminarProducto(id);
	}
}
