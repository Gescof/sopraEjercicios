<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">
		<font color="red">
			<u>Listado de Operaciones</u>
		</font>
	</h2>
	
	<table align="center" border="1">
		<tr>
			<th>Identificador de la operaci�n</th>
			<th>Tipo de operaci�n</th>
			<th>Operando uno (izquierda)</th>
			<th>Operando dos (derecha)</th>
			<th>Resultado</th>
		</tr>
		<c:forEach var="operacion" items="${listaOperaciones}">
			<tr>
				<td>
				<!-- Aqu� se forma una url como operaciones/seleccionar?id=id -->
					<c:url var="enlace" value="seleccionar">
						<c:param name="id" value="${operacion.id}"></c:param>
					</c:url>
					<a href="${enlace}">${operacion.id}</a>
				</td>
				<td>${operacion.tipoOperacion}</td>
				<td>${operacion.operando1}</td>
				<td>${operacion.operando2}</td>
				<td>${operacion.resultado}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p align="center">
		<a href="formulario">Ver formulario</a>
	</p>
</body>
</html>