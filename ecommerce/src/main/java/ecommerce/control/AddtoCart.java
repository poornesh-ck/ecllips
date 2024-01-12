package ecommerce.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.model.Cart;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out= response.getWriter()){
			ArrayList<Cart> cartList= new ArrayList<>();
			int id= Integer.parseInt(request.getParameter("pid"));
			
			Cart cm =new Cart();
			cm.setPid(id);
			cm.setQuantity(1);
			
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list =(ArrayList<Cart>) session.getAttribute("cart-list");
			if(cart_list==null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("PageView.jsp");
				
			}
			else {
				cartList= cart_list;
				boolean exist=false;
				for(Cart c:cart_list) {
					if(c.getPid()==id) {
						exist= true;
					}
					
					
				}
				if(!exist) {
					cartList.add(cm);
					response.sendRedirect("PageView.jsp");
					
				}
			}
//			for(Cart c:cart_list) {
//				out.println(c.getPid());
//			}
			
			
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
