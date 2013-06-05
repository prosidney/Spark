<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Home" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:body>
        <center>
			<table class="table table-hover">
				<tr>
					<th colspan="7" style="text-align: center;" style="width: 80%"><c:out value="Prevencões" /></th>
				</tr>
				<tr>
					<center>
						<td colspan="7" style="text-align: center;">
							<form action="addPrevApar.do" method="POST" class="navbar-form pull-center">
								<select name="aparPrevId" class="span3">
									<c:forEach var="aparelho" items="${aparelhos}">
								 		<option value="${aparelho.id}"> <c:out value="${aparelho.nome}"/> </option>
									</c:forEach>
								</select>
								<button class="btn btn-large btn-success" type="submit" value="Nova Prevenção"><i class="icon-play icon-white"></button>	
							</form>
						</td>
					</center>
				</tr>			
				<tr>
					<th><c:out value="id" /></th>
					<th><c:out value="Aparelho" /></th>
					<th><c:out value="Inicio" /></th>
					<th><c:out value="Fim" /></th>
					<th><c:out value="Progresso" /></th>
					<th><c:out value="Duração(Horas)" /></th>
					<th><c:out value="Ações" /></th>
				</tr>
				<c:forEach var="prevencao" items="${prevencoes}">
					<tr>
						<td style="width: 5%"><c:out value="${prevencao.id}" /></td>
						<td><c:out value="${prevencao.aparelho.nome}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${prevencao.inicio}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${prevencao.fim}" /></td>
						<td>
							<c:choose> 
								<c:when test="${prevencao.fim == null}">
									<div class="progress progress-striped active" style="min-width: 200px;">
									  <div class="bar" style="width: 75%;"></div>
									</div>								  	
								</c:when> 
								<c:otherwise> 
									<div class="progress progress-striped" style="min-width: 200px;">
									  <div class="bar" style="width: 100%;"></div>
									</div>						  	
								</c:otherwise>	
							</c:choose> 
						</td>
						<td><c:out value="${prevencao.duracaoTotal()}" /></td>
						<td>
							<c:choose> 
								<c:when test="${prevencao.fim == null}">
									<!-- <a href="
										<c:url value="stopPrev.do">  
				       						<c:param name="prevId" value="${prevencao.id}"/>  
				    					</c:url> ">Parar
				    				</a>
				    				 -->	
									<a class="btn btn-danger" href="
																	<c:url value="stopPrev.do">  
			        													<c:param name="prevId" value="${prevencao.id}"/>  
			     													</c:url> 
																	"><i class="icon-stop icon-white"></i> Parar</a>				    											  	
								</c:when> 
								<c:otherwise> 
									<a class="btn btn-danger disabled" href="#"><i class="icon-stop icon-white"></i> Parar</a>					  	
								</c:otherwise>	
							</c:choose> 					
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>        
    </jsp:body>
</layout:page>