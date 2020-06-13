import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserDAO")
public class UserDAO {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public UserDAO() {};
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    protected void disconnect() throws SQLException {
    	
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public boolean validate(String u, String p) throws SQLException {
    	boolean flag = false;
    	String sql = "select * from user where Username = ?";
    	connect_func();
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, u);
		  
		resultSet = preparedStatement.executeQuery(); 
		if (resultSet.next()) {
		
			String fp = resultSet.getString("Password"); 
			String fu = resultSet.getString("Username");
			if (fp.equals(p) && fu.equals(u)) {
				System.out.println("------Validation complete------");
				flag = true;
			}
				
		}
		resultSet.close();
		preparedStatement.close();
    	disconnect();
    	return flag;
    }
    
    public boolean insert (User user) throws SQLException {
    	connect_func();
    	
    	String sql = "insert into  user(Username, Password, First_name, Last_name, Age) values (?, ?, ?, ?, ?)";
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	preparedStatement.setString(1, user.username);
    	preparedStatement.setString(2, user.password);
    	preparedStatement.setString(3, user.first_name);
    	preparedStatement.setString(4, user.last_name);
    	preparedStatement.setInt(5, user.age);
    	
    	boolean rowInserted = preparedStatement.executeUpdate() > 0;
    	System.out.println("-------USER ADDED------");
    	disconnect();
    	return rowInserted;
    }
    
}
