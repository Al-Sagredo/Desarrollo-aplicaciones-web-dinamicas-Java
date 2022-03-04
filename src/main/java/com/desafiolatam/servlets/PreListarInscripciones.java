package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.entidades.InscripcionDTO;

@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = new Facade();
		List<InscripcionDTO> listaInscripciones = null;
		
		try {
			listaInscripciones = facade.obtieneInscripciones();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//guardo las listas al request
		request.setAttribute("inscripciones", listaInscripciones);
		
		//mandamos el request a la pagina jsp
		request.getRequestDispatcher("ListaInscripciones.jsp").forward(request, response);

	}

}
