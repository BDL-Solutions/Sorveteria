package net.com.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

public class ShopServlet extends HttpServlet {

@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
 throws ServletException, IOException { }

//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // Lógica de negócios, se necessário

    // Encaminha a solicitação para a página JSP correspondente
//    RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
//    dispatcher.forward(request, response);
//	}

}
