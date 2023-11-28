package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDAO {

    public Connection conexaoBD() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            // Não é mais necessário carregar o driver explicitamente
             Class.forName("com.mysql.jdbc.Driver");

            // Defina as informações de conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3306/Sorveteria";
            String usuario = "root";
            String senha = "La@10laa2004";

            // Use DriverManager.getConnection(url, user, password) para obter a conexão
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            // Lidere com exceções de SQL de maneira apropriada
            e.printStackTrace();
            throw e;
        }
        return con;
    }
}
