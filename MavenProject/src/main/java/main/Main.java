package main;

import java.sql.SQLException;

import mjv.dao.CadastroDao;
import pedido.auxiliar.Register;
import sistema.Cadastro;

import java.sql.Types;

public class Main {
	public static void main(String[] args) throws SQLException {
		CadastroDao cadastro = new CadastroDao();
		Cadastro cliente = Register.cadastrarCliente(2, "Enrique Jorge Barateli", "henriquejb@gmail.com", 11526531904l);
		//Cadastro cliente2 = Register.cadastrarCliente(3, "Guilherme", "guilher@email.com", 11038504892l);
		//cadastro.incluir(cliente);
		cadastro.modificar(1, "nome", "Henrique");
		//cadastro.modificar("nome", "Henrique Jorge Barateli", 1);
		//cadastro.modificar("telefone", "11920481904", 1);
		//cadastro.modificar("email", "henriquejb194@gmail.com", 1);
		//cadastro.incluir(cliente2);
		//cadastro.getDatabase();
		//cadastro.remover(3);
	}
}
