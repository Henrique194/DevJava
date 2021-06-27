package main;

import mjv.dao.CadastroDao;
import pedido.Pedido;
import pedido.auxiliar.Register;
import sistema.Cadastro;

public class Main {
	public static void main(String[] args) {
		CadastroDao cadastro = new CadastroDao();
		Cadastro cliente = Register.cadastrarCliente(3, "Henrique Jorge Barateli", "henrique194@gmail.com", 11940389284l);
		//System.out.println(pedido.getCliente());
		
		cadastro.incluir(cliente);
		//System.out.println(pedido.getCliente().getId());
		//cadastro.modificar("telefone", pedido.getCliente2().getId(), 1l);
		//cadastro.remover(3);
	}
}
