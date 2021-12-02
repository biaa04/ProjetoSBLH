package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Banda;
import controller.DAO;

@WebServlet(urlPatterns = {"/novabanda","/update"})
public class Servlet extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	    DAO dao = new DAO();
	   
       public Servlet() {
			super();
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/novabanda":
	                	insertBanda(request, response);
	                 //   showNewForm(request, response);
	                    break;
	               /* case "/insert":
	                    insertBanda(request, response);
	                    break;*/
	                case "/delete":
	                    deleteBanda(request, response);
	                    break;
	              //  case "/edit":
	                 //   showEditForm(request, response);
	               //     break;
	                case "/update":
	                    updateBanda(request, response);
	                    break;
	                default:
	                    listBanda(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }

	    private void listBanda(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Banda > listBanda = dao.findAll();
	        request.setAttribute("listagem", listBanda);
	        System.out.println(listBanda.size());
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
	        dao.NewBanda(novabanda);
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
