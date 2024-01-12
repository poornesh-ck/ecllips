package ecommerce.filters;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Registrationfilter
 */
@WebFilter("/Register")
public class Registrationfilter extends HttpFilter implements Filter {
  

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String name = request.getParameter("username");
		String number=request.getParameter("number");
		String email=request.getParameter("email");
		String dob= request.getParameter("dob");
		String pass=request.getParameter("password");
		
		System.out.println(name+number+dob+email);
		ArrayList<String> arr = new ArrayList<String>();

		boolean mail= false;
		if(email.matches("[a-z][a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,4}")) {
			String[] l1=email.split("[@._]");
			String fp=l1[0];
			String sp=l1[1];
			String lp=l1[2];
			
			if(lp.equals("com")||lp.equals("org")||lp.equals("in")) {
				mail=true;
			}
			else {
				arr.add("Invalid Email");
			}
			
		}
		
		LocalDate currentDate = LocalDate.parse(dob);
        int year = currentDate.getYear();
        boolean yeaar =false;
        if(year<2000) {
            yeaar=true;
        }
        else {
            arr.add("your age should be greater than 23");
        }
        boolean passcode=false;
        if (pass.matches("[a-zA-Z0-9]*$")&& pass.length()>8) {
            passcode =true;
        }else {
            arr.add("Enter a strong password");
        }
        Pattern p = Pattern.compile("[6-9][0-9]{9}");
        Matcher m = p.matcher(number);
        boolean phn=false;
        if ((m.find() && m.group().equals(number))) {
            phn=true;
        }
        else {
            arr.add("Please recheck your mobile number");
        }
        if(mail==true&&yeaar==true&&passcode==true&&phn==true) {
        	chain.doFilter(request, response);
        }
        else {
        	for (int i = 0; i < arr.size(); i++) {
                response.setContentType("text/html");
                response.getWriter().println(arr.get(i)+" | ");                
                }
                request.getRequestDispatcher("Registeration.jsp").include(request, response);

        }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
