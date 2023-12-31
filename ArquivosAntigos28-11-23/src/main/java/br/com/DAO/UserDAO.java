package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.DTO.UserDTO;

public class UserDAO {
	
	Connection con;
	PreparedStatement pstm; //preparando a conexão
	
	public void CadastrarUser(UserDTO objUserDTO) throws ClassNotFoundException, SQLException {
		String sql = "insert into users (nome_user, email_user) values (?, ?)"; //mais pontos de interrogação mais campos
		con = (Connection) new ConectionDAO().conexaoBD();
		
		try {
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, objUserDTO.getNome_user());
			pstm.setString(2, objUserDTO.getEmail_user());//classe so acessada atraves do obj // campos
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			
		}
	}
	
}
