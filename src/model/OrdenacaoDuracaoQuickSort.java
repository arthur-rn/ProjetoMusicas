package model;

public class OrdenacaoDuracaoQuickSort implements Ordenador{
	
	//Função que será chamada para realizar a ordenação
	public void ordenar(ColecaoDeMusicas colecao) {
		quickSort(colecao, 0, colecao.obterTotalDeMusicas() - 1);
	}
	
	//Método recursivo
	private void quickSort(ColecaoDeMusicas colecao, int inicio, int fim) {
		if(inicio < fim) {
			int indicePivo = particionar(colecao, inicio, fim);
			quickSort(colecao, inicio, indicePivo - 1);
			quickSort(colecao, indicePivo + 1, fim);
		}
	}
	
	//Método para encontrar o pivô que irá organizar a lista
	private int particionar(ColecaoDeMusicas colecao, int inicio, int fim) {
		Musica pivo = colecao.obterMusica(fim); //Pega o último elemento da lista como o pivô
		double valorPivo = pivo.getDuracaoMin(); //Como a organização será feita pela duração da música associamos o valor do pivo como a duração do pivô 
		int i = inicio - 1; //Índice para marcar a última música jogada para esquerda do pivô começa em inicio -1 pois nenhum foi trocado ainda
		
		//For para percorrer todos os elementos localizados antes do pivô
		for(int j = inicio; j < fim; j++) {
			Musica atual = colecao.obterMusica(j); //Armazena a música da posição atual na variável atual
			
			/*Caso o valor seja menor ou igual ao pivô jogamos ele para a esquerda do pivô, 
			fazendo com que os valores maiores fiquem a direita e os valores menores a esquerda*/
			if(atual.getDuracaoMin() <= valorPivo) {
				i++;
				colecao.trocarPosicaoEntreMusicas(i, j); //O método chamado troca a posição das músicas utilizando o índice referente ao primeiro elemento da lista que será ordenado e o da atual
			}
		}
		
		colecao.trocarPosicaoEntreMusicas(i + 1, fim);
		return i + 1; 
	}
}
