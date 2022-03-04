<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Factura</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
</head>
<body>

	<!-- JSTL para obtener los atributos del request y asignarlo a variables -->
	<c:set var="nombre" value='${requestScope["name"]}' />
	<c:set var="empresa" value='${requestScope["company"]}' />
	<c:set var="rut" value='${requestScope["id"]}' />
	<c:set var="direccion" value='${requestScope["address"]}' />
	<c:set var="ciudad" value='${requestScope["city"]}' />
	<c:set var="pais" value='${requestScope["country"]}' />
	<c:set var="cantidades" value='${requestScope["cantidades"]}' />
	<c:set var="precios" value='${requestScope["precios"]}' />

	<section>
	    <div style="height:300px">
	      <div style="display:inline-block; margin-top:100px;margin-left:100px;">      	
	      	<img width=150px height=150px src="https://www.logodesign.ai/wp-content/uploads/edd/2020/10/Wolf-Logo-Vector-Art.png" alt="logo">
	      </div>
	
	      <div class="" style="display:inline-block; margin-left:450px;">
		      <strong>Generador Factura 2022 </strong><br> 
		      <strong>Competition Part Ltda.</strong> <br>
		       Created by Alvaro Sagredo <br>
		       <a style="text-decoration:none;" href="https://github.com/Al-Sagredo">Github</a>
		  </div>
	    </div>
  </section>
	
	<section class="mb-5 mt-5" style="margin-left:20px; margin-right:20px;">
		<div class="d-inline-block info">
			<strong>Información de cliente</strong><br><br>
			<c:out value="${nombre}" />, <c:out value="${rut}" /><br>
			<c:out value="${empresa}" /><br><br>
			<c:out value="${ciudad}" />, <c:out value="${pais}" /><br>
			<c:out value="${direccion}" />
		</div>
		
		<div style="float:right; text-align:right;" class="d-inline-block">
			<strong>Detalles de pago</strong><br><br>
			NUM FACTURA : 452554 <br>
			ID FACTURA : 40254814 <br>
			TIPO PAGO : Dinero <br>
			EMPRESA : Importadora 
		</div>
	</section>

	<div style="margin-left:20px; margin-right:20px;">
	<table class="table table-striped table-dark mt-5">
		<tr>
			<th>ITEM</th>
			<th>DESCRIPCION</th>
			<th>VALOR UNIDAD</th>
			<th>CANTIDAD</th>
			<th>VALOR TOTAL</th>
		</tr>
		<!-- Inserta en columna CANTIDAD, los valores del array cantidades, y en columna valor total, la formula -->
		<tr>
			<td>Aceite Besos Íntimos Té Verde</td>
			<td>Aceite sabor a Te verde para
				estimular zonas erógenas del cuerpo, entregando su efecto de
				excitante calidez.</td>
			<td>$19.990</td>
			<td>${cantidades[0]}</td>
			<td>$${cantidades[0] * precios[0]}</td>

		</tr>
		<tr>
			<td>Bala Vibradora Bam Recargable</td>
			<td>Es un dispositivo de los más poderosos de su categoría, ya
				que cuenta con 10 modos de vibración</td>
			<td>$36.500</td>
			<td>${cantidades[1]}</td>
			<td>$${cantidades[1] * precios[1]}</td>
		</tr>
		<tr>
			<td>Bolas chinas 2</td>
			<td>Pura tradición de las bolas de Geisha</td>
			<td>$9.990</td>
			<td>${cantidades[2]}</td>
			<td>$${cantidades[2] * precios[2]}</td>
		</tr>
		<tr>
			<td>G star estimulador púrpura</td>
			<td>Vibrador de conejo de doble Motor para mujer</td>
			<td>$16.990</td>
			<td>${cantidades[3]}</td>
			<td>$${cantidades[3] * precios[3]}</td>
		</tr>
		<tr>
			<td>Mini Plug Anal Rosa Starsex</td>
			<td>Su tamaño y terminaciones redondeadas son ideales para
				principiantes, el mango flexible de la base facilita la extracción.</td>
			<td>$9.990</td>
			<td>${cantidades[4]}</td>
			<td>$${cantidades[4] * precios[4]}</td>
		</tr>
	</table>
	</div>
	
	<footer >
		<div style="height:150px" class="mt-5 bg-dark text-white d-flex flex-row-reverse">
			<div style="padding-right:100px;" class="mt-auto mb-auto ">VALOR TOTAL <p class="h4 text-center">$${totalDesc}</p></div>
			<div style="padding-right:100px;" class="mt-auto mb-auto ">DESCUENTO <p class="h4 text-center">10%</p></div>
			<div style="padding-right:100px;" class="mt-auto mb-auto ">VALOR TOTAL NETO <p class="h4 text-center">$${total}</p></div>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>