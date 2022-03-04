<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log in</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="assets/css/style.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="wrapper fadeInDown">
		  <div id="formContent">
		
		    <div class="fadeIn first pb-3">
		      <img src="assets/img/lock.png" id="icon" alt="User Icon" />
		    </div>
		
		    <form action="procesameLogin" method="POST">
		      <input type="text" id="login" class="fadeIn second" name="login" placeholder="usuario">
		      <input type="text" id="password" class="fadeIn third" name="pass" placeholder="contraseña">
		      <input type="submit" class="fadeIn fourth" value="Log In">
		    </form>
		    <!--  LOGIN = "usuario1";
				  PASS= "password";-->
		
		    <div id="formFooter">
		      <a class="underlineHover" href="#">Olvido la clave?</a>
		    </div>
		
		  </div>
	</div>


</body>
</html>