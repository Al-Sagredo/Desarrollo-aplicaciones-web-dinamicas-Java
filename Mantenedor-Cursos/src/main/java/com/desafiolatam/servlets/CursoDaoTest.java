package com.desafiolatam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.facade.Facade;

import oracle.jdbc.driver.OracleDriver;

@WebServlet("/test")
public class CursoDaoTest extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creamos la lista de objetos que devolveran los resultados
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();
		
		//creamos la consulta a la base de datos
		String consultaSql = " SELECT id_curso, descripcion, precio " 
				   		   + " FROM CURSO ";
		PrintWriter writer = response.getWriter();
	
		try {
		
			Connection coni = null;
			String DRIVER = "oracle.jdbc.driver.OracleDriver";
			
			Class.forName(DRIVER);
			
			String USUARIO = "system";
			String PASSWORD = "admin";
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";// ORA-28040: No coincide ningún protocolo de autenticación
			coni = DriverManager.getConnection(URL, USUARIO, PASSWORD);

			PreparedStatement stmt = coni.prepareStatement(consultaSql);

				ResultSet resultado = stmt.executeQuery();
				while(resultado.next()) {
					CursoDTO cursoDto = new CursoDTO();
					cursoDto.setIdCurso(resultado.getString("id_curso"));
					cursoDto.setDescripcion(resultado.getString("descripcion"));
					cursoDto.setPrecio(resultado.getDouble("precio"));
					listaDeCursos.add(cursoDto);
				}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
			
		
		
		
		writer.println("<html><body>");
		writer.println("Has ingresado al servlet CursoDaoTest. Lista de cursos:");
		writer.println(listaDeCursos.size());
		
		
		for(CursoDTO dto: listaDeCursos) {
			writer.println(dto.getIdCurso());
			writer.println(dto.getDescripcion());
			writer.println(dto.getPrecio());
			writer.println("<br>");

			
		}
		writer.println("</body></html>");
		/*request.setAttribute("cursos", listaDeCursos);

		//mandamos el request a la pagina jsp
		request.getRequestDispatcher("obtieneCursoTest.jsp").forward(request, response);*/
	}

}
