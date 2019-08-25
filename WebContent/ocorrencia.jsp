<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Ocorrências</title>
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
										href="consulta.jsp">Consulta</a></li>
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
					<!--============================= Message validation =============================-->
					<div
						style="${(sucesso == null || (fn:length(sucesso) == 1 && sucesso[0] == '')) 
                   			   && (erro == null || fn:length(erro) == 1 && erro[0] == '') ? 'display:none;' : ''}"
						class="${sucesso != null ? 'alert alert-primary' : erro != null ? 'alert alert-danger' : ''}"
						role="alert">
						<c:forEach var="sucesso" items="${sucesso}">
					  		${sucesso}<br />
						</c:forEach>
						<c:forEach var="erro" items="${erro}">
					  		${erro}<br />
						</c:forEach>
					</div>
					<!--============================= Message validation =============================-->
					<form class="row contact_form" action="ocorrencia" method="POST">
						<div class="col-md-12 form-group p_star">
							<h3>Gerenciar Status</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="codigo">Código</label> <input type="text"
								class="form-control" id="codigo" name="codigo"
								value="${param['codigo']}" readonly> <input
								type="hidden" name="id" id="id" value="${param['id']}">
							<input type="hidden" name="ativo" id="ativo"
								value="${param['ativo']}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="descricao">Descrição</label> <input type="text"
								class="form-control" id="descricao" name="descricao"
								value="${param['descricao']}" readonly>
						</div>
						<div style="${param['ativo'] ? 'display:none' : ''}"
							class="form-group col-md-6">
							<label class="col-md-12" for="categoria-ativacao">Categoria
								de Ativação</label> <select class="form-control" id="categoria-ativacao"
								name="categoria-ativacao">
								<option value="">Selecione...</option>
								<option value="1"
									${ocorrencia.tipoOcorrencia.id == 1 ? 'selected="selected"' : ''}>Entrada
									em estoque</option>
								<option value="2"
									${ocorrencia.tipoOcorrencia.id == 2 ? 'selected="selected"' : ''}>Demanda
									do mercado</option>
							</select>
						</div>
						<div></div>
						<div style="${!param['ativo'] ? 'display:none' : ''}"
							class="form-group col-md-6">
							<label class="col-md-12" for="categoria-inativacao">Categoria
								de Inativação</label> <select class="form-control"
								id="categoria-inativacao" name="categoria-inativacao">
								<option value="">Selecione...</option>
								<option value="3"
									${ocorrencia.tipoOcorrencia.id == 3 ? 'selected="selected"' : ''}>Sem
									estoque</option>
								<option value="4"
									${ocorrencia.tipoOcorrencia.id == 4 ? 'selected="selected"' : ''}>Fora
									de linha</option>
								<option value="5"
									${ocorrencia.tipoOcorrencia.id == 5 ? 'selected="selected"' : ''}>Sem
									contrato com fornecedor</option>
							</select>
						</div>
						<div class="col-md-12 form-group p_star">
							<label for="detalhes">Justificativa</label>
							<textarea id="detalhes" name="justificativa" class=form-control>${ocorrencia.justificativa}</textarea>
						</div>
						<div class="col-md-12 form-group">
							<div class="col-md-6 form-group">
								<button class="btn btn-primary" type="submit" name="btnOperacao"
									value="SALVAR">${!param['ativo'] ? 'Ativar' : 'Inativar'}</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!--================End Form Cadastro Area =================-->

</body>
</html>