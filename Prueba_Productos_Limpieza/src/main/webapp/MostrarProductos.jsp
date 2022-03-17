<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mostrar Productos</title>
<link href="assets/css/miStyle.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<h1 class="pb-5 pt-3">Lista de productos</h1>

	<table id="tabla" class="table table-success table-striped">
		<tr>
			<th>ID PRODUCTO</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>DESCRIPCIÓN</th>
			<th>CATEGORÍA</th>
			<th>ACCIONES</th>
		</tr>
		<c:forEach items='${listaPC}' var="pc">
			<tr>
				<td>${pc.getProducto().getId()}</td>
				<td>${pc.getProducto().getNombre()}</td>
				<td>${pc.getProducto().getPrecio()}</td>
				<td>${pc.getProducto().getDescripcion()}</td>
				<td>${pc.getCategoria().getNombre()}</td>
				<td>
					<!-- envia a los servlets correspondientes solo el id del producto -->
					<a  href="ModificarProducto?id_producto=${pc.getProducto().getId()}">
						<button type="button" class="btn btn-warning">Modificar</button>
					</a>&nbsp;
					<a  href="EliminarProducto?id_producto=${pc.getProducto().getId()}">
						<button type="button" class="btn btn-danger">Eliminar</button>
					</a>
					

				</td>
			</tr>
		</c:forEach>
	</table>

	<a class="volver" href="Home.jsp">Volver al Inicio</a>
	
</body>
</html>