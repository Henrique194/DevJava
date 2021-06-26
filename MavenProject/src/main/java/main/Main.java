package main;

import mjv.dao.CadastroDao;
import pedido.Pedido;

public class Main {
	public static void main(String[] args) {
		Pedido pedido = Pedido.getInstance();
		pedido.cadastrarCliente("Henrique Jorge Barateli", "henriquejb194@email.com", 56312876);
		//System.out.println(pedido.getCliente());
		CadastroDao cadastro = new CadastroDao();
		cadastro.incluir(pedido.getCliente2());
		//cadastro.modificar("telefone", "1", 123l);
		//cadastro.remover(6);
	}
}
