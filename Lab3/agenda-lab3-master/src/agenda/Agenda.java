package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 101;

	
	private Contato[] contatos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**
	 * Veriffica se há a possibilidade de cadastramento de acordo com a posição passada, sabendo que esta deve está entre 1-100 (inclusive)
	 * @param posicao Posição que é desejada para o contato ser cadastrado no Array
	 * @return Se sim, true. Se não, false.
	 */
	private boolean cadastraOuNao(int posicao){
		final int POSICAO_MINIMA_NECESSARIA = 1;
		final int POSICAO_MAXIMA_NECESSARIA = 100;
		return (posicao >= POSICAO_MINIMA_NECESSARIA && posicao <= POSICAO_MAXIMA_NECESSARIA);
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param contato objeto do tipo Contato a ser cadastrado.
	 */
	public boolean cadastraContato(int posicao, Contato contato) {
		if (cadastraOuNao(posicao)) {
			this.contatos[posicao] = contato;
			return true;
		}
		return false;
	}

	/**
	 * Exibe características do contato segundo sua posição.
	 * @param posicao posição do contato
	 * @return toString() do contato chamado segundo sua posição.
	 * */
	public String exibirContato(int posicao) {
		if (posicao >= TAMANHO_AGENDA || contatos[posicao] == null){
			return "POSICAO INVALIDA!";
		}
		return contatos[posicao].toString();
	}

	/**
	 *Lista os contatos já cadastrados em contatos.
	 * @return lista de contatos
	 */
	public String listarContatos(){
		String listagem = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				listagem += i + " - " + this.contatos[i].getNome() + " " + this.contatos[i].getSobrenome() + "\n";
			}
		}
		return listagem;
	}

	/**
	 * Retorna listagem de contatos preferidos já cadastrados.
	 * @return listagem formatada de contatos preferidos.
	 * */
	public String listarTelefonesPreferidos(){
		String listagemPreferidos = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				listagemPreferidos += this.contatos[i].getNome() + " " + this.contatos[i].getSobrenome() + " - " + this.contatos[i].getTelefonePrioritario() + "\n";
			}
		}
		return listagemPreferidos;
	}

	/**
	 * Retorna listagem de contatos WhatsApp já cadastrados.
	 * @return listagem formatada de contatos de WhatsApp.
	 * */
	public String listarContatosWhatsApp(){
		String listagemWhatsApps = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				listagemWhatsApps += this.contatos[i].getNome() + " " + this.contatos[i].getSobrenome() + " - " + this.contatos[i].getContatoWhatsApp() + "\n";
			}
		}
		return listagemWhatsApps;
	}

}
