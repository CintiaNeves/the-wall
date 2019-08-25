<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Consulta</title>
<link rel="icon" href="img/Fevicon.png" type="image/png">
<link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
<link rel="stylesheet" href="vendors/linericon/style.css">
<link rel="stylesheet"
	href="vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="vendors/nice-select/nice-select.css">
<link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">

<link rel="stylesheet" href="css/style.css">

<script type="text/javascript" src="vendors/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="vendors/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<h1>The Wall</h1>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
				 		data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto mr-auto">
							<li class="nav-item"><a class="nav-link" href="index.html">Site</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Pedidos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta-pedido.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Produtos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="cadastro.jsp">Cadastro</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Estoque</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="entrada-estoque.html">Entrada</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta-estoque.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Relatórios</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="grafico.html">Vendas</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->
	<!--================Form Cadastro Area =================-->
	<section class="section-margin" style="margin-left: 15%;">
        <div class="billing_details">
            <div class="row">
                <div class="col-md-10">
                    <div class="col-md-12 form-group p_star">
                        <h3>Consulta de instrumentos cadastrados</h3>
                    </div>
                    <!--============================= Message validation =============================-->
                    <div style="${(sucesso == null || (fn:length(sucesso) == 1 && sucesso[0] == '')) 
                   			   && (erro == null || fn:length(erro) == 1 && erro[0] == '') ? 'display:none;' : ''}" 
                    	class="${sucesso != null ? 'alert alert-primary' : erro != null ? 'alert alert-danger' : ''}" role="alert">
					  	<c:forEach var="sucesso" items="${sucesso}">
					  		${sucesso}<br/>
					  	</c:forEach>
					  	<c:forEach var="erro" items="${erro}">
					  		${erro}<br/>
					  	</c:forEach>
					</div>
					<!--============================= Message validation =============================-->
                    <div>
	                    <form action="instrumento" method="post">
	                    <button class="btn btn-secondary" type="submit" name="btnOperacao" id="btnOperacao" value="CONSULTAR">Listar todos</button>
             			<br/><br/>
	                         <div class="row">
	                             <div class="col-small">
	                                 <div class="input-group ml-3">
	                                     <div class="input-group-prepend">
	                                         <button class="btn btn-outline-secondary" type="submit" name="btnOperacao" value="CONSULTAR">Buscar por descrição</button>
	                                     </div>
	                                     <input type="text" class="form-control" name="descricao"/>
	                                 </div>
	                             </div>
	                         </div>
                         <br />
                         <hr />
                    </form>
                    <div id="">
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr style="text-align: center;">
                                    <th>Código</th>
                                    <th>Descrição</th>
                                    <th>Categoria</th>
                                    <th>Subcategoria</th>
                                    <th>Ativo</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="instrumento" items="${instrumentos}" >               	
	                                <tr style="text-align: center;">
	                                    <td style="padding-top:19px;">${instrumento.codigo}</td>
	                                    <td style="padding-top:19px;">${instrumento.descricao}</td>
	                                    <td style="padding-top:19px;">${instrumento.categoria.descricao}</td>
	                                    <td style="padding-top:19px;">${instrumento.categoria.subcategoria.descricao}</td>
	                                    <td style="padding-top:19px;">${instrumento.ativo ? 'Sim' : 'Não'}</td>
	                                    <td>
			                            	<form action="instrumento" method="post">             
            				                	<input type="hidden" name="id" value="${instrumento.id}" />
	                        	            	<button class="btn btn-link" type="submit" name="btnOperacao" value="CONSULTARBYID">Editar</button>
	                            	        	<button class="btn btn-link" type="button" name="btnOperacao" value="EXCLUIR" 
	                            	        		data-toggle="modal" data-target="#exampleModalCenter" onclick="storeId(${instrumento.id})">Excluir</button>
	                            	        	<a class="btn btn-link"
	                            	        		href="ocorrencia.jsp?id=${instrumento.id}&descricao=${instrumento.descricao}&codigo=${instrumento.codigo}&ativo=${instrumento.ativo}">${!instrumento.ativo ? 'Ativar' : 'Inativar'}</a>
                            	   			</form>
	                                    </td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<!--================End Form Cadastro Area =================-->
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" 
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">Excluir Item</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja excluir o item selecionado?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" id="cancelar_modal" data-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-primary" id="excluir_modal" data-dismiss="modal">Excluir</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
<script>
	var id = 0;
	function storeId(instrumentoId) {
		id = instrumentoId;
	};
	$("#excluir_modal").click(function() {
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/the-wall-crud/instrumento",
			data: {btnOperacao: "EXCLUIR", id: id},
			success: function(response) {
				var bntOperacao = "CONSULTAR";
				$("#btnOperacao").trigger("click", [bntOperacao]);
			},
			error: function(error) {
				console.log(error);
			}
		});		
	})
</script>
</html>
