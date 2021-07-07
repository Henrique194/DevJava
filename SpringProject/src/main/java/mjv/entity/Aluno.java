package mjv.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mjv.entity.enums.NivelAluno;

@Entity
@Table(name = "tab_aluno", schema = "escola")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NivelAluno nivel;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_aluno_pessoa"))
	@MapsId
	private Pessoa pessoa;
	
	@Embedded
	ContatoEmergencia contato1;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "nome", column = @Column(name = "ce2_nome", nullable = true)),
		@AttributeOverride(name = "parentesco", column = @Column(name = "ce2_parentesco", nullable = true)),
		@AttributeOverride(name = "email", column = @Column(name = "ce2_email", nullable = true)),
		@AttributeOverride(name = "telefone", column = @Column(name = "ce2_telefone", nullable = true))
	})
	ContatoEmergencia contato2;
	
	//Abaixo Se Encontra getters e setters
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public NivelAluno getNivel() {
		return nivel;
	}

	public void setNivel(NivelAluno nivel) {
		this.nivel = nivel;
	}

	public ContatoEmergencia getContato1() {
		return contato1;
	}

	public void setContato1(ContatoEmergencia contato1) {
		this.contato1 = contato1;
	}

	public ContatoEmergencia getContato2() {
		return contato2;
	}

	public void setContato2(ContatoEmergencia contato2) {
		this.contato2 = contato2;
	}
	
	
}
