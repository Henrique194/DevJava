package main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pedido.Pedido;
import pedido.Printable;

public class Main {
	public static void main(String[] args) {
		Pedido pedido = Pedido.getInstance();
		
		pedido.cadastrarEmpresa("Extra", "S�o Paulo - SP", "Centro", "Samuel Klein", 83, "33.041.260/0652-90", "636.169.915.112", "23.126.457");
		pedido.cadastrarCliente("Henrique Jorge Barateli", "henriquejb194@email.com", 56312876);
		pedido.setData(26, 6, 2020, 22, 10, 1); // dia - mes - ano - hora - minuto - segundo
		
		pedido.setProduto("Macarr�o", "ADRIA", 3.0, 3.39);
		pedido.setProduto("Feij�o", "Camil", 2.0, 7.99);
		pedido.setLivro("Matem�tica", "FTD", 328, 2.0, 261.0);
		pedido.setCd("Ride The Lightning", "Metallica", 8,  1.0, 45.0);
		
		System.out.println(pedido.getEmpresa());
		System.out.print(pedido.getData() + " - ");
		System.out.println(pedido.getCliente());
		pedido.printItens();
		System.out.println("Valor Total: R$ " + pedido.getValorTotal());
	}
}
