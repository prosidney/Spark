<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>
        <center>
		<table class="table table-hover" style="width: 60%">
			<tr>
				<th colspan="5" style="text-align: center;"><c:out value="Usuários" /></th>
			</tr>
			<tr>
				<th colspan="5" style="text-align: center;"><a href="addUsuario.do">Adicionar</a></th>
			</tr>
			<tr>
				<th><c:out value="ID" /></th>
				<th><c:out value="Nome" /></th>
				<th><c:out value="Cargo" /></th>
				<th><c:out value="Perfil" /></th>
				<th><c:out value="Ações" /></th>
			</tr>
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td style="width: 5%"><c:out value="${usuario.id}" /></td>
					<td><c:out value="${usuario.nome}" /></td>
					<td><c:out value="${usuario.cargo}" /></td>
					<td><c:out value="${usuario.perfil.descricao}" /></td>
					<td>
						<a class="btn btn-primary" href="
														<c:url value="editUsuario.do">  
        													<c:param name="usuarioId" value="${usuario.id}"/>  
     													</c:url> 
														"><i class="icon-user icon-white"></i> Editar</a>  
						<a class="btn btn-danger" href="
														<c:url value="removeUsuario.do">  
							        						<c:param name="usuarioId" value="${usuario.id}"/>  
							     						</c:url>
 													   "><i class="icon-trash icon-white"></i> Remover</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">		
					<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
				</td>
			</tr>			
		</table>
		</center>        
    </jsp:body>
</layout:page>