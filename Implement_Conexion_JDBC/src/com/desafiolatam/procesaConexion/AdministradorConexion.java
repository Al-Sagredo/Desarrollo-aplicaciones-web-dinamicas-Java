package com.desafiolatam.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorConexion {

	protected Connection cony = null;
	protected PreparedStatement ptm = null;
	protected ResultSet rs = null;

	protected Connection generaConexion() {
		String usr = "sys as sysdba";
		String pwd = "admin";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			Class.forName(driver);
			cony = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cony;
	}

}
