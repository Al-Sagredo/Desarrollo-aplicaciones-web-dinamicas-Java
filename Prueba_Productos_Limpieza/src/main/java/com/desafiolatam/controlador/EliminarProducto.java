package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Producto;

@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Facade facade = new Facade();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id_producto"));
		Producto p = facade.buscarProducto(id);
		String nombreProducto = p.getNombre();
		request.setAttribute("nombre_producto", nombreProducto);
		request.setAttribute("id_producto", id);
		request.getRequestDispatcher("EliminarProducto.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id_producto = Integer.parseInt((request).getParameter("id"));
		facade.eliminarProducto(id_producto);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);

	}

}
