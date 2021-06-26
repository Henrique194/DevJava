package sistema;

public class Produto {
	private String codigoBarras;
	private String titulo;
	private Double valorVenda;
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getCodigoBarras() {
		return this.codigoBarras;
	}
	
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
	
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}	
	public Double getValorVenda() {
		return this.valorVenda;
	}
	
}
