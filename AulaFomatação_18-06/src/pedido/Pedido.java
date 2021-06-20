package pedido;

import java.util.Random;

import pedido.auxiliar.*;

import sistema.Cadastro;

public class Pedido extends PedidoAux{
	private Cadastro cliente;
	private Cadastro empresa;
	private String localizacao;
	private String bairro;
	private String cnpj;
	private String ie;
	private String im;
	
	public static Pedido getInstance() {
		Pedido pedido = new Pedido();
		Random random = new Random();
		String id = String.format("%d%d-%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		pedido.setId(id);
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
	
	public void cadastrarCliente(String nome, String email, Integer telefone) {
		this.cliente = cadastrar(this.cliente, nome, email, telefone);
	}
	
	public String getCliente() {
		String string = String.format("%s\n%s", Registrable.getCliente(this.cliente), Printable.lineMaker());
		return string;
	}

	public String getEmpresa() {
		String string = Printable.getCliente(this.empresa);
		String line = Printable.lineMaker();
		String[] array = string.split("-", 2);
		string = String.format("%s\n%s, %s - %s\nCNPJ: %s\nIE:   %s\nIM:   %s\n%s", array[0], array[1], this.bairro, this.localizacao, this.cnpj, this.ie, this.im, line);
		return string;
	}

	public void cadastrarEmpresa(String nome, String localizacao, String bairro, String rua, Integer numero, String cnpj, String ie, String im) {
		this.empresa = cadastrar(this.empresa, nome, rua, numero);
		this.localizacao = localizacao;
		this.bairro = bairro;
		this.cnpj = cnpj;
		this.ie = ie;
		this.im = im;
	}
	
}
