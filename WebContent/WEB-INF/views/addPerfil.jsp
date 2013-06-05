<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>
		<center>
			<h4>Perfil</h4>
			<form:form action="savePerfil.do" id="form" commandName="perfil" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Descrição:</td>
						<td><form:textarea path="descricao" class="span3"/></td>
					</tr>		
					<tr>
						<td colspan="2">
						<center>
							<a class="btn" href="#" onclick="document.forms[0].submit()"><i class="icon-plus-sign icon-black"></i> Salvar</a>
							<a class="btn" href="<c:url value="listPerfis.do"/>"><i class="icon-th-list icon-black"></i> Listar Perfis</a>
							<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
						</center>
						</td>
					</tr>				
				</table>
			</form:form>
			<br/>
			<table class="table table-hover" style="width: 60%">
				<tr>
					<th colspan="2" style="text-align: center;">
						<c:out value="Usuários Atribuidos"/>
					</th>
				</tr>
				<tr>
					<th>
						<c:out value="Nome"/>
					</th>
					<th>
						<c:out value="Cargo"/>
					</th>
				</tr>	
				<c:forEach var="usuario" items="${perfil.usuarios}"> 
				<tr>
					<td>
						<c:out value="${usuario.nome}"/>
					</td>
					<td>
						<c:out value="${usuario.cargo}"/>
					</td>		
				</tr>
				</c:forEach>
			</table>	
		</center>
    </jsp:body>
</layout:page>