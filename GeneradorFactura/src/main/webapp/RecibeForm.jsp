<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ingresar Datos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

  <section>
    <div style="height:300px">
      <div class="d-inline-block" style="margin-top:100px;margin-left:100px;">      	
      	<img width=150px height=150px src="https://www.logodesign.ai/wp-content/uploads/edd/2020/10/Wolf-Logo-Vector-Art.png" alt="logo">
    </div>
      
      <div class="d-inline-block" style="display:inline-block; margin-left:450px;"><strong>Generador Factura 2022 </strong><br> <strong>Competition Part Ltda.</strong> <br>
        Created by Alvaro Sagredo <br><a href="https://github.com/Al-Sagredo">Github</a>
       </div>
     </div>
  </section>

	<form style="margin-left:20px; margin-right:20px;border-top:1px solid #DCDCDC;" class="pt-5 mt-5 mb-5" action="RecibeForm" method="post">
		<div class="datos-personales row g-3 mb-5">
			<div class="col-md-4">
		    <label for="nombre" class="form-label">Nombre Completo</label>
		    <input type="text" class="form-control" name="nombre" id="nombre">
		  </div>

		  <div class="col-md-4">
		    <label for="empresa" class="form-label">Empresa</label>
		    <input type="text" class="form-control" name="empresa" id="empresa">
		  </div>
		
		  <div class="col-md-4">
		    <label for="rut" class="form-label">Rut</label>
		    <input type="text" class="form-control" name="rut" id="rut">
		  </div>
		
		  <div class="col-md-4 ">
		    <label for="direccion" class="form-label">Dirección</label>
		    <input type="text" class="form-control" name="direccion" id="direccion">
		  </div>
		
		  <div class="col-md-4 ">
		    <label for="ciudad" class="form-label">Ciudad</label>
		    <input type="text" class="form-control" name="ciudad" id="ciudad">
		  </div>
		
		  <div class="col-md-4 ">
		    <label for="pais" class="form-label">País</label>
		    <input type="text" class="form-control" name="pais" id="pais">
		  </div>
		</div>
		
		<table class="table table-striped table-dark">
			<tr>
				<th>ITEM</th>
				<th>DESCRIPCION</th>
				<th>VALOR UNIDAD</th>
				<th>CANTIDAD</th>
			</tr>
			<tr>
				<td>Aceite Besos Intimos Té Verde</td>
				<td>Aceite sabor a Té verde para
					estimular zonas erógenas del cuerpo, entregando su efecto de
					excitante calidez.</td>
				<!-- envía el precio junto con la cantidad ingresada por usuario -->
				<td>$19.990<input type="hidden" name="precio" value="19990" /></td>
				<td><input type="text" name="cantidad"></td>
			</tr>
			<tr>
				<td>Bala Vibradora Bam Recargable</td>
				<td>Es un dispositivo de los mas poderosos de su categoría, ya
					que cuenta con 10 modos de vibración</td>
				<td>$36.500<input type="hidden" name="precio" value="36500" /></td>
				<td><input type="text" name="cantidad"></td>
			</tr>
			<tr>
				<td>Bolas chinas 2</td>
				<td>Pura tradición de las bolas de Geisha</td>
				<td>$9.990<input type="hidden" name="precio" value="9990" /></td>
				<td><input type="text" name="cantidad"></td>
			</tr>
			<tr>
				<td>G star estimulador púrpura</td>
				<td>Vibrador de conejo de doble Motor para mujer</td>
				<td>$16.990<input type="hidden" name="precio" value="16990" /></td>
				<td><input type="text" name="cantidad"></td>
			</tr>
			<tr>
				<td>Mini Plug Anal Rosa Starsex</td>
				<td>Su tamaño y terminaciones redondeadas son ideales para
					principiantes, el mango flexible de la base facilita la extracción.</td>
				<td>$9.990<input type="hidden" name="precio" value="9990" /></td>
				<td><input type="text" name="cantidad"></td>
			</tr>
		</table>
		
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<button class="btn btn-success me-md-2" type="submit" >Generar Factura</button>
			<input  class="btn btn-secondary" type="reset" value="Limpiar">
		</div>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
	</script>


</body>
</html>