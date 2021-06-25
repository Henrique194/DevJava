import mjv.dao.CadastroDao;

public class Main {
	public static void main(String[] args) {
		CadastroDao cadastro = new CadastroDao();
		cadastro.incluir("Lucas Nobren", 11947374984l);
	}
}
