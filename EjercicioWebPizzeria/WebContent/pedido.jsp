<%@page import="modelo.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizzería Sopra Steria - Realizar Pedido</title>
</head>
<body>
<form action="ServletPedido">
	<h1>¡Ha entrado correctamente!</h1>
	<div>
		<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
		%>
		<label>Nombre: <input type="text" name="nombre" value="<%=usuario.getNombre()%>"></label>
		<label>Teléfono: <input type="text" name="telefono"></label>
		<label>Dirección: <input type="text" name="direccion"></label>
	</div>
	
	<hr>
	
	<div>
		<h2>Pizza</h2>
		<h3>Seleccione el tamaño:</h3>
		<select name="tamanio">
			<option value="pequenia">Pequeña</option>
			<option value="mediana">Mediana</option>
			<option value="grande">Grande</option>
		</select>
		
		<h3>Selecciones los ingredientes:</h3>	

		<p><input type="checkbox" name="ingrediente" value="Queso">Queso</p>
		<p><input type="checkbox" name="ingrediente" value="Bacon">Bacon</p>
		<p><input type="checkbox" name="ingrediente" value="Jamon">Jamón</p>
		<p><input type="checkbox" name="ingrediente" value="Pollo">Pollo</p>
		<p><input type="checkbox" name="ingrediente" value="Peperoni">Peperoni</p>
		<p><input type="checkbox" name="ingrediente" value="PimientoVerde">Pimiento Verde</p>
		<p><input type="checkbox" name="ingrediente" value="PimientoRojo">Pimiento Rojo</p>
		<p><input type="checkbox" name="ingrediente" value="Cebolla">Cebolla</p>

	</div>
	
	<hr>
	
	<div>
		<input type="submit" value="Pagar">
	</div>
	
	<% 
		if(request.getAttribute("error") != null) {
	%>
		<div>
			<h2>Error, los datos del pedido no están completos.</h2>
		</div>
	<%
		}
	%>
	
</form>
</body>
</html>