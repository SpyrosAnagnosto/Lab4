package www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import www.Services;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Services check=new Services();
		
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
	  
		
		if(check.usernameExist(username)==false) {
			request.setAttribute("message", "Username doesn't exist!");
	        request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		if(check.accountExist(username, pwd)==false) {
			request.setAttribute("message", "Incorrect password!");
	        request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			response.sendRedirect("logout.html");
		}
	
	}

}
