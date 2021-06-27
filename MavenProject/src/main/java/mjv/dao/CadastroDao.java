package mjv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.
import sistema.Cadastro;

import mjv.jdbc.connection.Conexao;

public class CadastroDao{
	private final String NOME = "public.tab_cliente";
	private final String INSERT = String.format("INSERT INTO %s (id,nome,telefone,email) VALUES (?,?,?,?);", this.NOME);
	private final String DELETE = String.format("DELETE FROM %s WHERE id=?;", this.NOME);
	private final String UPDATE = "UPDATE %s SET %s=? WHERE id=?;";
	private Connection cnn = null;
	
	public CadastroDao() {
		this.cnn = Conexao.criarConexao();
	}
	
	public void incluir(Cadastro cadastro) {
		try(PreparedStatement st = cnn.prepareStatement(this.INSERT)) { //Automatic Resource Statement (Close Connection?) -- Java Tutorials/JDBC Database Access/Processing SQL Statements with JDBC/Closing Connections --
			st.setInt(1, cadastro.getId());
			st.setString(2, cadastro.getNome());
			st.setLong(3, cadastro.getNumero());
			st.setString(4, cadastro.getDescricao());
			st.executeUpdate();
		} catch(SQLException e) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(e.getMessage());
		}
	}
	
	public void remover(Integer id) {
		try(PreparedStatement st = cnn.prepareStatement(this.DELETE)) {
			st.setString(1, id.toString());
			st.executeUpdate();
		} catch(SQLException e){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(e.getMessage());
		}
	}
	
	public void modificar(String coluna, String id, Long telefone) {
		String sql = String.format(UPDATE, this.NOME, coluna);
		try(PreparedStatement st = cnn.prepareStatement(sql)) {
			st.setLong(1, telefone);
			st.setString(2, id);
			st.executeUpdate();
		} catch(SQLException e){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(e.getMessage());
		}
	}
	

}
