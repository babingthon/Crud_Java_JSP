<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banana Bacana</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/bananaStyle.css">
</head>
<body>
	<nav class="bananaNav">
		<ul
			class="d-flex justify-content-center align-items-center list-unstyled p-3 gap-4">
			<li><span style="color: yellow; font-weight: bold;">BananaBacana</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>

	<main class="bananaMain">
		<form action="cadastrarProduto" method="post" class="bananaForm">
			<div class="d-flex align-items-center gap-3">
				<label class="fw-bold">Descrição:</label> <input type="text"
					name="descricao" class="form-control">
			</div>
			<div class="d-flex align-items-center gap-3">
				<label class="fw-bold">Quantidade:</label> <input type="text"
					name="quantidade" class="form-control">
			</div>
			<div class="d-flex align-items-center gap-3">
				<label class="fw-bold">Preço:</label> <input type="text"
					name="preco" class="form-control">
			</div>
			<div class="form-check bananaCheckbox">
				<input type="checkbox" id="online" name="online"
					class="form-check-input"> <label for="online"
					class="form-check-label fw-bold">Disponível On-Line:</label>
			</div>
			<div>
				<input id="bananaButton" type="submit" name="salvar"
					value="Cadastrar Produto" class="btn">
			</div>
			<div>
				<%
			  String mensagem = (String) request.getAttribute("mensagem");
			if (mensagem != null){
				out.print(mensagem);
			}
			%>
			</div>
		</form>
	</main>
</body>
</html>
