<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EOD</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">	

<script src="js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>	
</head>
<body>
	<center>
		<form:form action="j_spring_security_check" id="formLogin" name="formAutenticacao" method="post" class="navbar-form pull-center">
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="j_username" class="span2"/></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="j_password" class="span2"/></td>
				</tr>
				<tr>
					<td>
						<center>
							<input type="submit" value="Logar" class="btn"/>
						</center>
					</td>
				</tr>
			</table>
		</form:form>	
		<c:if test="${param.mensagemErroLogin != null}">
			<h4> <c:out value="${param.mensagemErroLogin}"/> </h4>
		</c:if>
	</center>
</body>
</html>