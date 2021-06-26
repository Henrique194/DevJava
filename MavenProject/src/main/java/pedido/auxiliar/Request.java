package pedido.auxiliar;
import java.util.Random;

import sistema.CD;
import sistema.Livro;
import sistema.Produto;

public abstract class Request {
	public static PedidoItem inicializarPedidoItem(String titulo, String id, Double quantidade, Double valorVenda) {
		PedidoItem pedidoItem = new PedidoItem();
		Random random = new Random();
		String codigoBarras = String.format("%d-%d%d%d%d%d%d-%d%d%d%d%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		pedidoItem.setProduto(inicializarProduto(titulo, codigoBarras, valorVenda));
		pedidoItem.setId(id);
		pedidoItem.setQuantidade(quantidade);
		pedidoItem.setValor(quantidade * pedidoItem.getProduto().getValorVenda());
		return pedidoItem;
	}
	
	public static Produto inicializarProduto(String titulo, String codigoBarras, Double valorVenda) {
		Produto produto = new Produto();
		produto.setTitulo(titulo);
		produto.setCodigoBarras(codigoBarras);
		produto.setValorVenda(valorVenda);
		return produto;
	}
	public static PedidoItem Cd(String titulo, Integer faixas, String id, Double quantidade, Double valorVenda) {
		PedidoItem pedidoitem = inicializarPedidoItem(titulo, id, quantidade, valorVenda);
		CD cd = new CD();
		cd.setFaixas(faixas);
		pedidoitem.setCd(cd);
		return pedidoitem;
	}
	public static PedidoItem Livro(String titulo, Integer paginas, String id, Double quantidade, Double valorVenda) {
		PedidoItem pedidoitem = inicializarPedidoItem(titulo, id, quantidade, valorVenda);
		Livro livro = new Livro();
		livro.setPaginas(paginas);
		pedidoitem.setLivro(livro);
		return pedidoitem;
	}
}
