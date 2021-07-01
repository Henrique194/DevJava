package mjv.dao;

import javax.persistence.EntityManager;

import mjv.jpa.connection.Conexao;

import sistema.Cadastro;

public class CadastroJpaDao {
	EntityManager em = null;
	
	public CadastroJpaDao() {
		em = Conexao.criarConexao();
	}
	
	public void incluir(Cadastro cadastro) {
	}
	
	public void remover(Integer linha) {
	}
	
	public void modificar(int linha, String coluna, String string) {
	}
	
	public void getDatabase() {
	}
	
	public void getDatabase(String coluna) {
	}
	
	private String getTipoColuna() {
		return null;
	}
}
