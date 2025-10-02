package model;

public class Musica {
	private String artista;
	private String faixa;
	private double danceability;
	private double energia;
	private double duracaoMin;
	private long visualizacoes;
	private long curtidas;
	
	public Musica(String artista, String faixa, double danceability, double energia, double duracaoMin, long visualizacoes, long curtidas) {
		this.artista = artista;
		this.faixa = faixa;
		this.danceability = danceability;
		this.energia = energia;
		this.duracaoMin = duracaoMin;
		this.visualizacoes = visualizacoes;
		this.curtidas = curtidas;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getFaixa() {
		return faixa;
	}
	
	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}
	
	public double getDanceability() {
		return danceability;
	}
	
	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}
	
	public double getEnergia() {
		return energia;
	}
	
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	
	public double getDuracaoMin() {
		return duracaoMin;
	}
	
	public void setDuracaoMin(double duracaoMin) {
		this.duracaoMin = duracaoMin;
	}
	
	public long getVisualizacoes() {
		return visualizacoes;
	}
	
	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}
	
	public long getCurtidas() {
		return curtidas;
	}
	
	public void setCurtidas(long curtidas) {
		this.curtidas = curtidas;
	}
	
	public String toString() {
		return  "Artista: " + artista +
				"\nFaixa: " + faixa +
				"\nDancabilidade: " + danceability +
				"\nEnergia: " + energia +
				"\nDuração (Minutos): " + duracaoMin +
				"\nVisualizações: " + visualizacoes +
				"\nCurtidas: " + curtidas;
	}
}
