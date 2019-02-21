<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function setActionFormulario(accion) {
		var formulario = document.getElementById("formulario");
		formulario.action = accion;
	}
</script>
</head>
<body>
	<h1 align="center">
		<font color="red">Formulario Pel�culas</font>
	</h1>
	
	<h3 style="color:red">${errores}</h3>
	
	<form:form id="formulario" method="post" modelAttribute="pelicula">
		
		<div align="center">
			<input type="submit" value="Insertar" onclick="setActionFormulario('insertar')"/>
			<input type="submit" value="Actualizar" onclick="setActionFormulario('actualizar')"/>
			<input type="submit" value="Eliminar" onclick="setActionFormulario('eliminar')"/>
		</div>
		
		<br>
		
		<form:hidden path="id"></form:hidden>
		
		<table align="center">
			<tr>
				<td>T�tulo</td>
				<td><form:input path="titulo"></form:input></td>
			</tr>
			<tr>
				<td>Director</td>
				<td><form:input path="director"></form:input></td>
			</tr>
			<tr>
				<td>G�nero</td>
				<td><form:input path="genero"></form:input></td>
			</tr>
			<tr>
				<td>A�o</td>
				<td><form:input path="year"></form:input></td>
			</tr>
		</table>
	</form:form>
</body>
</html>