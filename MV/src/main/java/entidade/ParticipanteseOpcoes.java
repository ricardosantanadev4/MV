package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTICIPANTES_E_OPCOES")
public class ParticipanteseOpcoes {
	@Id
	@Column(name = "CPF", nullable = false, length = 11)
	private String cpf;

	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;

	@Column(name = "OPCAO1", nullable = false, length = 100)
	private String opcao1;

	@Column(name = "OPCAO2", nullable = true, length = 100)
	private String opcao2;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}
}
