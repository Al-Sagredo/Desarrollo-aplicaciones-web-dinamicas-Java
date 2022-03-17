<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html	>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registrar Producto</title>
<link href="assets/css/miStyle.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<h1 class="pb-5">Registrar Producto</h1>
	<form action="RegistrarProducto" method="post">
		
		<div class="mb-3">
		<label for="nombre">Nombre</label>
		<input class = "input1" type="text" id="nombre" name="nombre"/>
		</div>
		
		<div class="mb-3">
		<label for="precio">Precio</label>
		<input class="input2" type="number" id="precio" name="precio"/>
		</div>
		
		<div class="mb-3">
		<label for="desc">Descripción</label>
		<input class="input3" type="text" id="desc" name="desc"/>
		</div>
		
		<div class="mb-3">
		<label for="categoria">Categoría</label>
		<select class="input4" name="categoria" id="categoria">
			<c:forEach items="${categorias}" var="cat">
				<option value="${cat.getId()}">
					${cat.getNombre()}<!-- el usuario elige un nombre de categoria pero yo solo capturo el id de esa categoria -->
				</option>
			</c:forEach>
		</select>
		</div>
		
		<button class="btn btn-primary" type="submit">Enviar</button>
	</form>
	<a class="volver" href="Home.jsp">Volver al inicio</a>
</body>
</html>