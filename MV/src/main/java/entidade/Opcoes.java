package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPCOES")
public class Opcoes {
	@Id
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;

	@Column(name = "STATUS", nullable = false, length = 100)
	private String status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
