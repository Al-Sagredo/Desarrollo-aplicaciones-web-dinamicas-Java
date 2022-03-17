<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN</title>

<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/miStyle.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>


<h1 id="titulo">LOG IN</h1>

<div class="wrapper fadeInDown">
		  <div id="formContent">
		
		    <div class="fadeIn first pb-3">
		      <img class="pt-3" src="assets/img/lock.png" id="icon" alt="User Icon" />
		    </div>
		
		    <form action="ProcesaLogin" method="POST">
		      <input type="text" id="login" class="fadeIn second" name="login" placeholder="usuario">
		      <input type="text" id="password" class="fadeIn third" name="pass" placeholder="contraseña">
		      <input type="submit" class="fadeIn fourth" value="Log In">
		    </form>
		    <!--  LOGIN = "alvaro";
				  PASS= "personanongrata";-->
		
		    <div id="formFooter">
		      <a class="underlineHover" href="#">Olvidé la clave</a>
		    </div>
		
		  </div>
	</div>
</body>
</html>