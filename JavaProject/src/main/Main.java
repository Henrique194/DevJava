package main;

//import java.util.regex.*;

import pedido.Pedido;
import java.sql.JDBCType;



public class Main {
	
	public static enum Colunas {
		id, NOME, TELEFONE, EMAIL
	}
	
	public static void main(String[] args) {
		Pedido pedido = Pedido.getInstance();
		
		/*pedido.cadastrarEmpresa("Extra", "S�o Paulo - SP", "Centro", "Samuel Klein", 83, 33041260065290l, 636169915112l, 23126457);
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
		String string = "id";
		System.out.println(string.equals(Colunas.id.toString()));
		String string = "123456789";
		string = string.replaceAll("\\d{3}\\d{3}\\d{3}", "$1.$2.$3");
		if("\\w{4}" == string) {
			System.out.println(string);
		}
		else {
			System.out.println(string);
		}*/
		
		JDBCType type = JDBCType.INTEGER;
		int i = -7;
		//for(JDBCType typ : array) {
			//System.out.println(typ.);
		//}
		System.out.println(JDBCType.valueOf(i).getName());
	}
}
