<%@page import="entidades.Ordenador"%>
<%@page import="entidades.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	Pedido pedido = (Pedido) request.getAttribute("pedido"); %>
	<h1>Resumen del pedido de ${pedido.usuario.nombre}</h1>
	
	<hr>
	
	<%
		int cont = 0;
		for(Ordenador ordenador : pedido.getOrdenadores()) {
			%><h3>Ordenador <%=++cont%> <%=ordenador.toString()%></h3>	
		<%
		}
		%>
	
	<hr>
		
	<h3>Precio total: <%=pedido.getPrecio()%> Euros</h3>	
</body>
</html>