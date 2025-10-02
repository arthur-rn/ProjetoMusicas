package model;

public class ListaDeMusicas implements ColecaoDeMusicas{
	private No inicio;
	private int tamanho;
	
	public ListaDeMusicas() {
		inicio = null;
		tamanho = 0;
	}
	
	public No getInicio() {
		return inicio;
	}
	
	public void setInicio(No inicio) {
		this.inicio = inicio;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	
	
	public void adicionarMusica(Musica musica) {	
		No novoNo = new No(musica); //Cria um novo nó 
		
		if(inicio == null) {
			inicio = novoNo;
		}
		
		else {
			No noAtual = inicio; //Começa a verificação a partir do primeiro nó
			
			//Vai passando de nó em nó até encontrar o último
			while(noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}
			
			noAtual.proximo = novoNo; //Posiciona o novo nó após a finalização do while
		}
		
		tamanho++; //Aumenta o tamanho da lista
	}

	public void excluirMusica(String nomeMusica) {
		No noAtual = inicio;
		
		//Caso o primeiro elemento da lista esteja vazio significa que a lista está vazia e não tem o que remover
		if(inicio == null) {
			System.out.println("A lista está vazia");
			return;
		}
		
		//Verifica se o primeiro nó da lista é o que deseja que seja excluído, caso não seja vamos para o while verificar os próximos
        if (inicio.musica.getFaixa().equalsIgnoreCase(nomeMusica)) {
            inicio = inicio.proximo; //Transforma o segundo nó no primeiro da lista
            tamanho--; //Diminui o tamanho da lista em 1
            return;
        }
		
        //While roda enquanto o ponteiro apontar para um próximo nó e enquanto o nome da faixa no nó não for igual a que o usuário deseja apagar
		while(noAtual.proximo != null && !noAtual.proximo.musica.getFaixa().equalsIgnoreCase(nomeMusica)) {
			noAtual = noAtual.proximo; //Avança para o próximo nó
		}
		
		if(noAtual.proximo != null) {
			noAtual.proximo = noAtual.proximo.proximo; //Faz o ponteiro de noAtual apontar para o que vem depois do nó que será excluído 
			tamanho--; //Diminui o tamanho da lista em 1
			return;
		}
		
		else{
			System.out.println("A música \"" + nomeMusica + "\" não foi encontrada");
		}
		
	}

	public Musica obterMusica(int posicaoMusica) {	
		No noAtual = inicio;
		
		if(posicaoMusica < 0 || posicaoMusica >= tamanho) {
			System.out.println("Posição Inválida!");
			return null;
		}

		//O for irá passando do primeiro nó até chegar no que está na posição especificada
		for(int i = 0; i < posicaoMusica; i++) {
			noAtual = noAtual.proximo;
		}
		
		return noAtual.musica;
	}

	public int obterTotalDeMusicas() {
		return tamanho; //A variável tamanho já representará o total de músicas na lista
	}

	public void trocarPosicaoEntreMusicas(int posicaoMusica1, int posicaoMusica2) {
		if(posicaoMusica1 < 0 || posicaoMusica1 >= tamanho || (posicaoMusica2 < 0 || posicaoMusica2 >= tamanho)) {
			System.out.println("Uma ou mais posições inválidas!");
			return;
		}
		
		Musica musica1 = obterMusica(posicaoMusica1);
		Musica musica2 = obterMusica(posicaoMusica2);
		
		alterarMusica(posicaoMusica1, musica2);
		alterarMusica(posicaoMusica2, musica1);
	}

	public void alterarMusica(int posicaoMusica, Musica novaMusica) {
		No noAtual = inicio;
		
		if(posicaoMusica < 0 || posicaoMusica >= tamanho) {
			System.out.println("Posição Inválida!");
			return;
		}
		
		for(int i = 0; i < posicaoMusica; i++) {
			noAtual = noAtual.proximo;
		}
		
		noAtual.musica = novaMusica;
	}

	public void ordenarMusicas(Ordenador ordenador) {
	    ordenador.ordenar(this); //Usa o this como parâmetro para referenciar a própria lista de músicas
    }
}
