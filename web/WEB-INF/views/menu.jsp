<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Menú</h2>

<sec:authorize access="!isAuthenticated()">

Por favor inicie sesión

</sec:authorize>

<sec:authorize access="isRememberMe()">

Usuario ha iniciado sesión como: <sec:authentication property="principal" var="principal"/>
<c:set var="username" value="${principal.username}"></c:set>
<c:out value="${username}"></c:out>
<br/>
<a href="<c:url value='/logout'/>">Cerrar sesión</a>

</sec:authorize>

<sec:authorize access="isFullyAuthenticated()">

Usuario ha iniciado sesión como: <sec:authentication property="principal" var="principal"/>
<c:set var="username" value="${principal}"></c:set>
<c:out value="${username}"></c:out>
<br/>
<a href="<c:url value='/logout'/>">Cerrar sesión</a>

</sec:authorize>

<a href='<c:url value="/usuario"></c:url>'>Registrar usuario</a><br>