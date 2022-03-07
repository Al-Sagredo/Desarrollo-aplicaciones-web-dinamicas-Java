

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int idInsc = (Integer) request.getAttribute("idInsc");
%>

<c:set var="nombre" value="${requestScope.nombre}" />
<c:set var="telefono" value="${requestScope.telefono}" />
<c:set var="id_curso" value="${requestScope.id_curso}" />
<c:set var="forma_pago" value="${requestScope.forma_pago}" />
<html>
<head>
<style>
body * {
	text-align: center;
}

p {
	font-size: 1.5rem;
}

h1 {
	font-size: 3rem;
	text-transform: uppercase;
}
</style>
</head>
<body>
	<div>

		<h1>
			Hola
			<c:out value="${nombre}" />
		</h1>
		<p>
			<strong>Tus datos de inscripción son los siguientes:</strong>
		</p>

		<p>
			Nombre:
			<c:out value="${nombre}" />
		</p>
		<p>
			Teléfono:
			<c:out value="${telefono}" />
		</p>
		<p>
			ID curso:
			<c:out value="${id_curso}" />
		</p>
		<p>
			ID Forma de pago:
			<c:out value="${forma_pago}" />
		</p>


	</div>

	<div>
		<a href="Home"><button value="Volver">Volver</button></a>
	</div>
</body>
</html>