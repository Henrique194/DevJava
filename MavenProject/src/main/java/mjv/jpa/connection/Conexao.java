package mjv.jpa.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	public static EntityManager criarConexao() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("MJV_AULA");
		return em.createEntityManager();
	}
}
