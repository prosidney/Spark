<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usu�rio" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>  
		<center>
			<table class="table table-hover" style="width: 60%">
				<tr>
					<th colspan="3" style="text-align: center;"><c:out value="Perfis" /></th>
				</tr>
				<tr>
					<th colspan="3" style="text-align: center;"><a href="addPerfil.do">Adicionar</a></th>
				</tr>
				<tr>
					<th><c:out value="ID" /></th>
					<th><c:out value="Descri��o" /></th>
					<th><c:out value="A��es" /></th>
				</tr>
				<c:forEach var="perfil" items="${perfis}">
					<tr>
						<td style="width: 5%"><c:out value="${perfil.id}" /></td>
						<td><c:out value="${perfil.descricao}" /></td>
						<td>
							<a class="btn btn-primary" href="
															<c:url value="editPerfil.do">  
	        													<c:param name="perfilId" value="${perfil.id}"/>  
	     													</c:url>
															"><i class="icon-user icon-white"></i> Editar</a>  
							<a class="btn btn-danger" href="
															<c:url value="removePerfil.do">  
								        						<c:param name="perfilId" value="${perfil.id}"/>  
	     													</c:url> 
	 													   "><i class="icon-trash icon-white"></i> Remover</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" style="text-align: center;">		
						<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
					</td>
				</tr>			
			</table>
		</center>
    </jsp:body>
</layout:page>