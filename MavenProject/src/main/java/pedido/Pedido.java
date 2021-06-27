package pedido;

import java.util.Random;

import pedido.auxiliar.*;

import sistema.Cadastro;
import sistema.Empresa;

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
	
	public void cadastrarCliente(int id, String nome, String email, Long telefone) {
		this.cliente = Register.cadastrarCliente(id ,nome, email, telefone);
	}
	
	public void setCliente(Cadastro cliente) {
		this.cliente = cliente;
	}
	
	public Cadastro getCliente() {
		return this.cliente;
	}
	
	public String printCliente() {
		String string = String.format("%s\n%s", Print.printCadastro(this.cliente), Print.lineMaker());
		return string;
	}
	
	public void cadastrarEmpresa(String nome, String localizacao, String bairro, String rua, Long numero, Long cnpj, Long ie, Integer im) {
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