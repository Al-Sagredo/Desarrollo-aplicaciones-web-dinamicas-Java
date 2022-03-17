package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.ProductoCategoria;

@WebServlet("/MostrarProductos")
public class MostrarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	Facade facade = new Facade();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //llama al facade quien llama al dao para obtener una lista de objetos ProductoCategoria
		//redirecciona al jsp MostrarProductos enviando esta lista
		List<ProductoCategoria> lista = facade.listarProductoCategoria();
		
		request.setAttribute("listaPC", lista);
		request.getRequestDispatcher("MostrarProductos.jsp").forward(request, response);
	}
}
