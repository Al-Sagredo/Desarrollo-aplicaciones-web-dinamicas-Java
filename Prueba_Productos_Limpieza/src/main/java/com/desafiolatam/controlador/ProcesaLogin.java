package com.desafiolatam.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProcesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String user = "alvaro";
	private final String password = "personanongrata";


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtiene valores ingresados en login.jsp
		String usrIngresado = request.getParameter("login");
		String pwdIngresado = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		
		if(user.contentEquals(usrIngresado) && password.contentEquals(pwdIngresado)) {
			//credenciales correctas crea sesion y envia a servlet de inicio
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("user", usrIngresado);
			
			
			 Cookie ck = new Cookie("nombre", usrIngresado);  

			 response.addCookie(ck); 
	         request.getRequestDispatcher("Home").forward(request, response);
		}
		//credenciales incorrectas devuelve pagina de login
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o contraseña incorrectos');");
			 out.println("location='Login.jsp';");
			 out.println("</script>");
		}
		out.close();
		}
}
