package sistema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tab_cliente_jpa")
public class Cadastro extends Entidade{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
}
