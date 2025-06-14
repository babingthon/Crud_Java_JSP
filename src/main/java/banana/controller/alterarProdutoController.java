package banana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banana.model.Produto;

@WebServlet("/alterarProdutoController")
public class alterarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public alterarProdutoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String descricao = request.getParameter("descricao");
		String id = request.getParameter("id");
		String mensagem;
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
		if (descricao != null && !descricao.isEmpty() && request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() && request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {
			int quantidade;
			double preco;
			quantidade = Integer.parseInt(request.getParameter("quantidade"));
			preco = Double.parseDouble(request.getParameter("preco"));
			boolean online = false;
			if (request.getParameter("online") != null && request.getParameter("online").equals("true"))
				online = true;
			Produto produto = new Produto(descricao, quantidade, preco, online);
			produto.setIdProduto(Integer.valueOf(id));
			produto.alterar();
			mensagem = "Produto alterado com sucesso!";
		} else
			mensagem = "Os campos precisam ser preenchidos!";
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
	}

}
