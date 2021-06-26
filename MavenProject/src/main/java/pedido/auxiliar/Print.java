package pedido.auxiliar;

import java.util.List;

import pedido.Empresa;
import sistema.Cadastro;

public abstract class Print{	
	
	public static String printCadastro(Cadastro cliente, String tipo) {
		String client = null;
		if(tipo.compareToIgnoreCase("cliente") == 0) {
			client = String.format("Cliente: %s - ID: %s - Telefone: %d - Email: %s", cliente.getNome(), cliente.getId(), cliente.getTelefone(), cliente.getEmail());
			return client;
		}
		else if(tipo.compareToIgnoreCase("empresa") == 0) {
			client = String.format("Empresa: %s-Rua: %s, %d", cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
			return client;
		}
		else {
			client = "TIPO DE CADASTRO ESPECIFICADO INVÁLIDO!";
			return client;
		}
	}
	
	public static String printEmpresa(Empresa empresa) {
		String string = Print.printCadastro(empresa.getCadastro(), "empresa");
		String line = Print.lineMaker();
		String[] array = string.split("-", 2);
		string = String.format("%s\n%s, %s - %s\nCNPJ: %s\nIE:   %s\nIM:   %s\n%s", array[0], array[1], empresa.getBairro(), empresa.getLocalizacao(), empresa.getCnpj(), empresa.getIe(), empresa.getIm(), line);
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