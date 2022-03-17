package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;


@WebServlet("/RegistrarProducto")
public class RegistrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Facade facade = new Facade();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtiene lista de categorías
		
		List<Categoria> categorias = facade.listarCategorias();
		
		//adjunta la lista al request para mostrar en formulario
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("RegistrarProducto.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//obtiene datos ingresados en el formulario de RegistrarProducto.jsp
		String nombre = request.getParameter("nombre");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("desc");
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		
		//obtiene el valor maximo de la columna id_producto y le suma 1
		int id = facade.obtenerUltimoId() + 1;
		
		Producto producto = new Producto();
		//asigna los atributos rescatados del formulario al nuevo objeto producto
		producto.setId(id);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setDescripcion(descripcion);
		producto.setIdCategoria(idCategoria);
		//llama al metodo que hace el registro del objeto creado
		facade.registrarProducto(producto);
		request.getRequestDispatcher("Home.jsp").forward(request,response);
	}

}
