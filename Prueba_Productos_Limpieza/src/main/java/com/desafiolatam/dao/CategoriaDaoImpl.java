package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.ConexionDatabase;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

public class CategoriaDaoImpl extends ConexionDatabase implements CategoriaDao {

	private Connection conexion;
	private PreparedStatement ptm;
	private ResultSet rs;
	Categoria categoria = new Categoria();
	List<Categoria> listaCategorias = new ArrayList<>();
	
	@Override
	public List<Categoria> listarCategorias() {
		String sql = "SELECT * FROM CATEGORIA";
		conexion = obtenerConexion();
		
		try {
			ptm = conexion.prepareStatement(sql);
			rs = ptm.executeQuery();
			
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				listaCategorias.add(categoria);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return listaCategorias;
	}

	@Override
	public Categoria buscarCategoria(int id) {
				
		String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
		conexion = obtenerConexion();
		
		try {
			ptm = conexion.prepareStatement(sql);
			ptm.setInt(1,  id);
			rs = ptm.executeQuery();
			//setea los atributos del objeto categoria
			if(rs.next()) {
				categoria.setNombre(rs.getString("nombre_categoria"));
				categoria.setId(rs.getInt("id_categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}
}
