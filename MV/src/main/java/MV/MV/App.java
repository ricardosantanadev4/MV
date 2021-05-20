package MV.MV;

import java.util.List;
import java.util.Scanner;
import dao.CafeGeralDAO;
import dao.CafeGeralDAOImp;
import entidade.Opcoes;
import entidade.ParticipanteseOpcoes;

public class App {
	public static void main(String[] args) {
		CafeGeralDAO geralDAO = new CafeGeralDAOImp();
		geralDAO.top();
		Scanner entradaUser = new Scanner(System.in);
		System.out.println("Digite seu cpf");
		String cpf = entradaUser.nextLine();
		ParticipanteseOpcoes pop = new ParticipanteseOpcoes();
		List<ParticipanteseOpcoes> listaParticipantes = geralDAO.buscarTodos(pop);
		int i = 0;
		for (ParticipanteseOpcoes pt : listaParticipantes) {
			if (cpf.equalsIgnoreCase(pt.getCpf())) {
				i = 1;
				System.out.println("cpf " + cpf + " já cadastrado! ");
			}
		}
		if (i == 0) {
			System.out.println("Escolha uma das opções: ");
			System.out
					.println("1-Ver lista de participantes com suas opções:\n2-Incluir um novo participante na lista:");
			Scanner opcEsc = new Scanner(System.in);
			int opcaoEscolhida = opcEsc.nextInt();
			if (opcaoEscolhida == 1) {
				for (ParticipanteseOpcoes par : listaParticipantes) {
					System.out.println(
							par.getNome() + " - " + par.getCpf() + " - " + par.getOpcao1() + " - " + par.getOpcao2());
				}
			} else if (opcaoEscolhida == 2) {
				System.out.println("Digite seu nome completo: ");
				String nome = entradaUser.nextLine();
				System.out.println("Você pode escolher até duas opções de café da manhã!");
				System.out.println();
				Opcoes opcoes = new Opcoes();
				List<Opcoes> listaOpcoes = geralDAO.buscarTodos(opcoes);
				for (Opcoes opcao : listaOpcoes) {
					if (opcao.getStatus().equalsIgnoreCase("DISPONÍVEL"))
						System.out.println(opcao.getNome());
				}
				Scanner opcao1Cafe = new Scanner(System.in);
				System.out.println("Copie e cole a opção escolhida!");
				String opcao1 = opcao1Cafe.nextLine();
				ParticipanteseOpcoes po = new ParticipanteseOpcoes();
				po.setNome(nome);
				po.setCpf(cpf);
				po.setOpcao1(opcao1);
				Opcoes op = new Opcoes();
				List<Opcoes> lista = geralDAO.buscarTodos(op);
				for (Opcoes o : lista) {
					if (o.getNome().equalsIgnoreCase(opcao1)) {
						o.setStatus("INDISPONÍVEL");
						geralDAO.atualizar(o);
					}
				}
				System.out.println("Deseja trazer uma segunda opção de café da manhã?");
				System.out.println("Digite n para não outra tecla para sim");
				Scanner opcaoTexto = new Scanner(System.in);
				String escolha = opcaoTexto.nextLine();
				if (escolha.equalsIgnoreCase("N")) {
					po.setOpcao2(null);
					geralDAO.inserir(po);
				} else {
					System.out.println("Copie e cole a opcao2: ");
					Scanner opcao2Cafe = new Scanner(System.in);
					String opcao2 = opcao2Cafe.nextLine();
					if (opcao1.equalsIgnoreCase(opcao2)) {
						System.out.println("Você não pode repetir a mesma opção de café!");
						for (Opcoes opcoes2 : listaOpcoes) {
							if (opcoes2.getNome().equalsIgnoreCase(opcao1)) {
								opcoes2.setStatus("DISPONÍVEL");
								geralDAO.atualizar(opcoes2);
								System.out.println("Cadastro não efetuado!");
							}
						}
					} else {
						po.setOpcao2(opcao2);
						geralDAO.inserir(po);
						for (Opcoes statusOpcao2 : listaOpcoes) {
							if (statusOpcao2.getNome().equalsIgnoreCase(opcao2)) {
								statusOpcao2.setStatus("INDISPONÍVEL");
								geralDAO.atualizar(statusOpcao2);
							}
						}
					}
				}
			}
		}
	}
}
