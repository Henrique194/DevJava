package main;

import pedido.Pedido;

public class Main {
	public static void main(String[] args) {
		Pedido pedido = Pedido.getInstance();
		
		pedido.cadastrarEmpresa("Extra", "São Paulo - SP", "Centro", "Samuel Klein", 83, 33041260065290l, 636169915112l, 23126457);
		pedido.cadastrarCliente("Henrique Jorge Barateli", "henriquejb194@email.com", 56312876);
		pedido.setData(26, 6, 2020, 22, 10, 1); // dia - mes - ano - hora - minuto - segundo
		pedido.setProduto("Macarrão", "ADRIA", 3.0, 3.39);
		pedido.setProduto("Feijão", "Camil", 2.0, 7.99);
		pedido.setLivro("Matemática", "FTD", 328, 2.0, 261.0);
		pedido.setCd("Ride The Lightning", "Metallica", 8,  1.0, 45.0);
		
		System.out.println(pedido.getEmpresa());
		System.out.print(pedido.getData() + " - ");
		System.out.println(pedido.getCliente());
		pedido.printItens();
		System.out.println("Valor Total: R$ " + pedido.getValorTotal());
	}
}
