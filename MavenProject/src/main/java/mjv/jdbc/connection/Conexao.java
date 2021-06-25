package mjv.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexao {
	private static final String url = "jdbc:postgresql://localhost/mjv_db";
	private static final String user = "postgres";
	private static final String password = "postgres194";
	private static Connection cnn = null;
	
	public static Connection criarConexao() {
		try {
			cnn = DriverManager.getConnection(url, user, password);
			System.out.println("Sucesso!");
		} catch(SQLException e) {
			System.out.println("Falha!");
			System.out.println(e.getMessage());
		}
		return cnn;
	}
}
