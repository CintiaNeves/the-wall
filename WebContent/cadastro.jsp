<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Cadastro</title>
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

<style>
.label {
	color: black;
}
</style>
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
					<form class="row contact_form" action="instrumento" method="POST">
						<div class="col-md-12 form-group p_star">
							<h3>Cadastro de Instrumento</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="codigo">Código</label> 
							<input type="text" class="form-control" id="codigo" name="codigo" value="${instrumento.codigo}" readonly>
							<input type="hidden" name="id" id="id" value="${instrumento.id}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="descricao">Descrição</label> <input type="text" required
								class="form-control" id="descricao" name="descricao" value="${instrumento.descricao}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="marca">Marca</label> <input type="text" required
								class="form-control" id="marca" name="marca" value="${instrumento.marca}">
						</div>
						
						<div class="col-md-6 form-group p_star">
							<label for="modelo">Modelo</label> <input type="text" required
								class="form-control" id="modelo" name="modelo" value="${instrumento.modelo}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cor">Cor</label> <input type="text" required
								class="form-control" id="cor" name="cor" value="${instrumento.cor}">
						</div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="grp-precificacao">Grupo Precificação</label>
                            <select class="form-control" id="grp-precificacao" name="grp-precificacao" required>
                                <option value="">Selecione...</option>
                                <option value="4" ${instrumento.grupoPrecificacao.id == 4 ? 'selected="selected"' : ''}>Classe A - Margem 20 %</option>
                                <option value="3" ${instrumento.grupoPrecificacao.id == 3 ? 'selected="selected"' : ''}>Classe B - Margem 15 %</option>
                                <option value="2" ${instrumento.grupoPrecificacao.id == 2 ? 'selected="selected"' : ''}>Classe C - Margem 10 %</option>
                                <option value="1" ${instrumento.grupoPrecificacao.id == 1 ? 'selected="selected"' : ''}>Classe D - Margem 5 %</option>
                            </select>
                        </div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="categoria">Categoria</label>
                            <select class="form-control" id="categoria" name="categoria" required>
                                <option value="">Selecione...</option>
                                <option value="1" ${instrumento.categoria.id == 1 ? 'selected="selected"' : ''}>Bateria</option>
                                <option value="2" ${instrumento.categoria.id == 2 ? 'selected="selected"' : ''}>Cordas</option>
                                <option value="3" ${instrumento.categoria.id == 3 ? 'selected="selected"' : ''}>Piano</option>
                                <option value="4" ${instrumento.categoria.id == 4 ? 'selected="selected"' : ''}>Sopro</option>
                            </select>
                        </div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="subcategoria">Subcategoria</label>
                            <select class="form-control" id="subcategoria" name="subcategoria" required>
                                <option value="">Selecione...</option>
                                <option value="1" ${instrumento.categoria.subcategoria.id == 1 ? 'selected="selected"' : ''}>Bateria Acústica</option>
                                <option value="2" ${instrumento.categoria.subcategoria.id == 2 ? 'selected="selected"' : ''}>Bateria Eletronica</option>
                                <option value="3" ${instrumento.categoria.subcategoria.id == 3 ? 'selected="selected"' : ''}>Ferragens</option>
                                <option value="4" ${instrumento.categoria.subcategoria.id == 4 ? 'selected="selected"' : ''}>Violão</option>
                                <option value="5" ${instrumento.categoria.subcategoria.id == 5 ? 'selected="selected"' : ''}>Guitarra</option>
                                <option value="6" ${instrumento.categoria.subcategoria.id == 6 ? 'selected="selected"' : ''}>Cavaco</option>
                                <option value="7" ${instrumento.categoria.subcategoria.id == 7 ? 'selected="selected"' : ''}>Banjo</option>
                                <option value="8" ${instrumento.categoria.subcategoria.id == 8 ? 'selected="selected"' : ''}>Bandolin</option>
                                <option value="9" ${instrumento.categoria.subcategoria.id == 9 ? 'selected="selected"' : ''}>Acordeons</option>
                                <option value="10" ${instrumento.categoria.subcategoria.id == 10 ? 'selected="selected"' : ''}>Piano Digital</option>
                                <option value="11" ${instrumento.categoria.subcategoria.id == 11 ? 'selected="selected"' : ''}>Teclados</option>
                                <option value="12" ${instrumento.categoria.subcategoria.id == 12 ? 'selected="selected"' : ''}>Clarinetas</option>
                                <option value="13" ${instrumento.categoria.subcategoria.id == 13 ? 'selected="selected"' : ''}>Flautas</option>
                                <option value="14" ${instrumento.categoria.subcategoria.id == 14 ? 'selected="selected"' : ''}>Gaitas</option>
                                <option value="15" ${instrumento.categoria.subcategoria.id == 15 ? 'selected="selected"' : ''}>Sax</option>
                                <option value="16" ${instrumento.categoria.subcategoria.id == 16? 'selected="selected"' : ''}>Trompete</option>
                            </select>
                        </div>
                        <div class="col-md-6 form-group p_star">
							<label for="valor-custo">Valor Custo R$</label> <input type="text" readonly
								class="form-control" id="valor-custo" name="valor-custo" value="${instrumento.valorCusto}">
						</div>
						
						<div class="col-md-6 form-group p_star">
							<label for="valor-venda">Valor Venda R$ </label> <input type="text" readonly
								class="form-control" id="valor-venda" name="valor-venda" value="${instrumento.valorVenda}">
						</div>
						<div class="col-md-12 form-group p_star">
							<label for="detalhes">Detalhes</label> <input type="text" required
								class="form-control" id="detalhes" name="especificacoes" value="${instrumento.especificacoes}">
						</div>
						<div class="col-md-6 form-group">
							<div class="col-md-6 form-group">
								<button class="btn btn-primary" type="submit" name="btnOperacao" value="${instrumento.id != null ? 'ALTERAR' : 'SALVAR'}">${instrumento.id != null ? 'ALTERAR' : 'SALVAR'}</button>
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