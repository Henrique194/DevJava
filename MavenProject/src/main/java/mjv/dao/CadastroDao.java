package mjv.dao;

import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import mjv.jdbc.connection.Conexao;

import sistema.Cadastro;



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
	
	public void remover(Integer linha) {
		try(PreparedStatement st = cnn.prepareStatement(this.DELETE)) {
			st.setInt(1, linha);
			st.executeUpdate();
		} catch(SQLException e){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(e.getMessage());
		}
	}
	
	public void modificar(int linha, String coluna, String string) {
		String sql = String.format(UPDATE, this.NOME, coluna);
		try(PreparedStatement ps = cnn.prepareStatement(sql)) {
			String tipoColuna = getTipoColuna(ps, coluna);
			//System.out.println(tipoColuna);
			switch(tipoColuna) {
			case "INTEGER":
				ps.setInt(1, Integer.parseInt(string));
				break;
			case "NUMERIC":
				ps.setLong(1, Long.parseLong(string));
				break;
			default:
				ps.setString(1, string);
				break;
			}
			ps.setInt(2, linha);
			ps.executeUpdate();
		} catch(SQLException ex){
			System.err.println("FALHA AO CRIAR STATEMENT");
			System.err.println(ex.getMessage());
		}
	}
	
	public void getDatabase() {
		try(PreparedStatement ps = cnn.prepareStatement(SELECT); ResultSet rs = ps.executeQuery();){
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
		try(PreparedStatement ps = this.cnn.prepareStatement(sql); ResultSet rs = ps.executeQuery();){
			String colunaUpperCase = coluna.toUpperCase();
			while(rs.next()) {
				String valor = rs.getString(coluna);
				System.out.println(colunaUpperCase + ": " + valor);
			}
			
		} catch(SQLException ex) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(ex.getMessage());
		}
	}
	
	private String getTipoColuna(PreparedStatement ps, String coluna) {
		String tipoColuna = null;
		try {
			ps = cnn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			int indexColuna = rs.findColumn(coluna);
			ResultSetMetaData rsmd = ps.getMetaData();
			int typeColuna = rsmd.getColumnType(indexColuna);
			JDBCType jdbcType = JDBCType.valueOf(typeColuna);
			tipoColuna = jdbcType.getName();
			ps.close();
			rs.close();
		} catch(SQLException ex) {
			System.err.println("FALHA AO CRIAR STATEMENT!");
			System.err.println(ex.getMessage());
		}
		return tipoColuna;
	}
}
