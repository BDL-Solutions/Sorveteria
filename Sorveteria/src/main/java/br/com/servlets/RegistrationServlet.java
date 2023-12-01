package br.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con; // Declarar a variável aqui para torná-la acessível em todo o escopo da classe

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("name");
        String user_email = request.getParameter("email");
        String user_pass_word = request.getParameter("pass");
        String user_phone = request.getParameter("contact");
        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sorveteria?useSSL=false","root","La@10laa2004");
            PreparedStatement pst = con.prepareStatement("insert into users (nome_user, email_user, user_pass_word, user_phone) values (?,?,?,?)");
            pst.setString(1, user_name);
            pst.setString(2, user_email);
            pst.setString(3, user_pass_word);
            pst.setString(4, user_phone);

            int rowCount = pst.executeUpdate(); // se gravado fica maior que 0
            dispatcher = request.getRequestDispatcher("registration.jsp");
            if (rowCount > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }

            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
