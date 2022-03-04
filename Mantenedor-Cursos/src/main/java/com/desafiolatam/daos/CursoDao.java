package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;

public class CursoDao {

	public List obtieneCursos() throws SQLException, ClassNotFoundException {

		// creamos la lista de objetos que devolveran los resultados
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();

		// creamos la consulta a la base de datos
		String consultaSql = " SELECT id_curso, descripcion, precio " + " FROM CURSO ";

		try {

			Connection coni = null;
			String DRIVER = "oracle.jdbc.driver.OracleDriver";
			Class.forName(DRIVER);

			String USUARIO = "system";
			String PASSWORD = "admin";
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			coni = DriverManager.getConnection(URL, USUARIO, PASSWORD);

			PreparedStatement stmt = coni.prepareStatement(consultaSql);

			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(resultado.getString("id_curso"));
				cursoDto.setDescripcion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getDouble("precio"));
				listaDeCursos.add(cursoDto);
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		return listaDeCursos;
	}
}
