package petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	//Ensinando sobre git
	public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "root");
        System.out.println("Conectado!");
        conexao.close();
    }

}
