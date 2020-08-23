package petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conectado");
			return DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}

}
