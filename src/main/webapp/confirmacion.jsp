
<%
   int idInsc = (Integer)request.getAttribute("idInsc");
%>

<html> 
<body>
   <h1>Solicitud Generada Correctamente</h1>
   Su codigo de inscripci�n es: <%=idInsc%>
   
  <div><a href="Home"><button value="Volver">Volver</button></a></div> 
</body>
</html>