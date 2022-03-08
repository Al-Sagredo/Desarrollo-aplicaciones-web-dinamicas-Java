package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.Customers;
import com.desafiolatam.procesaConexion.AdministradorConexion;

public class ListarDaoImpl extends AdministradorConexion implements ListarDao {

	public ListarDaoImpl() {
		Connection cony = generaConexion();
	}

	@Override
	public List<Customers> muestraResultado() {
		// hereda de AdministradorConexion los objetos de conexion
		String sql = "SELECT * FROM customers";
		List<Customers> customers = new ArrayList<Customers>();
		try {
			ptm = cony.prepareStatement(sql);
			rs = ptm.executeQuery();
			while (rs.next()) {
				// obtiene los atributos del resultset y se los asigna al objeto customer
				Customers customer = new Customers(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("AGE"),
						rs.getString("ADDRESS"), rs.getFloat("SALARY"));
				// el objeto customer creado se agrega a la lista de customers
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptm != null)
					ptm.close();
				if (cony != null)
					cony.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return customers;
	}
}
