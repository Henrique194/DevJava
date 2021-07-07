package mjv.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import mjv.entity.enums.Parentesco;

@Embeddable
public class ContatoEmergencia {
	@Column(name = "ce1_nome", length = 50, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ce1_parentesco",nullable = false)
	private Parentesco parentesco;
	
	@Column(name = "ce1_email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "ce1_telefone", length = 11, nullable = false)
	private Long telefone;
	//Abaixo Se Encontra getters e setters
	
	
	
	
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Parentesco getParentesco() {
		return parentesco;
	}
	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	
}
