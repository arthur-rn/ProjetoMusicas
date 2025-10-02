package model;

public interface ColecaoDeMusicas {
	void adicionarMusica(Musica musica);
	void excluirMusica(String nomeMusica);
	Musica obterMusica(int posicaoMusica);
	int obterTotalDeMusicas();
	void trocarPosicaoEntreMusicas(int posicaoMusica1, int posicaoMusica2);
	void alterarMusica(int posicaoMusica, Musica novaMusica);
	void ordenarMusicas(Ordenador ordenador);
}
