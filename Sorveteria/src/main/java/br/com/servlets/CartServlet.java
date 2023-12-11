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
import java.util.List;

import br.com.DAO.CartDAO;
import br.com.DTO.CartDTO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String idCliente = (String) session.getAttribute("idCliente");
        System.out.println(idCliente);
		RequestDispatcher dispatcher = null;
        
		try {
			
		
        if (idCliente != null) {
            // Chame o DAO para recuperar os dados do carrinho
            CartDAO cartDAO = new CartDAO();
            List<CartDTO> cartItems = cartDAO.getAllItems(Integer.parseInt(idCliente));

            // Armazene os resultados na solicitação e encaminhe para a página JSP
            request.setAttribute("cartItems", cartItems);
            
			dispatcher = request.getRequestDispatcher("cart.jsp");
            dispatcher.forward(request, response);
        } 
        
	}catch (Exception e) {
		e.printStackTrace();
	}
        
        
       // request.getRequestDispatcher("cart.jsp").forward(request, response);
	}



}
