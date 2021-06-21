package pedido.auxiliar;

import java.util.List;

import sistema.Cadastro;

public class Print extends Register{
	public static String getCliente(Cadastro cliente) {
		String client = String.format("Empresa: %s-Rua: %s, %d", cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
		return client;
	}
	
	public static String lineMaker() {
		String string = "---------------------------------------------------------------------------------------------------------------------------------------------------------------";
		return string;
	}
	public static String printSubTotal(PedidoItem pedidoitem) {
		String string = String.format(" - Quantidade: %s - Valor Unitário: R$ %s - SubTotal: R$ %s\n", pedidoitem.getQuantidade(), pedidoitem.getProduto().getValorVenda(), pedidoitem.getValor());
		return string;
	}
	
	public static void printPedidoItem(List<PedidoItem> itens) {
		String string = null;
		for(PedidoItem item : itens) {
			if(item.getLivro() != null) {
				string = String.format("	Livro:   %s - Editora: %s - Páginas: %s %s", item.getProduto().getTitulo(), item.getId(), item.getLivro().getPaginas(), Print.printSubTotal(item));
				System.out.print(string);
			}
			
			else if(item.getCd() != null) {
				string = String.format("	CD:      %s - Artista: %s - Faixas: %s %s", item.getProduto().getTitulo(), item.getId(), item.getCd().getFaixas(), Print.printSubTotal(item));
				System.out.print(string);
			}
			
			else {
				string = String.format("	Produto: %s%s", item.getProduto().getTitulo(), Print.printSubTotal(item));
				System.out.print(string);
			}
		}
		
	}
	
}