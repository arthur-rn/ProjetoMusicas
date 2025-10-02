package model;

public class OrdenacaoNomeBubbleSort implements Ordenador{

	public void ordenar(ColecaoDeMusicas colecao) {
		int totalMusicas = colecao.obterTotalDeMusicas();
		
		for(int i = 0; i < totalMusicas; i ++) {
			for(int j = 0; j < totalMusicas - 1 - i; j++) {
				Musica musica1 = colecao.obterMusica(j);
				Musica musica2 = colecao.obterMusica(j + 1);
				
				if(musica1.getFaixa().compareToIgnoreCase(musica2.getFaixa()) > 0) {
					colecao.trocarPosicaoEntreMusicas(j, j + 1);
				}
			}
		}
	}
}
