package pedido;

import java.util.Random;

import pedido.auxiliar.*;

import sistema.Cadastro;

public class Pedido extends PedidoAux{
	private Cadastro cliente;
	private Empresa empresa;
	
	public static Pedido getInstance() {
		Pedido pedido = new Pedido();
		Random random = new Random();
		String id = String.format("%d%d-%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		pedido.setId(id);
		return pedido;
	}
	
	public void setProduto(String titulo, String id, Double quantidade, Double valorVenda) {
		PedidoItem pedidoitem = Request.inicializarPedidoItem(titulo, id, quantidade, valorVenda);
		setPedidoItem(pedidoitem);
	}
	
	
	public void setLivro(String titulo, String id, Integer paginas, Double quantidade, Double valorVenda) {
		PedidoItem livro = Request.Livro(titulo, paginas, id, quantidade, valorVenda);
		setPedidoItem(livro);
	}
	
	
	public void setCd(String titulo, String id, Integer paginas, Double quantidade, Double valorVenda) {
		PedidoItem cd = Request.Cd(titulo, paginas, id, quantidade, valorVenda);
		setPedidoItem(cd);
	}
	
	public void cadastrarCliente(String nome, String email, Integer telefone) {
		this.cliente = Register.cadastrarCliente(nome, email, telefone);
	}
	
	
	public String getCliente() {
		String string = String.format("%s\n%s", Print.printCadastro(this.cliente, "cliente"), Print.lineMaker());
		return string;
	}
	public Cadastro getCliente2() {
		return this.cliente;
	}
	
	public void cadastrarEmpresa(String nome, String localizacao, String bairro, String rua, Integer numero, Long cnpj, Long ie, Integer im) {
		this.empresa = Register.cadastrarEmpresa(nome, localizacao, bairro, rua, numero, cnpj, ie, im);
	}
	
	public String getEmpresa() {
		if(this.empresa != null) {
			return Print.printEmpresa(this.empresa);
		}
		else {
			String string = "EMPRESA NÃO CADASTRADA!";
			return string;
		}
	}
}