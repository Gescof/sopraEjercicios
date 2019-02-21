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
			<u>Listado de Películas</u>
		</font>
	</h2>
	
	<table align="center" border="1">
		<tr>
			<th>Título</th>
			<th>Director</th>
			<th>Género</th>
			<th>Año</th>
		</tr>
		<c:forEach var="pelicula" items="${listaPeliculas}">
			<tr>
				<td>
				<!-- Aquí se forma una url como mvc/peliculas/seleccionar?id=id -->
					<c:url var="enlace" value="seleccionar">
						<c:param name="id" value="${pelicula.id}"></c:param>
					</c:url>
					<a href="${enlace}">${pelicula.titulo}</a>
				</td>
				<td>${pelicula.director}</td>
				<td>${pelicula.genero}</td>
				<td>${pelicula.year}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p align="center">
		<a href="verFormulario">Ver formulario</a>
	</p>
</body>
</html>