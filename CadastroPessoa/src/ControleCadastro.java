import java.util.ArrayList;

public class ControleCadastro {
	private ViewCadastro viewCadastro;
	private ArrayList<Pessoa> alunos = new ArrayList<Pessoa>();
	private ArrayList<Pessoa> aprovados = new ArrayList<Pessoa>();
	private ArrayList<Pessoa> reprovados = new ArrayList<Pessoa>();
	
	public ControleCadastro() {
		viewCadastro = new ViewCadastro();
		trataMenu();
	}

	private void trataMenu() {
		boolean continuar = true;
		do {
			String opc = viewCadastro.mostraMenu();

			switch (opc) {
			case "1":
				alunos.add(viewCadastro.inserir(aprovados, reprovados));
				break;
			case "2":
				viewCadastro.listar(alunos);
				break;
			case "3":
				viewCadastro.alterar(alunos);
				break;
			case "4":
				viewCadastro.excluir(alunos, aprovados, reprovados);
				break;
			case "5":
				viewCadastro.pesquisar(alunos);			
				break;
			case "6":
				viewCadastro.mostrarAprovados(aprovados);
				break;
			case "7":
				viewCadastro.mostrarReprovados(reprovados);	
				break;
			case "8":
				System.out.println("Sair do menu");
				continuar = false;
				break;
			
								
			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (continuar);
	}

}
