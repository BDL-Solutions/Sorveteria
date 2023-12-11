package br.com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.DAO.CartDAO;
import br.com.DAO.DeleteSorveCartDAO;
import br.com.DAO.InsereCartDAO;
import br.com.DTO.CartDTO;

/**
 * Servlet implementation class AddSorveCart
 */
//Decorado com @WebServlet sera uma 'url' para acessar o servlet.
@WebServlet("/AddSorveCart")
public class AddSorveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSorveCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		// Objeto que sera inserido transposto para o carrinho
		CartDTO objCartDTO = new CartDTO();
		
        String idCliente = (String) session.getAttribute("idCliente");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        int idClienteInt = Integer.parseInt(idCliente);
        
        objCartDTO.setIdCliente(idClienteInt);
        objCartDTO.setQuantidade(quantidade);
        objCartDTO.setIdProduto(idProduto);
        
        
        InsereCartDAO objInsereCartDAO = new InsereCartDAO();
        try {
			objInsereCartDAO.InsereNoCart(objCartDTO);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        dispatcher = request.getRequestDispatcher("cart.jsp"); 
        dispatcher.forward(request, response);

      

}}
