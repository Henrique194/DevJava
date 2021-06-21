package pedido.auxiliar;

import java.util.Random;

import sistema.Cadastro;

public class Register {
	public static Cadastro cadastrar(Cadastro cliente, String nome, String email, Integer telefone) {
		Cadastro cadastro = new Cadastro();
		Random random = new Random();
		String id = String.format("%d%d%d%d.%d%d%d.%d%d%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		cadastro.setNome(nome);
		cadastro.setId(id);
		cadastro.setTelefone(telefone);
		cadastro.setEmail(email);
		return cadastro;
	}
	
	public static String getCliente(Cadastro cliente) {
		String client = String.format("Cliente: %s - ID: %s - Telefone: %d - Email: %s", cliente.getNome(), cliente.getId(), cliente.getTelefone(), cliente.getEmail());
		return client;
	}
}
