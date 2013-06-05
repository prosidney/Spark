<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>   
		<center>
			<table class="table table-hover" style="width: 60%">
				<th colspan="4" style="text-align: center;"><c:out value="Aparelhos" /></th>
				<tr>
					<th colspan="4" style="text-align: center;"><a href="addAparelho.do">Adicionar</a></th>
				</tr>
				<tr>
					<th><c:out value="ID" /></th>
					<th><c:out value="Nome" /></th>
					<th><c:out value="Situação" /></th>
					<th><c:out value="Ações" /></th>
				</tr>
				<c:forEach var="aparelho" items="${aparelhos}">
					<tr>
						<td style="width: 5%"><c:out value="${aparelho.id}" /></td>
						<td><c:out value="${aparelho.nome}" /></td>
						<td>
							<c:choose> 
								<c:when test="${aparelho.situacaoAtual eq 'A'}">
									<c:out value="Ativo" />							  	
								</c:when> 
								<c:otherwise> 
									<c:out value="Inativo" />							  	
								</c:otherwise>	
							</c:choose> 
							<!-- ${'hip' gt 'hit'}  -->	
						</td>
						<td>
							<a class="btn btn-primary" href="
															<c:url value="editAparelho.do">  
	        													<c:param name="aparelhoId" value="${aparelho.id}"/>  
	     													</c:url> 
															"><i class="icon-user icon-white"></i> Editar</a>
									
							<a class="btn btn-danger" href="
															<c:url value="removeAparelho.do">  
	        													<c:param name="aparelhoId" value="${aparelho.id}"/>  
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