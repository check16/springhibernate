<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Acceso a usuario</h1>
	<c:if test="${param.error != null }">
		<span style="color:red;">Error de credenciales</span>
	</c:if>
	<form name='f' action="${pageContext.request.contextPath}/login"
		method='POST'>
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='usuario'></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type='password' name='clave' /></td>
			</tr>
			<tr>
				<td>Recordarme:</td>
				<td><input type='checkbox' name='remember-me' checked="checked" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Acceder" /></td>
			</tr>
		</table>
	</form>

</body>
</html>