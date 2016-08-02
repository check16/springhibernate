<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administración</title>
<script type="text/javascript"
	src='<c:url value="/res/js/jquery-3.0.0.js" />'></script>
	<script type="text/javascript">
	
	
	</script>
</head>
<body>
<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	<h1>Estamos en direccion</h1>

	<sf:form action="${pageContext.request.contextPath}/direccion/save"
		method="post" commandName="direccion">
		<table>

			<c:if test="${direccion.idDireccion ne 0}">
				<sf:input path="idDireccion" type="hidden" />
			</c:if>

			<tr>
				<td>Calle</td>
				<td><sf:input path="calle" type="text" /></td>
			</tr>

			<tr>
				<td>Codigo postal</td>
				<td><sf:input path="cp" type="text" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios"></td>
			</tr>
		</table>
	</sf:form>

	<c:out value="${resultado}"></c:out>

	<table border="1">
		<thead>
			<tr>
				<th>Calle</th>
				<th>Cod. Postal</th>
			</tr>
			<c:forEach var="direccion" items="${direcciones}">
				<tr>
					<td><c:out value="${direccion.calle}" /></td>
					<td><c:out value="${direccion.cp}" /></td>
					<td><a
						href='<c:url value="/direccion/${direccion.idDireccion}/update"></c:url>'>Actualizar</a></td>
					<td><a id="confirm"
						href='<c:url value="/direccion/${direccion.idDireccion}/delete"></c:url>'>Eliminar</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>

</body>
</html>