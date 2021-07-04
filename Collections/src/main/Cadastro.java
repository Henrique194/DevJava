package main;

public class Cadastro{
	private String  nome;
	private String  descriçao;
	private Long numero;
	private Integer quantidade;
	
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
		this.descriçao = descricao;
	}
	
	public String getDescricao() {
		return this.descriçao;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	public void setCliente( String nome, String email, Long telefone) {
		this.setNome(nome);
		this.setNumero(telefone);
		this.setDescricao(email);
	}
	
	@Override
	public String toString() {
		if(this.nome == null) {
			return "SEM NOME";
		} else {
			return String.format("%s", getNome());
		}
	}
}