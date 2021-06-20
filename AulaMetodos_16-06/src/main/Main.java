package main;
import pedido.Pedido;

public class Main {
	public static void main(String[] args) {
		Pedido pedido = Pedido.getInstance();
		pedido.setProduto("Macarrão", "ADRIA", 3.0, 3.39);
		pedido.setProduto("Feijão", "Camil", 2.0, 7.99);
		pedido.setLivro("Matemática", "FTD", 328, 2.0, 261.0);
		pedido.setCd("Ride The Lightning", "Metallica", 8,  1.0, 45.0);
		pedido.cadastrarCliente("Henrique Jorge Barateli", 56312876, "henriquejb194@email.com");
		pedido.setData(14, 6, 2020);
		System.out.println(pedido.getCliente());
		System.out.println(pedido.getData());
		pedido.printItens();
		System.out.println("Valor Total: R$ " + pedido.getValorTotal());
		//Calendar time = Registrable.setTime(14, 6, 2020);
		//System.out.println(Registrable.getTime(time));
	}
}
