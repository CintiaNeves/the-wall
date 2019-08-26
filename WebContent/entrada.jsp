<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Entrada Nota Fiscal</title>
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
<script type="text/javascript" src="vendors/jquery/mask.min.js"></script>
<style>
.input-transparent {
	margin-bottom: 5px;
	border: 0;
	background-color: rgba(0, 0, 0, 0);
}
.table-striped tbody tr:nth-of-type(even) {
    background-color: #c1c1c1;
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
	<section class="section-margin" style="margin-left: 10%;">
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

				</div>
			</div>
			<div class="col-md-11 form-group p_star">
				<h3>Documento de Entrada</h3>
			</div>
			<form action="entrada" method="post">
				<div id="entrada-estoque" class="col-md-12 form-group p_star">
					<div id="cabecalho" class="col-md-11">
						<div class="row">
							<div class="col-md-3 form-group p_star">
								<label for="nota">Número da Nota</label> 
								<input class="form-control" type="text" name="nota" id="nota" value="${entrada.nota}"/>
								<input class="form-control" type="hidden" name="linhas" id="linhas" value="${entrada.nota}"/>
							</div>
							<div class="col-md-3 form-group p_star">
								<label for="cnpj">CNPJ Fornecedor</label> 
								<input class="form-control" type="text" name="cnpj" id="cnpj" value="${entrada.fornecedor.cnpj}"/>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="razaoSocial">Razão Social</label> 
								<input class="form-control" type="text" name="razaoSocial" id="razaoSocial"readonly="readonly" value="${entrada.fornecedor.razaoSocial}"/>
							</div>
							
						</div>
					</div>
					<br />
				</div>

				<div class="col-md-11 form-group p_star">
					<h3>Itens</h3>
				</div>
				<div id="itens" class="col-md-11">
					<div id="mensagem">
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Código</th>
								<th>Descrição</th>
								<th>Quantidade</th>
								<th>Custo Unitário</th>
								<th>Total</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody id="tbody_itens">
							<tr>
								<td class="m-0 p-0 pt-1">
									<input class="form-control input-transparent" name="codigo" id="codigo"/>
								</td>
								<td class="m-0 p-0 pt-1">
									<label class="form-control input-transparent" id="descricao"></label>
								</td>
								<td class="m-0 p-0 pt-1">
									<input class="form-control input-transparent" name="quantidade" id="quantidade" />
								</td>
								<td class="m-0 p-0 pt-1">
									<input class="form-control input-transparent" name="custo" id="custo"/>
								</td>
								<td class="m-0 p-0 pt-1">
									<label class="form-control input-transparent" id="total"></label>
								</td>
								<td class="m-0 p-0 pt-1">
									<button type="button" onclick="remover(this)" class="btn btn-link">Remover</button>
								</td>
						</tbody>
					</table>
					<div class="col-md-11">
						<button class="btn btn-secondary" type="button" name="adicionar" id="adicionar">Adicionar
							Item</button>
					</div>
				</div>
				<br/>
				<div class="float-right col-md-3 form-group p_star mr-5 pr-5">
					<div class="col justify-content-end mr-4 pr-4">
						<label for="codigo">Total Nota</label> 
						<input class="form-control right" type="text" name="totalNota" id="totalNota" />
					</div>
				</div>
				<div
					class="row justify-content-end p-1 col-md-11 form-group p_star">
					<button class="btn btn-primary" type="submit" name="btnOperacao" value="SALVAR">Gravar Entrada</button>
				</div>
			</form>
		</div>
	</section>
	<!--================End Form Cadastro Area =================-->

</body>
<script>
// remover linha da tabela de regitros
function remover(button) {
	$("#tbody_itens")[0].removeChild(button.parentElement.parentElement);
	$("#tbody_itens").change();
}

$("#cnpj").change(function() {
	let cnpj = this.value;
	let nota = $("#nota")[0].value;
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/fornecedor",
		dataType: "json",
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
			cnpj: cnpj,
		},
		success: function(response) {
			if(response.erro) {
				$("#mensagem").innerHTML = response.erro;
				$("#mensagem").removeAttr("style");
				$("#mensagem").addClass("alert alert-danger");
			} else {
				$("#data").val(response.data);
				$("#razaoSocial").val(response.razaoSocial);				
			}
		},
		error: function(error) {
			console.log(error);
		}
	});		
});

$("#tbody_itens").change(function(){
	let totalNota = 0;
	if(this.rows.length === 0) {
		$("#totalNota").val((0).toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
		$("#linhas").val(tbody_itens.children.length);
	}
	for(row of this.rows) {
		if(row.children[0].children[0].value) {
			let codigo = row.children[0].children[0].value;
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/the-wall-crud/instrumento",
		        async: false,
				dataType: "json",
				data: {
					retornoJson: true,
					btnOperacao: "CONSULTAR",
					codigo: codigo
				},
				success: function(response) {
					if(response.erro) {
						$("#mensagem").removeAttr("style");
						$("#mensagem").addClass("alert alert-danger");
						$("#mensagem")[0].innerText = response.erro;
					} else {
						row.children[1].children[0].innerHTML = response.descricao;
					}
				},
				error: function(error) {
					console.log(error);
				}
			});		
		}
		let total = row.children[4].children[0].value;
		total = row.children[2].children[0].value * row.children[3].children[0].value;
		totalNota += total;
		totalFormatado = Number(total).toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' });
		row.children[4].children[0].innerHTML = totalFormatado;
		$("#totalNota").val(totalNota.toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
		$("#linhas").val(tbody_itens.children.length);
	}
});

$("#adicionar").click(function(){
	let rowCount = $("#tbody_itens")[0].childElementCount;
	let row = "" +
	"<tr>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='codigo" + rowCount + "' id='codigo" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<label class='form-control input-transparent' id='descricao'></label>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='quantidade" + rowCount + "' id='quantidade" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='custo" + rowCount + "' id='custo" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<label class='form-control input-transparent' id='total'></label>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<button type='button' onclick='remover(this)' class='btn btn-link'>Remover</button>" +
		"</td>" +
	"</tr>";
	$("#tbody_itens").append(row);
});
</script>
</html>