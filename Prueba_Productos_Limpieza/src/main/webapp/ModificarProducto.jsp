<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Producto</title>
<link href="assets/css/miStyle.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>

	<h1>MODIFICAR PRODUCTO</h1>
	<h3 class="pb-5">Edita los campos que deseas modificar</h3>

<div class="formulario">
	<form action="ModificarProducto" method="post">
		<!-- envía el id del producto que se va a modificar, el id no es modificable -->
		<input type="hidden" name="id_producto" value="${producto.getId()}"/>
		
		<div class="mb-3	">
		<label for="nombre">Nombre</label>
		<input class = "input1" type="text" id="nombre" name="nombre" value="${producto.getNombre()}"/>
		</div>
		
		<div class="mb-3 ">
		<label for="desc">Descripción</label>
		<input class="input2" type="text" id="desc" name="descripcion" value="${producto.getDescripcion()}"/>
		</div>
		
		<div class="mb-3 ">
		<label for="precio">Precio</label>
		<input class="input3" type="number" id="precio" name="precio" value="${producto.getPrecio()}"/>
		</div>
		
		<div class="mb-3">
		<label for="cat">Categoría</label>
		<select class="input4" name="categoria" id="cat">
			<c:forEach items="${categorias}" var="cat">
			<!-- cuando el id de categoria de la lista coincida con el id de categoria del producto, queda como selected en las opciones -->
				<option value="${cat.getId()}" ${cat.getId() == producto.getIdCategoria() ? 'selected' : ''}>
					${cat.getNombre()}
				</option>
			</c:forEach>
		</select>
		</div>
		
		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>
	</div>
	<a class="volver" href="Home.jsp">Volver al inicio</a>
	
</body>
</html>