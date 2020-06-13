import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    boolean ans;
    private UserDAO userDAO;
 
    public void init() {
        userDAO = new UserDAO();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("Request path: " + action);
        try {
            switch (action) {
            case "/validate":
            	rootUser(request, response);
            	break;
            case "/new":
            	newUser(request, response);
            	break;
            case "/insert":
            	insertUser(request, response);
            	break;
            default:
            	defaultController(request, response);           	
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void defaultController(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {     
    	//TO-DO
    	System.out.println("Default controller activated.");
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Landing.jsp");       
        dispatcher.forward(request, response);
    }
    
    private void rootUser(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	String uname = request.getParameter("username");
    	String pword = request.getParameter("password");
    	ans = userDAO.validate(uname, pword);
    	if(ans) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("Landing.jsp");       
            dispatcher.forward(request, response);
    	}
    	else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("credential.jsp");       
            dispatcher.forward(request, response);
    	}
    	System.out.println(uname + ' ' + pword + ' ' + ans);
    }
    
    private void newUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
    	RequestDispatcher dispatcher = request.getRequestDispatcher("NewUserForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	String fn = request.getParameter("firstname");
    	String ln = request.getParameter("lastname");
    	String un = request.getParameter("username");
    	String pw = request.getParameter("password");
    	String pw2 = request.getParameter("password2");
    	String age = request.getParameter("age");
    	
    	if(pw.equals(pw2)) {
    		User newUser = new User(fn, ln, un, pw, Integer.parseInt(age));
            userDAO.insert(newUser);
    	}

    	
    }

}