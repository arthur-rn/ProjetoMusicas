package model;

import java.io.*;

public class ManipulaDataset {
	String arquivo = "C:\\Users\\arthu\\Documents\\Técnicas de Programação\\ProjetoMusicas\\colecao_musicas.csv";
	
	public void lerDoArquivoCsv(ColecaoDeMusicas colecao) {
		try(BufferedReader leitor = new BufferedReader(new FileReader(arquivo))){
			String linha;
			boolean cabecalho = true;
			
			while((linha = leitor.readLine()) != null) {
				if(cabecalho == true) {
					cabecalho = false;
					continue;
				}
				
				//Pega os atributos do csv e os separa em atributos removendo aspas e espaços para serem armazenados no vetor campos com seus respectivos tipos
				String[] campos = linha.split(">");
			
				String artista = campos[0].replace("\"", "").trim();
				String faixa = campos[1].replace("\"", "").trim();
				double danceability = Double.parseDouble(campos[2].replace("\"", "").trim());
				double energia = Double.parseDouble(campos[3].replace("\"", "").trim());
				double duracaoMin = Double.parseDouble(campos[4].replace("\"", "").trim());
				long visualizacoes = Long.parseLong(campos[5].replace("\"", "").trim());
				long curtidas = Long.parseLong(campos[6].replace("\"", "").trim());
					
				Musica musica = new Musica(artista, faixa, danceability, energia, duracaoMin, visualizacoes, curtidas);
					
				colecao.adicionarMusica(musica);			
			}
		}
		
		catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo!");
		}
	}
	
	public void escreverNoArquivoCsv(ColecaoDeMusicas colecao) {
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))){
			escritor.write("Artist>Track>Danceability>Energy>Duration_min>Views>Likes"); //Escreve o cabeçalho
			escritor.newLine(); //Pula para a próxima linha
			
			for(int i = 0; i < colecao.obterTotalDeMusicas(); i++) {
				Musica musica = colecao.obterMusica(i);
				
				String linha = String.join(">", 
						"\"" + musica.getArtista() + "\"",
						"\"" + musica.getFaixa() + "\"",
						String.valueOf(musica.getDanceability()), 
						String.valueOf(musica.getEnergia()),
						String.valueOf(musica.getDuracaoMin()),
						String.valueOf(musica.getVisualizacoes()),
						String.valueOf(musica.getCurtidas()));
				
				escritor.write(linha); //Escreve a varável linha definida acima no csv
				escritor.newLine();
			}
		}
		
		catch(IOException e) {
			System.out.println("Não foi possível escrever no arquivo!");
		}
	}
}
