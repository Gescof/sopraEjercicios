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
		<font color="red">Formulario Operaciones</font>
	</h1>
	
	<h3 style="color:red">${errores}</h3>
	
	<form:form id="formulario" method="post" modelAttribute="operacion">
		
		<div align="center">
			<input type="submit" value="Insertar" onclick="setActionFormulario('insertar')"/>
			<input type="submit" value="Actualizar" onclick="setActionFormulario('actualizar')"/>
			<input type="submit" value="Eliminar" onclick="setActionFormulario('eliminar')"/>
		</div>
		
		<br>
		
		<form:hidden path="id"></form:hidden>
		
		<table align="center">
			<tr>
				<td>Tipo de operación</td>
				<td><form:input path="tipoOperacion"></form:input></td>
			</tr>
			<tr>
				<td>Operando uno (izquierda)</td>
				<td><form:input path="operando1"></form:input></td>
			</tr>
			<tr>
				<td>Operando dos (derecha)</td>
				<td><form:input path="operando2"></form:input></td>
			</tr>
		</table>
	</form:form>
</body>
</html>