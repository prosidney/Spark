<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>   
		<center>
			<h4>Usuário</h4>
			<form:form action="saveUsuario.do" id="form" commandName="usuario" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Nome:</td>
						<td><form:textarea path="nome" class="span3"/></td>
					</tr>				
					<tr>
						<td>Cargo:</td>
						<td><form:textarea path="cargo" class="span3"/></td>
					</tr>		
					<tr>
						<td>Usuario:</td>
						<td><form:textarea path="usuario" class="span3"/></td>
					</tr>	
					<tr>
						<td>Senha:</td>
						<td><form:password path="senha" class="span3"/></td>
					</tr>	
					<tr>
						<td>Perfil:</td>
						<td>
							<form:select id="perfisCollection" path="perfil" class="span3">
							  <form:options items="${perfis}" itemValue="id" itemLabel="descricao" />
							</form:select>
						</td>
					</tr>					
					<tr>
						<td colspan="2">
						<center>
							<a class="btn" href="#" onclick="document.forms[0].submit()"><i class="icon-plus-sign icon-black"></i> Salvar</a>
							<a class="btn" href="<c:url value="listUsuarios.do"/>"><i class="icon-th-list icon-black"></i> Listar Usuários</a>
							<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
						</center>
						</td>
					</tr>				
				</table>
			</form:form>
		</center>
    </jsp:body>
</layout:page>