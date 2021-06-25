package mjv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mjv.jdbc.connection.Conexao;

public class CadastroDao {
	private Connection cnn = null;
	
	public CadastroDao() {
		this.cnn = Conexao.criarConexao();
	}
	
	public void incluir(String nome, Long telefone) {
		String sql = "INSERT INTO public.segunda_tabela (nome,telefone) VALUES (?,?);";
		try {
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nome);
			st.setLong(2, telefone);
			st.execute();
		} catch(SQLException e) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(e.getMessage());
		}
	}
	
	public void modificar() {
		
	}
}
