<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="assets/css/miStyle.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Eliminar Producto</title>
</head>

<body>

	<h1>ELIMINAR PRODUCTO</h1>

	<h3 class="pb-5">Estas seguro que quieres eliminar el producto <strong>${nombre_producto}?</strong></h3>

	<form action="EliminarProducto" method="POST">
		<div class="sino pb-5">
			<input type="hidden" value="${id_producto}" name="id" />

			<button class="btn btn-danger" type="submit">Si</button>

			<a class="link" href="Home.jsp">NO</a>
		</div>
	</form>
	<a id="eliminarVolver" class="volver" href="Home.jsp">Volver al Inicio</a>

</body>
</html>