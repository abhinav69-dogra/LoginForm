package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.Result;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String email=request.getParameter("email");
		   String password=request.getParameter("password");
		   HttpSession session=request.getSession();
		   RequestDispatcher dispatcher=null;
		   Connection con=null;
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
		    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maersk?useSSL=false","root","Coldplay@069");
		    	 PreparedStatement pst=con.prepareStatement("select * from users where email=? and password=?");
		    	 pst.setString(1, email);
		    	 pst.setString(2, password);
		    	 ResultSet rs=pst.executeQuery();
		    	 if(rs.next()) {
		    		 session.setAttribute("name", rs.getString("username"));
		    		 dispatcher=request.getRequestDispatcher("index.jsp");
		    	 }
		    	 else {
		    		 request.setAttribute("status", "failed");
		    		 dispatcher=request.getRequestDispatcher("login.jsp");
		    	 }
		    	 dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
