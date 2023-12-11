package br.com.DAO;

// CartDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.DTO.CartDTO;

public class CartDAO {
	
    public List<CartDTO> getAllItems(int idCliente) throws ClassNotFoundException, SQLException {
        List<CartDTO> cartItems = new ArrayList<>();
        Connection con;
        con = new ConectionDAO().conexaoBD();
        
        try (con /* obter a conexão com o banco de dados */) {
            String query = "SELECT * FROM cart WHERE idCliente = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setInt(1, idCliente);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        CartDTO cartItem = new CartDTO();
                        cartItem.setValor(resultSet.getString("valor"));
                        cartItem.setQuantidade(resultSet.getInt("quantidade"));
                        cartItem.setNomeProduto(resultSet.getString("nomeProduto"));

                        // Defina outros atributos conforme necessário

                        cartItems.add(cartItem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente
        }

        return cartItems;
    }
}
