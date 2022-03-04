package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.Facade;
@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet
{
  
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
   {
      // obtengo los datos del formulario
      String nombre = request.getParameter("nombre");
      String celular = request.getParameter("celular");
      int idCurso = Integer.parseInt(request.getParameter("idCurso"));
      int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));
      
       // instancio el DTO y le asigno los datos recuperados del formulario
      InscripcionDTO dto = new InscripcionDTO();
      dto.setNombre(nombre);
      dto.setCelular(celular);
      dto.setIdCurso(idCurso);
      dto.setIdFormaDePago(idFormaDePago);
      
      // invoco al facade para procesar la inscripcion
      Facade facade = new Facade();
      int idInsc = 0;
		try {
			//se llama al metodo del facade pasandole como parametro el objeto InscripcionDTO con los atributos seteados
			idInsc = facade.registrarInscripcion(dto);
		} catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
		} 
		System.out.println(idInsc);
       //el resultado lo adjunto como atributo en el request
      request.setAttribute("idInsc", idInsc);
      
       // redirecciono el control hacia la siguiente vista,
       // es decir: hacia su servlet de pre-confirmacion
      request.getRequestDispatcher("/preConfirmacion").forward(request, response);
   }
}
