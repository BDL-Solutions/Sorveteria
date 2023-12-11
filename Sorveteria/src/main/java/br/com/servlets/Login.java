package br.com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_email = request.getParameter("username");
		String pass_word = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sorveteria?useSSL=false&allowPublicKeyRetrieval=true", "root", "La@10laa2004");
			PreparedStatement pst = con.prepareStatement("select *from users where email_user = ? and user_pass_word = ?");
			pst.setString(1,  user_email);
			pst.setString(2,  pass_word);
	
			ResultSet rs = pst.executeQuery();
			
			
			if (rs.next()) {
				session.setAttribute("name", rs.getString("nome_user"));
				session.setAttribute("idCliente", rs.getString("id_user"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
