package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.DTO.CartDTO;

public class InsereCartDAO {

	Connection con;
	PreparedStatement pstm; //preparando a conexão

	public void InsereNoCart(CartDTO objCartDTO) throws ClassNotFoundException, SQLException {
		String sql =  "INSERT INTO cart (idCliente, idProduto, quantidade, valor, nomeProduto) SELECT (?), idProduto, (?), valor, nomeProduto FROM produtos WHERE idProduto = (?)";
		con = new ConectionDAO().conexaoBD();

		try {

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, objCartDTO.getIdCliente());
			pstm.setInt(2, objCartDTO.getQuantidade());
			pstm.setInt(3, objCartDTO.getIdProduto());//classe so acessada atraves do obj // campos
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {

		}
	}

}