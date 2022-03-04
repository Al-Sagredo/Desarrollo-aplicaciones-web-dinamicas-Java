package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecibeForm")
public class RecibeForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// obtiene los campos desde el form
		String nombre = request.getParameter("nombre");
		String empresa = request.getParameter("empresa");
		String rut = request.getParameter("rut");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String pais = request.getParameter("pais");
		String[] cantidades = request.getParameterValues("cantidad");
		String[] precios = request.getParameterValues("precio");
			
		//transforma el array cantidades a integer (crea un nuevo array)
		int sizeArray= cantidades.length;
		int[] cantidadesInt = new int[sizeArray];
		for (int i = 0; i < sizeArray; i++) {
			//valores nulos los transforma a 0
			if (cantidades[i] == "") {
				cantidades[i] = "0";
			}
			cantidadesInt[i] = Integer.parseInt(cantidades[i]);
		}
		
		//transforma el array precios a integer (crea un nuevo array)
		int[] preciosInt = new int[sizeArray];
		for (int i = 0; i < sizeArray; i++) {
			preciosInt[i] = Integer.parseInt(precios[i]);
		}
		
		//calcula el valor total de la factura
		int total = 0;
		for(int i=0; i<sizeArray; i++) {
			total += preciosInt[i] * cantidadesInt[i];
		}
		
		//total menos descuento
		int totalDesc = total - 10*total/100;
		
		// setea atributos al objeto request para usarlos en los siguientes servlets
		request.setAttribute("name", nombre);
		request.setAttribute("company", empresa);
		request.setAttribute("id", rut);
		request.setAttribute("address", direccion);
		request.setAttribute("city", ciudad);
		request.setAttribute("country", pais);
		request.setAttribute("cantidades", cantidades);
		request.setAttribute("precios", precios);
		request.setAttribute("total", total);
		request.setAttribute("totalDesc", totalDesc);

		// getServletContext() para que sirve???

		// envía la info al siguient servlet
		request.getRequestDispatcher("MostrarForm").forward(request, response);

	}

}
