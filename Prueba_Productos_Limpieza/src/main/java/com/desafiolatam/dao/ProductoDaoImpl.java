package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.ConexionDatabase;
import com.desafiolatam.modelo.Producto;

public class ProductoDaoImpl extends ConexionDatabase implements ProductoDao {

	private Connection conexion;
	private PreparedStatement ptm;
	private ResultSet rs;
	List<Producto> listaProductos = new ArrayList<>();
	Producto producto = new Producto();

	
	public List<Producto> listarProductos() {

		String sql = "SELECT * FROM PRODUCTO";
		conexion = obtenerConexion();

		try {
			ptm = conexion.prepareStatement(sql);
			rs = ptm.executeQuery();

			while (rs.next()) {
				Producto prod = new Producto();
				prod.setId(rs.getInt("id_producto"));
				prod.setNombre(rs.getString("nombre_producto"));
				prod.setPrecio(rs.getInt("precio_producto"));
				prod.setDescripcion(rs.getString("descripcion_producto"));
				prod.setIdCategoria(rs.getInt("id_categoria"));

				listaProductos.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	public Producto buscarProducto(int id) {

		String sql = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = ?";
		conexion = obtenerConexion();
		try {
			ptm = conexion.prepareStatement(sql);
			ptm.setInt(1, id);
			rs = ptm.executeQuery();

			if (rs.next()) {
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				producto.setId(rs.getInt("id_producto"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return producto;
	}

	public boolean modificarProducto(Producto p) {
		String sql = "UPDATE producto SET nombre_producto = ?, precio_producto=?, descripcion_producto=?, id_categoria=?"
				+ "WHERE id_producto = ? ";
		conexion = obtenerConexion();

		try {
			ptm = conexion.prepareStatement(sql);

			ptm.setString(1, p.getNombre());
			ptm.setInt(2, p.getPrecio());
			ptm.setString(3, p.getDescripcion());
			ptm.setInt(4, p.getIdCategoria());
			ptm.setInt(5, p.getId());

			int resultado = ptm.executeUpdate();
			if (resultado == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int obtenerUltimoId() {
		int maximo = 0;
		// obtiene el valor mayor de la columna id_producto
		String sql = "SELECT MAX(id_producto) AS max FROM producto";
		conexion = obtenerConexion();
		try {
			ptm = conexion.prepareStatement(sql);
			rs = ptm.executeQuery();

			if (rs.next()) {
				maximo = rs.getInt("max");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return maximo;
	}

	@Override
	public boolean registrarProducto(Producto p) {
		String sql = "INSERT INTO producto(id_producto, nombre_producto, precio_producto, descripcion_producto, id_categoria)"
				+ "VALUES (?,?,?,?,?)";

		conexion = obtenerConexion();

		try {
			ptm = conexion.prepareStatement(sql);
			
			ptm.setInt(1, p.getId());
			ptm.setString(2, p.getNombre());
			ptm.setInt(3, p.getPrecio());
			ptm.setString(4, p.getDescripcion());
			ptm.setInt(5, p.getIdCategoria());
			
			int resultado = ptm.executeUpdate();
			
			if (resultado == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminarProducto(int id) {
		String sql = "DELETE FROM producto WHERE id_producto = ?";
		conexion = obtenerConexion();
		try {
			ptm = conexion.prepareStatement(sql);
			ptm.setInt(1, id);
			int resultado = ptm.executeUpdate();

			if (resultado == 1) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
}
