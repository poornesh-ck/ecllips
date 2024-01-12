package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Product;
import ecommerce.service.ProductService;

/**
 * Servlet implementation class ProductService
 */
@WebServlet("/ProductChoice")
public class ProductChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String pdesc=request.getParameter("pdesc");
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		Double pprice=Double.parseDouble(request.getParameter("price"));
		Product p= new Product(pid,pname,pdesc,pprice,pqty);
		ProductService ps= new ProductService();
		try {
			ps.addp(p);
			response.setContentType("text/html");
			response.getWriter().println("<h1><b style='color:green'>Product Created</b></h1>");
			request.getRequestDispatcher("addproduct.jsp").include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.setContentType("text/html");
			response.getWriter().println("<h1><b style='color:red'>Product Not Created Someting went wrong </b></h1>");
			request.getRequestDispatcher("addproduct.jsp").include(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
