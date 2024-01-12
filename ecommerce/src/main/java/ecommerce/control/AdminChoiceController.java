package ecommerce.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductControl
 */
@WebServlet("/AdminChoiceController")
public class AdminChoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChoiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminopt=request.getParameter("Adminop");
		
		if(adminopt.equals("ADD")) {
			RequestDispatcher rd= request.getRequestDispatcher("addproduct.jsp");
			rd.forward(request, response);
			
		}
		else if(adminopt.equals("USER")) {
			RequestDispatcher rd= request.getRequestDispatcher("/Userviewcontroller");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/ProductViewChoice");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
