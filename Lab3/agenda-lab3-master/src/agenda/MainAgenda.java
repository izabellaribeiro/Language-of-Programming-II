package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade e Izabella Ribeiro de Souza Silva, matrícula: 119210321.
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(T)elefones Preferidos\n" +
						"(Z)aps\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
			case "C":
				cadastraContato(agenda, scanner);
				break;
			case "L":
				listaContatos(agenda);
				break;
			case "E":
				exibeContato(agenda, scanner);
				break;
			case "T":
				listaContatosPrioritarios(agenda);
				break;
			case "Z":
				listaContatosWhatsApp(agenda);
				break;
			case "S":
				sai();
				break;
			default:
				System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.listarContatos());
	}

	/**
	 * Imprime lista de contatos prioritários da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatosPrioritarios(Agenda agenda) {
		System.out.println("\nLista de contatos prioritários: ");
		System.out.println(agenda.listarTelefonesPreferidos());
	}

	/**
	 * Imprime lista de contatos de WhatsApp da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatosWhatsApp(Agenda agenda) {
		System.out.println("\nLista de contatos de WhatsApp: ");
		System.out.println(agenda.listarContatosWhatsApp());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.exibirContato(posicao));
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + ": " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao >= 1 && posicao <= 100){
			System.out.print("\nNome> ");
			String nome = scanner.next();
			System.out.print("\nSobrenome> ");
			String sobrenome = scanner.next();
			scanner.nextLine();
			System.out.print("\nTelefone1> ");
			String telefone1 = scanner.nextLine();
			System.out.print("\nTelefone2> ");
			String telefone2 = scanner.nextLine();
			System.out.print("\nTelefone3> ");
			String telefone3 = scanner.nextLine();
			System.out.print("\nTelefone prioritário> ");
			String telefonePrioritario = scanner.nextLine();
			System.out.print("\nContato whatsapp> ");
			String contatoWhatsApp = scanner.nextLine();
			Contato contato = new Contato(nome, sobrenome, telefone1, telefone2, telefone3, telefonePrioritario, contatoWhatsApp);
			agenda.cadastraContato(posicao, contato);
			System.out.println("CADASTRO REALIZADO!");
		}
		else{
			System.out.println("POSICAO INVALIDA!");
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
