package mjv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sistema.Cadastro;

import mjv.jdbc.connection.Conexao;
import pedido.auxiliar.Check;

public class CadastroDao{
	private final String NOME = "public.tab_cliente_jdbc";
	private final String INSERT = String.format("INSERT INTO %s (id,nome,telefone,email) VALUES (?,?,?,?);", this.NOME);
	private final String DELETE = String.format("DELETE FROM %s WHERE id=?;", this.NOME);
	private final String UPDATE = "UPDATE %s SET %s=? WHERE id=?;";
	private final String SELECT = String.format("SELECT * FROM %s", this.NOME);
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
			st.setInt(1, id);
			st.executeUpdate();
		} catch(SQLException e){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(e.getMessage());
		}
	}
	
	public void modificar(String coluna, String string, int id) {
		String sql = String.format(UPDATE, this.NOME, coluna);
		try(PreparedStatement ps = cnn.prepareStatement(sql)) {
			int tipo = Check.checkColunas(coluna);
			switch(tipo) {
			case 4:
				ps.setInt(1, Integer.parseInt(string));
				break;
			case 2:
				ps.setLong(1, Long.parseLong(string));
				break;
			default:
				ps.setString(1, string);
				break;
			}
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch(SQLException e){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(e.getMessage());
		}
	}
	
	public void getDatabase() {
		try(PreparedStatement ps = this.cnn.prepareStatement(SELECT)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				long telefone = rs.getLong(3);
				String email = rs.getString(4);
				System.out.println("ID: " + id +
								   " NOME: " + nome +
								   " TELEFONE: " + telefone +
								   " EMAIL: " + email);
			}
			
		} catch(SQLException ex) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(ex.getMessage());
		}
	}
	
	public void getDatabase(String coluna) {
		String sql = SELECT.replaceAll("\\*", coluna);
		try(PreparedStatement ps = this.cnn.prepareStatement(sql)){
			String colunaUpperCase = coluna.toUpperCase();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String valor = rs.getString(coluna);
				System.out.println(colunaUpperCase + ": " + valor);
			}
			
		} catch(SQLException ex) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(ex.getMessage());
		}
	}
	
	
	/*public void print(int num) {
		try(PreparedStatement ps = this.cnn.prepareStatement(SELECT)){
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnType(num));
		} catch(SQLException ex) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(ex.getMessage());
		}
	}*/	
}
