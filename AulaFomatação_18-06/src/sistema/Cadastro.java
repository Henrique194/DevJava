package sistema;

public class Cadastro {
	private String  nome;
	private Integer telefone;
	private String  email;
	private String  id;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Integer getTelefone() {
		return this.telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
}
