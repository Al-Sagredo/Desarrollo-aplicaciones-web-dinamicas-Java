package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MostrarForm")
public class MostrarForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //envía la info al jsp final
		request.getRequestDispatcher("MostrarForm.jsp").forward(request, response);
	    
	}
	

}
