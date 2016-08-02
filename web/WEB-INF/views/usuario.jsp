<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuario</title>
<script type="text/javascript"
	src='<c:url value="/res/js/jquery-3.0.0.js" />'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#confirm').on("click", function() {
			return confirm("¿Desea elminar este administrador?");
		});
	});
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	<h1>Estamos en usuario</h1>

	<sf:form action="${pageContext.request.contextPath}/usuario/save"
		method="post" commandName="usuario">
		<table>

			<tr>
				<td>Usuario</td>
				<td><sf:input path="usuario" type="text" />
				<sf:errors cssStyle="color:red" path="usuario"></sf:errors>
				</td>
			</tr>

			<tr>
				<td>Clave</td>
				<td><sf:input path="clave" type="password" />
				<sf:errors cssStyle="color:red" path="clave"></sf:errors>
				</td>
			</tr>
			
			<tr>
				<td>Permisos</td>
				<td><sf:input path="permiso" type="text" />
				<sf:errors cssStyle="color:red" path="permiso"></sf:errors>
				</td>
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
				<th>Usuario</th>
				<th>Clave</th>
				<th>Permiso</th>
				<th>Fecha de creación</th>
			</tr>
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td><c:out value="${usuario.usuario}" /></td>
					<td><c:out value="${usuario.clave}" /></td>
					<td><c:out value="${usuario.permiso}" /></td>
					<td><c:out value="${usuario.fechaCreacion}" /></td>
				</tr>
			</c:forEach>
		</thead>
	</table>

</body>
</html>