package ecommerce.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class productcheck
 */
@WebFilter("/ProductChoice")
public class productcheck extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public productcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String pdesc=request.getParameter("pdesc");
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		Double pprice=Double.parseDouble(request.getParameter("price"));
		
		if(pid>0 && pname != null && pprice>0 &&pqty>0) {
			chain.doFilter(request, response);
			
		}
		else {
			response.setContentType("text/html");
			response.getWriter().println("<h1><b style='color:red'>Enter valid detalis </b></h1>");
			request.getRequestDispatcher("addproduct.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
