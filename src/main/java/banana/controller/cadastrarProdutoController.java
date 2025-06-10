package banana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banana.model.Produto;

@WebServlet("/cadastrarProdutoController")
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarProdutoController() {
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

		String mensagem;
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
		
		if (request.getParameter("descricao") != null && !request.getParameter("descricao").isEmpty() && request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() && request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {

			String descricao;
			int quantidade;
			double preco;
			boolean online;
			
			descricao = request.getParameter("descricao");
			
			online = false;
			
			quantidade = Integer.parseInt(request.getParameter("quantidade"));
			preco = Double.parseDouble(request.getParameter("preco"));

			if (request.getParameter("online") != null && request.getParameter("online").equals("on"))
				online = true;

			Produto produto = new Produto(descricao, quantidade, preco, online);
			produto.salvar();

			mensagem = "Produto Cadastrado com Sucesso!";
		} else {
			mensagem = "Os campos precisam ser preenchidos!";
		}

		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
	}

}
