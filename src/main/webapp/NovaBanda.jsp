<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Banda</title>
</head>
<body>

	<h1>Banda</h1>


	<form name="formBanda" action="novabanda">


		<table>


			<tr>
				<th>Nome:</th>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<th>Gênero:</th>
				<td><input type="text" name="genero" /></td>
			
			</tr>

			<tr>
				<td><input type="submit" value="Adicionar "
					onclick="validar()" /></td>
			</tr>
		</table>
	</form>
	
	<script src="scripts/validador.js"> </script>

</body>
</html>