package view;

import java.util.Scanner;
import model.*;

public class ProgramaMusicas {
	public static void main(String[] args) {
		int opcao1 = 0;
		int opcao2 = 0;
		ColecaoDeMusicas colecao = null;
		Scanner leituraTeclado = new Scanner(System.in);	
		ManipulaDataset manipulador = new ManipulaDataset();
		OrdenacaoDuracaoQuickSort quickSort = new OrdenacaoDuracaoQuickSort();
		OrdenacaoNomeBubbleSort bubbleSort = new OrdenacaoNomeBubbleSort();

		while(opcao1 < 1 || opcao1 > 2) {
			System.out.println("Gostaria de trabalhar com lista ou vetor?");
			System.out.println("1 - Lista");
			System.out.println("2 - Vetor");
			System.out.print("Sua escolha: ");
			opcao1 = leituraTeclado.nextInt();
			leituraTeclado.nextLine();
			if(opcao1 == 1) {
				colecao = new ListaDeMusicas();
			}
			
			else if(opcao1 == 2){
				colecao = new VetorDeMusicas();
			}
			
			else {
				System.out.println("Escolha Inválida");
			}
		}
		
		while(opcao2 != 9) {
			System.out.println("");
			System.out.println("--------MENU--------");
			System.out.println("1 - Ler músicas do arquivo CSV"); //Funcionando
			System.out.println("2 - Adicionar música"); //Funcionando
			System.out.println("3 - Excluir música"); //Funcionando
			System.out.println("4 - Listar músicas"); //Funcionando
			System.out.println("5 - Alterar dados de uma música existente"); //Funcionando
			System.out.println("6 - Ordenar músicas por nome (Bubble Sort)"); //Funcionando
			System.out.println("7 - Ordenar músicas por duração (Quick Sort)"); //Funcionando
			System.out.println("8 - Salvar músicas em arquivo CSV"); //Funcionando
			System.out.println("9 - Sair");
			System.out.print("Sua escolha: ");
			
			opcao2 = leituraTeclado.nextInt();
			leituraTeclado.nextLine();
			
			switch(opcao2) {
				case 1:
					manipulador.lerDoArquivoCsv(colecao);
					System.out.println("Músicas lidas!");
					break;
				
				case 2:
					System.out.print("Artista: ");
					String artista = leituraTeclado.nextLine();
					System.out.print("Faixa: ");
					String faixa = leituraTeclado.nextLine();
					System.out.print("Danceability: ");
					double danceability = leituraTeclado.nextDouble();
					System.out.print("Energia: ");
					double energia = leituraTeclado.nextDouble();
					System.out.print("Duracão (minutos): ");
					double duracaoMin = leituraTeclado.nextDouble();
					System.out.print("Visualizações: ");
					long visualizacoes = leituraTeclado.nextLong();
					System.out.print("Curtidas: ");
					long curtidas = leituraTeclado.nextLong();
					
					Musica novaMusica = new Musica(artista, faixa, danceability, energia, duracaoMin, visualizacoes, curtidas);
					colecao.adicionarMusica(novaMusica);
					System.out.println("Música adicionada!");
					break;
				
				case 3:
					System.out.print("Nome da música a ser excluida: ");
					String faixaExcluida = leituraTeclado.nextLine();
					colecao.excluirMusica(faixaExcluida);
					
					System.out.println("A música \"" + faixaExcluida+ "\"foi excluída!");
					break;
					
				case 4:
					for(int i = 0; i < colecao.obterTotalDeMusicas(); i++) {
						Musica musica = colecao.obterMusica(i);
						System.out.println("");
						System.out.println(musica.toString());
					}
					
					break;
					
				case 5:
					System.out.print("Posição da música que deseja trocar: ");
					int posicaoMusica = leituraTeclado.nextInt();
					System.out.println("---Dados da nova música---");
					leituraTeclado.nextLine();
					System.out.print("Artista: ");
					artista = leituraTeclado.nextLine();
					System.out.print("Faixa: ");
					faixa = leituraTeclado.nextLine();
					System.out.print("Danceability: ");
					danceability = leituraTeclado.nextDouble();
					System.out.print("Energia: ");
					energia = leituraTeclado.nextDouble();
					System.out.print("Duracão (minutos): ");
					duracaoMin = leituraTeclado.nextDouble();
					System.out.print("Visualizações: ");
					visualizacoes = leituraTeclado.nextLong();
					System.out.print("Curtidas: ");
					curtidas = leituraTeclado.nextLong();
					novaMusica = new Musica(artista, faixa, danceability, energia, duracaoMin, visualizacoes, curtidas);
					
					colecao.alterarMusica(posicaoMusica, novaMusica);
					System.out.println("Música alterada!");
					break;
				
				case 6:
					colecao.ordenarMusicas(bubbleSort);
					System.out.println("Músicas ordenadas!");
					break;
					
				case 7:
					colecao.ordenarMusicas(quickSort);
					System.out.println("Músicas ordenadas!");
					break;
					
				case 8:
					manipulador.escreverNoArquivoCsv(colecao);
					System.out.println("Músicas adicionadas no arquivo!");
					break;
					
				case 9:
					System.out.println("Finalizando o programa...");
					break;
				
				default:
					System.out.println("Opção inválida! Tente novamente...");
			}
		}
	}
}
