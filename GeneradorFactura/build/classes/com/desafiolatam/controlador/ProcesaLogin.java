package com.desafiolatam.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/procesameLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declara los valores esperados para login válido
	private final String LOGIN = "usuario1";
	private final String PASS= "password";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//obtiene campos ingresados en el form del jsp
		String requestUser = request.getParameter("login");
		String requestPass = request.getParameter("pass");
		
		
		
		if(LOGIN.contentEquals(requestUser) && PASS.contentEquals(requestPass)) { //login correcto
			//crea variable de sesion
			HttpSession miSesion = request.getSession(true);
			miSesion.setAttribute("nombre", requestUser);
			//envía al usuario al siguiente servlet
			request.getRequestDispatcher("RecibeForm.jsp").forward(request, response); 
		}
		else {
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Usuario o password incorrecto');");
			   out.println("location='IngresoValores.jsp';");
			   out.println("</script>");
		}
		
	}

}
