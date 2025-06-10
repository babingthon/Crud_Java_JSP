package banana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banana.model.Produto;

@WebServlet("/modificarProdutoController")
public class modificarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public modificarProdutoController() {
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

		String apagar = request.getParameter("apagar");
		String alterar = request.getParameter("alterar");
		String id = request.getParameter("id");

		if (apagar != null && id != null) {
			new Produto().excluir(Integer.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
			request.setAttribute("mensagem", "Produto apagado com sucesso!");
			dispatcher.forward(request, response);
		} else if (alterar != null && id != null) {
			Produto produto = new Produto().buscarProdutoPorId(Integer.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterarProduto.jsp");
			request.setAttribute("produto", produto);
			dispatcher.forward(request, response);
		}
	}

}
