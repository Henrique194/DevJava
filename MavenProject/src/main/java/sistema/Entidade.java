package sistema;

public class Entidade {
	private String  nome;
	private String  descri�ao;
	private Long numero;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getNumero() {
		return this.numero;
	}
	public void setDescricao(String descricao) {
		this.descri�ao = descricao;
	}
	public String getDescricao() {
		return this.descri�ao;
	}
}
