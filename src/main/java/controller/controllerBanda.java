package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banda;
import model.DaoBanda;


@WebServlet(urlPatterns = { "/ControllerBanda", "/main", "/novabanda" })
public class ControllerBanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoBanda DB = new DaoBanda();

	public ControllerBanda() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			lBanda(request, response);
		} else if(action.equals("/novabanda")){
			try {
				novaBanda(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		}else {
			response.sendRedirect("index.html");
		}

	}
//listar
	protected void lBanda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Banda>bandalista = DB.findAll();

		response.sendRedirect("index.jsp");
	}
	
//nova banda
	protected void novaBanda(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("genero"));
		
		Banda banda = new Banda();
		DB.salvar(banda);
		
		response.sendRedirect("main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}









//listar(objeto)