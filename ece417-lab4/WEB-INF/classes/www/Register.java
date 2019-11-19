package www;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.User;
import www.Services;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }
    private static boolean checkUsername(String username) {
    	if(username.length()<4) {
    		return true;
    	}
    	return false;
    }
    
    private static boolean checkPassLen(String pwd) {
    	if(pwd.length()<5) {
    		return true;
    	}
    	return false;
    }
    
    private static boolean checkPass(String pwd) {
    	char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        
    	for(int i=0;i < pwd.length();i++) {
            ch = pwd.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
    	return false;
    }
    
    private static boolean passisEqual(String pwd,String rpwd) {
    	return pwd.equals(rpwd);
    }
    
    private static boolean checkAge(String age) {
    	try {
    		int x =Integer.parseInt(age);
    		if(x<120) {
    			return true;
    		}
    		return false;
    	}catch(NumberFormatException e) {
    		return false;
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname=request.getParameter("fullname");
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String rpwd=request.getParameter("password2");
		String email=request.getParameter("email");
		String bday=request.getParameter("age");
		Services check=new Services();
		
		//NULL CHECKS
		if(fullname.length()==0 || username.length()==0 || pwd.length()==0 || email.length()==0 || bday.length()==0) {
			request.setAttribute("message", "Please fill every field!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		//USERNAME CHECKS
		if(checkUsername(username)==true) {
			request.setAttribute("message", "Username must be at least 4 characters!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		if(check.usernameExist(username)==true) {
			request.setAttribute("message", "Username already in use!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		//PASS CHECKS
		if(checkPassLen(pwd)==true) {
			request.setAttribute("message", "Password must be at least 4 characters!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		if(checkPass(pwd)==false) {
			request.setAttribute("message", "Pass need uppercase,lowercase and number!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		if(passisEqual(pwd,rpwd)==false){
			request.setAttribute("message", "Passwords do not match!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		
		//EMAIL CHECKS
		if(check.emailExist(email)==true) {
			request.setAttribute("message", "Email already in use!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		if(checkAge(bday)==false) {
			request.setAttribute("message", "Enter a valid age!");
	        request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		//INSERT NEW ENTITY
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "Lab4" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    entitymanager.getTransaction( ).begin( );
	    
	    int id=check.maxid();
	    id +=1;
	    User user = new User( ); 
	    user.setId( id );
	    user.setUsername( username );
	    user.setPassword( pwd );
	    user.setFullname( fullname );
	    user.setEmail( email );
	    user.setBday( bday );
	    
	    entitymanager.persist( user );
	    entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    ufactory.close( );
	    response.sendRedirect("login.jsp");
		
	}

}
