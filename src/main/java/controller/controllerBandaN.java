package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import model.Banda;
import model.daoBanda;


//@WebServlet("/controllerBanda")
//@WebServlet(urlPatterns = {"/novabanda","/update"})
public class controllerBandaN extends HttpServlet {
	private static final long serialVersionUID = 1L;
daoBanda DB = new daoBanda();
   
    public controllerBandaN() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		//System.out.println();
		if(action.equals("/novabanda")) {
	            salvar(request,response);
		}
	}
	
	protected void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("NovaBanda.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 private void listBanda(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Banda > listBanda = DB.findAll();
			        request.setAttribute("listagem", listBanda);
			        System.out.println(listBanda.size());
			        RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("index.jsp");
			        dispatcher.forward(request, response);
			    }

			  /*  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("NovaBanda.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int idbanda = Integer.parseInt(request.getParameter("idbanda"));
			        Banda existingBanda = dao.getById(idbanda);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("NovaBanda.jsp");
			        request.setAttribute("banda", existingBanda);
			        dispatcher.forward(request, response);

			    }*/

			    private void insertBanda(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String name = request.getParameter("name");
			        String genero = request.getParameter("genero");
			        
			       // Banda novabanda = new Banda(name, genero);
			     Banda novabanda = new Banda();
			        DB.salvar(novabanda);
			        response.sendRedirect("list");
			    }

			    private void updateBanda(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String name = request.getParameter("name");
			        String genero = request.getParameter("genero");
			       

			       // Banda banda = new Banda(name, genero);
			        Banda banda = new Banda();
			        dao.EditarBanda(banda);
			        response.sendRedirect("list");
			    }

			    private void deleteBanda(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int idbanda = Integer.parseInt(request.getParameter("idbanda"));
			        dao.removeById(idbanda);
			        response.sendRedirect("list");
			    }


}
