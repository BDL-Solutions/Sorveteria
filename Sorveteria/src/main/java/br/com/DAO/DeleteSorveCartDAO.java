package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.DTO.CartDTO;

public class DeleteSorveCartDAO {
	
	Connection con;
	PreparedStatement pstm; //preparando a conexão

	public void DeleteNoCart(CartDTO objCartDTO) throws ClassNotFoundException, SQLException {
			
		String sql =  "DELETE FROM cart WHERE idCliente = (?) AND nomeProduto = (?)";
		con = new ConectionDAO().conexaoBD();

		try {

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, objCartDTO.getIdCliente());
			pstm.setString(2, objCartDTO.getNomeProduto());//classe so acessada atraves do obj // campos
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {

		}
	}

}
