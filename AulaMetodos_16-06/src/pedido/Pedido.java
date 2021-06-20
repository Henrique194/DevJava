package pedido;
import java.util.Random;
import pedido.auxiliar.*;
import sistema.Cadastro;

public class Pedido extends PedidoAux{
	private Cadastro cliente;
	
	public static Pedido getInstance() {
		Pedido pedido = new Pedido();
		Random random = new Random();
		String id = String.format("%d%d-%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		pedido.setId(id);
		pedido.setData(1, 0, 1);
		return pedido;
	}
	
	public void setProduto(String titulo, String id, Double quantidade, Double valorVenda) {
		PedidoItem pedidoitem = Requestable.inicializarPedidoItem(titulo, id, quantidade, valorVenda);
		setPedidoItem(pedidoitem);
	}
	
	public void setLivro(String titulo, String id, Integer paginas, Double quantidade, Double valorVenda) {
		PedidoItem livro = Requestable.Livro(titulo, paginas, id, quantidade, valorVenda);
		setPedidoItem(livro);
	}
	
	public void setCd(String titulo, String id, Integer paginas, Double quantidade, Double valorVenda) {
		PedidoItem cd = Requestable.Cd(titulo, paginas, id, quantidade, valorVenda);
		setPedidoItem(cd);
	}
	
	public void cadastrarCliente(String nome, Integer telefone, String email) {
		this.cliente = Registrable.cadastrar(this.cliente, nome, telefone, email);
	}
	
	public String getCliente() {
		return Registrable.getCliente(this.cliente);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
