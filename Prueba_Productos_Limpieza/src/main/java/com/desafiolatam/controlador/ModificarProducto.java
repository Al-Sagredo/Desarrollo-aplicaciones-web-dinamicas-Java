package com.desafiolatam.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;


@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtiene el id del producto que viene desde el form
		int id = Integer.parseInt(request.getParameter("id_producto"));
		
		//obtiene el objeto producto a partir de su id
		Facade facade = new Facade();
		Producto prod = facade.buscarProducto(id);
		
		//obtiene lista de categorias
		List<Categoria> listaCategorias = facade.listarCategorias();
		
		//envia para mostrar a modificar.jsp un objeto Producto y una lista de categorias
		request.setAttribute("producto", prod);
		request.setAttribute("categorias", listaCategorias);
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//obtiene los parametros desde el form ModificarProducto.jsp
		String nombre = request.getParameter("nombre");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		int id_producto = Integer.parseInt(request.getParameter("id_producto"));
		int id_categoria = Integer.parseInt(request.getParameter("categoria"));
		
		Producto prod = new Producto();
		prod.setNombre(nombre);
		prod.setDescripcion(descripcion);
		prod.setId(id_producto);
		prod.setPrecio(precio);
		prod.setIdCategoria(id_categoria);
		
		Facade facade = new Facade();
		facade.modificarProducto(prod);
		
		request.getRequestDispatcher("Home").forward(request, response);
	}

}
