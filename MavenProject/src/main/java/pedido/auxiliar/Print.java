package pedido.auxiliar;

import java.util.List;

import sistema.Cadastro;
import sistema.Empresa;

public abstract class Print{	
	
	public static String printCadastro(Cadastro cliente) {
			String client = String.format("Cliente: %s - ID: %s - Telefone: %d - Email: %s", cliente.getNome(), cliente.getId(), cliente.getNumero(), cliente.getDescricao());
			return client;
	}
	
	public static String printEmpresa(Empresa empresa) {
		String line = Print.lineMaker();
		String string = String.format("Empresa: %s\nRua: %s, %d, %s - %s\nCNPJ: %s\nIE:   %s\nIM:   %s\n%s", empresa.getNome(), empresa.getDescricao(), empresa.getNumero(), empresa.getBairro(), empresa.getLocalizacao(), empresa.getCnpj(), empresa.getIe(), empresa.getIm(), line);
		return string;
	}
	
	public static String lineMaker() {
		String string = String.format("%s", "-".repeat(159));
		return string;
	}
	private static String printSubTotal(PedidoItem pedidoitem) {
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