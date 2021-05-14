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
		Opcoes opcoes = new Opcoes();
		List<Opcoes> listaOpcoes = geralDAO.buscarTodos(opcoes);
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
			System.out.println("Digite seu nome completo: ");
			String nome = entradaUser.nextLine();
			System.out.println("Você pode escolher até duas opções de café da manhã!");
			System.out.println();
			for (Opcoes opcao : listaOpcoes) {
				if (opcao.getStatus().equalsIgnoreCase("DISPONÍVEL"))
					System.out.println(opcao.getNome());
			}
			Scanner opcaoCafe = new Scanner(System.in);
			System.out.println("Copie e cole a opção escolhida!");
			String opcao1 = opcaoCafe.nextLine();
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
			System.out.println("Digite s para sim ou n para não");
			Scanner opcaoTexto = new Scanner(System.in);
			String opcao2 = opcaoTexto.nextLine();

			if (opcao2.equalsIgnoreCase("N")) {
				po.setOpcao2(null);
			} else {
				Opcoes opp2 = new Opcoes();
				List<Opcoes> listaOpcoes2 = geralDAO.buscarTodos(opp2);
				System.out.println("Opções: ");
				for (Opcoes opc2 : listaOpcoes2) {
					if (opc2.getStatus().equalsIgnoreCase("DISPONÍVEL"))
						System.out.println(opc2.getNome());
				}
				System.out.println("Copie e cole a opcao2: ");
				String inserirOpcao2 = opcaoCafe.nextLine();
				po.setOpcao2(inserirOpcao2);
				geralDAO.inserir(po);
				Opcoes op2 = new Opcoes();
				List<Opcoes> listaOp2 = geralDAO.buscarTodos(op2);
				for (Opcoes o2 : listaOp2) {
					if (o2.getNome().equalsIgnoreCase(inserirOpcao2)) {
						o2.setStatus("INDISPONÍVEL");
						geralDAO.atualizar(o2);
					}
				}
			}

		}
	}
}
