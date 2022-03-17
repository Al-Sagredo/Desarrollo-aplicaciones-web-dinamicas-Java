package com.desafiolatam.dao;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.ConexionDatabase;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;
import com.desafiolatam.modelo.ProductoCategoria;

public class ProductoCategoriaDaoImpl extends ConexionDatabase implements ProductoCategoriaDao {

	ProductoDao productoDao = new ProductoDaoImpl();
	CategoriaDao categoriaDao = new CategoriaDaoImpl();
	
	
	//retorna una lista de objetos ProductoCategoria donde cada uno tiene como atributos un objeto Producto y un objeto Categoría
	@Override
	public List<ProductoCategoria> listarProductoCategoria() {
		
		//obtiene lista de productos
		List<Producto> listaProductos = productoDao.listarProductos();
		
		List<ProductoCategoria> lista = new ArrayList<>();
		
		for(Producto prod:listaProductos) {
			//para cada objeto Producto de la lista de productos, obtenemos su id y con este obtenemos su categoría
			Categoria categoria = categoriaDao.buscarCategoria(prod.getIdCategoria());
			/*System.out.println("Categoria nombre:" + categoria.getNombre());
			System.out.println("Categoria id:" + categoria.getId());
			System.out.println("");*/
		
			//crea objeto ProductoCategoria y le asigna los objetos Producto y Categoria como atributos
			ProductoCategoria prodCategoria = new ProductoCategoria(prod, categoria);
			/*System.out.println("Categoria nombre: " + prodCategoria.getCategoria().getNombre());
			System.out.println("Categoria id: " + prodCategoria.getCategoria().getId());
			System.out.println("Producto id categoria: " + prodCategoria.getProducto().getIdCategoria());
			System.out.println("Producto id : " + prodCategoria.getProducto().getIdCategoria());
			System.out.println("Producto nombre: " + prodCategoria.getProducto().getNombre());
			
			System.out.println("");*/
			
			lista.add(prodCategoria);
		}
		return lista;
	}

}
