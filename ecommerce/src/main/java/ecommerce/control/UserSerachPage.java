package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Product;
import ecommerce.service.UserService;

/**
 * Servlet implementation class UserSerachPage
 */
@WebServlet("/UserSerachPage")
public class UserSerachPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSerachPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pname=request.getParameter("custsearch");
        UserService cs=new UserService ();
        List<Product> prolist=null;
        try {
            prolist = cs.custsearch(pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        request.setAttribute("prolist", prolist);
        request.getRequestDispatcher("userhome.jsp").include(request, response);
        request.getRequestDispatcher("userview.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
