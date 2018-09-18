import java.util.ArrayList;
import java.util.Scanner;

public class ViewCadastro {
	private Scanner teclado;

	public ViewCadastro() {
		teclado = new Scanner(System.in);
	}

	public String mostraMenu() {
		System.out.println("");
		System.out.println("MENU");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("5 - Pesquisar");
		System.out.println("6 - Lista de Aprovados");
		System.out.println("7 - Lista de Reprovados");
		System.out.println("8 - Sair");
		System.out.println("Opção: ");
		return teclado.nextLine();
	}

	public Pessoa inserir(ArrayList<Pessoa> aprovados, ArrayList<Pessoa> reprovados) {
		Pessoa umaPessoa = new Pessoa();
		System.out.println("");
		System.out.println("INSERIR");
		System.out.println("Nome: ");
		umaPessoa.setNome(teclado.nextLine());

		System.out.println("Média A: ");
		umaPessoa.setMediaA(pedirNumero());

		System.out.println("Média B: ");
		umaPessoa.setMediaB(pedirNumero());
		
		umaPessoa.setMediaFinal((umaPessoa.getMediaA() + umaPessoa.getMediaB()) / 2);
		
		if(umaPessoa.getMediaFinal() >= 7) {
		
			aprovados.add(umaPessoa);
			
		} else {
			
			reprovados.add(umaPessoa);
		}

		return umaPessoa;
	}

	public void listar(ArrayList<Pessoa> alunos) {
		System.out.println("\nLISTA DE ALUNOS");
		for (int pos = 0; pos < alunos.size(); pos++) {
			System.out.println("Posição: " + pos + " : " + alunos.get(pos).toString());
		}

	}

	public void alterar(ArrayList<Pessoa> agenda) {
		listar(agenda);
		boolean continuar = true;
		int pos = 0;
		do {
			System.out.println("Digite a posição do registro para alter: ");
			try {
				pos = Integer.parseInt(teclado.nextLine());
				if (pos >= 0 & pos < agenda.size()) {
					continuar = false;
				}else {
					System.out.println("Digite um valor válido!");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);
		
		System.out.println("Nome ("+ agenda.get(pos).getNome() +"): ");
		agenda.get(pos).setNome(teclado.nextLine());
		
		System.out.println("Media A ("+ agenda.get(pos).getMediaA() +"): ");
		agenda.get(pos).setMediaA(pedirNumero());
		
		System.out.println("Media B ("+ agenda.get(pos).getMediaB() +"): ");
		agenda.get(pos).setMediaB(pedirNumero());
		
		listar(agenda);
		
	}
	
	public void excluir(ArrayList<Pessoa> agenda, ArrayList<Pessoa> aprovados, ArrayList<Pessoa> reprovados) {
		listar(agenda);
		boolean continuar = true;
		int pos = 0;
		do {
			System.out.println("Digite a posição do registro para excluir: ");
			try {
				pos = Integer.parseInt(teclado.nextLine());
				if (pos >= 0 & pos < agenda.size()) {
					continuar = false;
				}else {
					System.out.println("Digite um valor válido!");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);
							
		for (int x = 0; x < aprovados.size(); x++) {
			
			if(agenda.get(pos).hashCode() == aprovados.get(x).hashCode()) 			
				aprovados.remove(x);		
								
		}
		
		for (int x = 0; x < reprovados.size(); x++) {
			
			if(agenda.get(pos).hashCode() == reprovados.get(x).hashCode()) 
				reprovados.remove(x);			
		}
		
		agenda.remove(pos);
		System.out.println("Elemento selecionado removido!");
		
		listar(agenda);
		
	}
	
	public void pesquisar(ArrayList<Pessoa> agenda) {
		boolean controle = true;
		Pessoa umaPessoa = new Pessoa();
		System.out.println("Digite o nome pelo qual quer pesquisar: ");
		umaPessoa.setNome(teclado.nextLine());
		
		for(int x = 0; x < agenda.size(); x++) {
			
			if(agenda.get(x).getNome().equals(umaPessoa.getNome()) == true)
					{
				
						System.out.println("Nome encontrado!!!!");
						System.out.println("Nome ("+ agenda.get(x).getNome() +"): ");
						
						
						System.out.println("Média A ("+ agenda.get(x).getMediaA() +"): ");
						
						
						System.out.println("Média B ("+ agenda.get(x).getMediaB() +"): ");
						
						System.out.println("Média Final (" + agenda.get(x).getMediaFinal() + "): ");
						
						controle = false;
						
					}
		}
		
		if(controle == true) {
			
			System.out.println("Nome não encontrado!");
		}
		
	}
	
	public double pedirNumero() {	
		boolean continuar = true;
		double pos = 0;
		do {
			try {
				pos = Double.parseDouble(teclado.nextLine());
				if (pos >= 0 & pos <= 10) {
					continuar = false;
				}else {
					System.out.println("Digite um valor válido entre 0 e 10!");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);
		
		return pos;
	}

	public void mostrarAprovados(ArrayList<Pessoa> aprovados) {
		
		System.out.println("\nLISTA DE ALUNOS APROVADOS");
		for (int pos = 0; pos < aprovados.size(); pos++) {
			System.out.println("Posição: " + pos + " : " + aprovados.get(pos).toString());
		}
		
	}
	
	public void mostrarReprovados(ArrayList<Pessoa> reprovados) {
		
		System.out.println("\nLISTA DE ALUNOS REPROVADOS");
		for (int pos = 0; pos < reprovados.size(); pos++) {
			System.out.println("Posição: " + pos + " : " + reprovados.get(pos).toString());
		}
		
	}

}
