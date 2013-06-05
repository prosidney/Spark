<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>   
		<center>
			<h4>Manutenção</h4>
			<form:form action="saveManut.do" id="form" commandName="manutencao" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Aparelho:</td>
						<td>
							<form:select id="aparelhosCollection" path="aparelho" class="span3">
							  <form:options items="${aparelhos}" itemValue="id" itemLabel="nome" />
							</form:select>
						</td>
					</tr>					
					<tr>
						<td>Nome:</td>
						<td><form:textarea path="descricao" class="span3"/></td>
					</tr>				
					<tr>
						<td colspan="2">
						<center>
							<a class="btn" href="#" onclick="document.forms[0].submit()"><i class="icon-plus-sign icon-black"></i> Salvar</a>
							<a class="btn" href="<c:url value="listManutencoes.do"/>"><i class="icon-th-list icon-black"></i> Listar Manutenções</a>
							<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
						</center>
						</td>
					</tr>				
				</table>
			</form:form>
		</center>
    </jsp:body>
</layout:page>