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
	<form action="agregarOrdenador">
	
		<h1>Ha entrado correctamente. Bienvenido, ${usuario.nombre}</h1>

		<hr>
		
		<div>
			<h2>Configuración del PC</h2>
			
			<h3>Seleccione el procesador:</h3>
			<select name="procesador">
				<option value="intelI3">Intel i3</option>
				<option value="intelI5">Intel i5</option>
				<option value="intelI7">Intel i7</option>
				<option value="amdR3">AMD Ryzen 3</option>
				<option value="amdR5">AMD Ryzen 5</option>
				<option value="amdR7">AMD Ryzen 7</option>
			</select>
			
			<h3>Seleccione la memoria RAM</h3>	
	
			<select name="memoriaRam">
				<option value="_4gb">4GB</option>
				<option value="_8gb">8GB</option>
				<option value="_16gb">16GB</option>
				<option value="_32gb">32GB</option>
			</select>
			
			<h3>Seleccione el almacenamiento (puede elegir varios discos)</h3>
				
			<p><input type="checkbox" name="discos" value="hdd500">HDD 500GB</p>
			<p><input type="checkbox" name="discos" value="hdd1000">HDD 1TB</p>
			<p><input type="checkbox" name="discos" value="hdd2000">HDD 2TB</p>
			<p><input type="checkbox" name="discos" value="ssd256">SSD 256GB</p>
			<p><input type="checkbox" name="discos" value="ssd512">SSD 512GB</p>		
		</div>
		
		<input type="submit" value="Agregar ordenador">
	</form>
	
	<form action="hacerPedido">
		<input type="submit" value="Hacer pedido">
	</form>

	<% 
		if(request.getAttribute("errorOrdenador") != null) {
	%>
			<div>
				<h2 style="color:red">Error, los datos del ordenador no están completos.</h2>
			</div>
	<%
		}
	%>
		
	<hr>
		
	<% 
		if(request.getAttribute("pedido") != null) {
	%>
		
			<h2 style="color:blue">Lista de ordenadores en el pedido</h2>			
	<%
			Pedido pedido = (Pedido) request.getAttribute("pedido");
			int cont = 0; 
			for(Ordenador ordenador : pedido.getOrdenadores()) {
				%><h3>Ordenador <%=++cont%> <%=ordenador.toString()%></h3>	
			<%}
		}
								
		if(request.getAttribute("errorPedido") != null) {
	%>
			<div>
				<h2 style="color:red">Error, los datos del pedido no están completos.</h2>
			</div>
	<%
		}
	%>
</body>
</html>