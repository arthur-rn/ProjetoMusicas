package model;

public class VetorDeMusicas implements ColecaoDeMusicas{
	private Musica[] musicas;
	private int tamanho;
	
	public VetorDeMusicas() {
		musicas = new Musica[100];
		tamanho = 0;
	}
	
	public void adicionarMusica(Musica musica) {
		if(tamanho < musicas.length) {
			musicas[tamanho] = musica;
			tamanho++;
		}
		
		else {
			System.out.println("Não foi possível adicionar. O vetor já está cheio!");
		}
	}
	
	public void excluirMusica(String nomeMusica) {
		for(int i = 0; i < musicas.length; i++) {
			if (musicas[tamanho].getFaixa().equalsIgnoreCase(nomeMusica)) {
				musicas[tamanho] = null;
				tamanho--;
				return;
			}
		}
		
		System.out.println("Música não encontrada!");
	}
	
	public Musica obterMusica(int posicaoMusica) {
		if(posicaoMusica < musicas.length && posicaoMusica >= 0) {
			return musicas[posicaoMusica];
		}
		
		return null;
	}
	
	public int obterTotalDeMusicas() {
		return tamanho;
	}
	
	public void trocarPosicaoEntreMusicas(int posicaoMusica1, int posicaoMusica2) {
		if(posicaoMusica1 < musicas.length && posicaoMusica1 >= 0 && posicaoMusica2 < musicas.length && posicaoMusica2 >= 0) {
			Musica temporaria = musicas[posicaoMusica1];
			musicas[posicaoMusica1] = musicas[posicaoMusica2];
			musicas[posicaoMusica2] = temporaria;
		}
		
		else {
			System.out.println("Erro de troca!");
		}
	}
	
	public void alterarMusica(int posicaoMusica, Musica novaMusica) {
		if(posicaoMusica < musicas.length && posicaoMusica >= 0) {
			musicas[posicaoMusica] = novaMusica;
		}
		
		else {
			System.out.println("Erro de alteração!");
		}
	}

	public void ordenarMusicas(Ordenador ordenador) {
		ordenador.ordenar(this); //Usa o this como parâmetro para referenciar o próprio vetor de músicas
	}
}
