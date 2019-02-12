<%@page import="modelo.entidades.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizzería Sopra Steria - Resumen del pedido</title>
</head>
<body>
	<h1>Resumen del pedido</h1>
	
	<div>
		<%
			Pedido pedido = (Pedido) request.getAttribute("pedido");
		%>
		<h2>Usuario</h2>
		<p><label>Nombre: <%=pedido.getUsuario().getNombre()%></label></p>
		<p><label>Teléfono: <%=pedido.getUsuario().getTelefono()%></label></p>
		<p><label>Dirección: <%=pedido.getUsuario().getDireccion()%></label></p>
	</div>
	
	<div>
		<h2>Pizza</h2>
		<label>Tamaño: <%=pedido.getPizza().getTamanio()%></label>
		<label>Ingredientes: <%=pedido.getPizza().getIngredientes()%>
		</label>
	</div>
	
	<div>
		<h2>Precio: <%=pedido.getPrecio()%> Euros</h2>
	</div>
	
</body>
</html>