package pedido.auxiliar;

import sistema.Produto;
import sistema.Livro;
import sistema.CD;

public class PedidoItem{
	private String id;
	private Double quantidade;
	private Double valorTotal;
	Produto produto = null;
	Livro livro = null;
	CD cd = null;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getQuantidade() {
		return this.quantidade;
	}
	
	public void setValor(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Double getValor() {
		return this.valorTotal;
	}	
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public CD getCd() {
		return this.cd;
	}
	
	public void setCd(CD cd) {
		this.cd = cd;
	}
	
}
