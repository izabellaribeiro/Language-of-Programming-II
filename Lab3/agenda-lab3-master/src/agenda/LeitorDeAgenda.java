package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lógica para ler de arquivos csv os dados necessários e povoar uma agenda. 
 * 
 * @author nazarenoandrade
 *
 */
public class LeitorDeAgenda {

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;


	/**
	 * Lê contatos de um arquivo CSV e os coloca em uma agenda.
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda A agenda a manipular.
	 * @return O número de contatos adicionados à agenda.
	 * @throws IOException Caso não tenhamos permissão de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo não exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabeçalho
					continue;
				}
				Contato[] campos = agenda.getContatos();
				processaLinhaCsvContatos(campos, agenda);
			}
		}
		
		return carregados;
	}

	
	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial. 
	 *  @param campos As informações lidas do csv.
	 * @param agenda A agenda a manipular.
	 */
	private void processaLinhaCsvContatos(Contato[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(String.valueOf(campos[COLUNA_POSICAO]));
		Contato nome = campos[COLUNA_NOME];
		agenda.cadastraContato(posicao, nome);
	}

}
