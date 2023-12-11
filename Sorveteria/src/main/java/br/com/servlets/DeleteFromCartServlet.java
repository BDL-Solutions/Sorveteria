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

import br.com.DAO.DeleteSorveCartDAO;
import br.com.DAO.InsereCartDAO;
import br.com.DTO.CartDTO;

/**
 * Servlet implementation class DeleteFromCartServlet
 */
@WebServlet("/delSorveCart")
public class DeleteFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		// Objeto que sera inserido transposto para o carrinho
		CartDTO objCartDTO = new CartDTO();
		
        String idCliente = (String) session.getAttribute("idCliente");
        //int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        String nomeProduto = (String) (request.getParameter("nomeProduto"));
        int idClienteInt = Integer.parseInt(idCliente);
        
        System.out.print(nomeProduto);
        
        objCartDTO.setIdCliente(idClienteInt);
        //objCartDTO.setIdProduto(idProduto);
        objCartDTO.setNomeProduto(nomeProduto);
        
        DeleteSorveCartDAO objDeleteSorveCartDAO = new DeleteSorveCartDAO();
        try {
        	objDeleteSorveCartDAO.DeleteNoCart(objCartDTO);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        dispatcher = request.getRequestDispatcher("cart.jsp"); 
        dispatcher.forward(request, response);

      
	}

}
