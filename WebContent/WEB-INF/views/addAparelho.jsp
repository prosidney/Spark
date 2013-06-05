<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="Spark" description="Listagem de usuário" keywords="amazing, app, Spark" user="${sessionScope.usuarioLogado.nome}">
    <jsp:attribute name="extraHeader">
		<script type="text/javascript">
			function enforceNumericValue(obj){  
				 //  check for valid numeric strings	
				   {
					   var strValidChars = "0123456789";
					   var strChar;
					   var blnResult = true;
		
					  // if (strString.length == 0) return false;
		
					   //  test strString consists of valid characters listed above
					   for (i = 0; i < obj.value.length && blnResult == true; i++){
					      strChar = obj.value.charAt(i);
					      if (strValidChars.indexOf(strChar) == -1){
						 blnResult = false;
						 obj.value = obj.value.substring(0, obj.value.length-1);
					      }
					   }
					   //return blnResult;
				   }
		  	}	
		 </script>
    </jsp:attribute>
    <jsp:body>     
		<center>
			<h4>Aparelho</h4>
			<form:form action="saveAparelho.do" id="form" commandName="aparelho" method="post" class="navbar-form pull-center">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Usuário</td>
						<td><form:input path="usuario" class="span3" readonly="true"/></td>
						<%-- <c:out value="${aparelho.usuario.nome}"></c:out> --%>
					</tr>		
					<tr>
						<td>Nome:</td>
						<td><form:input path="nome" class="span3"/></td>
					</tr>		
					<tr>
						<td>Chassi:(Apenas numeros)</td>
						<td><form:input path="numChassi" onKeyUp="enforceNumericValue(this);" class="span3"/></td>
					</tr>	
					<tr>
						<td>Marca:</td>
						<td><form:textarea path="marca" class="span3"/></td>
					</tr>
					<tr>
						<td>Modelo:</td>
						<td><form:textarea path="modelo" class="span3"/></td>
					</tr>	
					<tr>
						<td>Data Inclusão:</td>
						<td><form:input path="dtInclusao" readonly="true" class="span3"/></td>
					</tr>	
					<tr>
						<td>Situação</td>
						<td>
							<form:select path="situacaoAtual" class="span3">
								<form:option value="A" label="Ativo" />
								<form:option value="I" label="Inativo" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<center>
							<a class="btn" href="#" onclick="document.forms[0].submit()"><i class="icon-plus-sign icon-black"></i> Salvar</a>
							<a class="btn" href="<c:url value="listAparelhos.do"/>"><i class="icon-th-list icon-black"></i> Listar Aparelhos</a>
							<a class="btn" href="<c:url value="home.do"/>"><i class="icon-home icon-black"></i> Home</a>
						</center>
						</td>
					</tr>		
					<tr>
				</tr>
				</table>
			</form:form>
			<br/>
		</center>
    </jsp:body>
</layout:page>