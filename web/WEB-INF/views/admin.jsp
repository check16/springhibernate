<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administración</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" /> 
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#confirm').on("click", function() {
			return confirm("¿Desea elminar este administrador?");
		});
		var path = $("#path").val();
		$("#busqueda").autocomplete({
			source: path + "/admin/json/search"
		});
	});
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	<h1>Estamos en admin</h1>

		Buscar administradores: <input type="hidden" id="path" value="${pageContext.request.contextPath}">
		<input type="text" id="busqueda" name="term">
		

	<sf:form action="${pageContext.request.contextPath}/admin/save"
		method="post" commandName="admin">
		<table>

			<c:if test="${admin.idAd ne 0}">
				<sf:input path="idAd" type="hidden" />
				<sf:input path="fechaCreacion" type="hidden" />
			</c:if>

			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text" /></td>
			</tr>

			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" type="text" /></td>
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
				<th>Nombre</th>
				<th>Cargo</th>
				<th>Fecha de creación</th>
			</tr>
			<c:forEach var="admin" items="${admins}">
				<tr>
					<td><c:out value="${admin.nombre}" /></td>
					<td><c:out value="${admin.cargo}" /></td>
					<td><c:out value="${admin.fechaCreacion}" /></td>
					<td><a
						href='<c:url value="/admin/${admin.idAd}/update"></c:url>'>Actualizar</a></td>
					<td><a id="confirm"
						href='<c:url value="/admin/${admin.idAd}/delete"></c:url>'>Eliminar</a></td>
					<td><a href='<c:url value="/direccion/${admin.idAd}"></c:url>'>Direcciones</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>

</body>
</html>