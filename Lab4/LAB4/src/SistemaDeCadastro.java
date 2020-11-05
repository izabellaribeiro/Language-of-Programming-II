import java.util.Scanner;

/**
 * Universidade Federal de Campina Grande, CEEI.
 * Laboratório de Programação 2, Lab4.
 * @author Izabella Ribeiro de Souza Silva. Matrícula: 19210321.
 * */

public class SistemaDeCadastro {
    public static void main(String[] args) {

        ControleDoSistema controleDoSistema = new ControleDoSistema();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            menu();
            comando(scanner,  controleDoSistema);
        }
    }
    private static void menu() {
        System.out.print("\n---\nMENU\n(C)adastrar Aluno\n(E)xibir Aluno\n(N)ovo Grupo\n(A)locar Aluno e Imprimir Grupos" +
                "\n(R)egistrar Aluno que Respondeu\n(I)mprimir Alunos que Responderam\n(O)ra, vamos fechar o programa!\n\nOpção> ");
    }

    private static void comando(Scanner scanner, ControleDoSistema controleDoSistema){
        String opcao = scanner.nextLine().toUpperCase().trim();
        if (opcao.equals("C")){
            cadastraAluno(scanner, controleDoSistema);
        }
        else if (opcao.equals("E")){
            exibeAluno(scanner, controleDoSistema);
        }
        else if (opcao.equals("N")) {
            cadastrarGrupo(scanner, controleDoSistema);
        }
        else if (opcao.equals("A")){
            alocarAlunoOuImprimirGrupo(scanner, controleDoSistema);
        }
        else if (opcao.equals("R")){
            registrarAlunoQueRespondeu(scanner, controleDoSistema);
        }
        else if (opcao.equals("I")){
            imprimirAlunosQueResponderam(controleDoSistema);
        }
        else if (opcao.equals("O")) {
            System.exit(0);
        }
        else {
            throw new IllegalArgumentException("A opção, nesse caso, é inválida!");
        }
    }

    private static void cadastraAluno(Scanner scanner, ControleDoSistema controleDoSistema) {
        System.out.print("Matrícula do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Nome do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso do Aluno: ");
        String curso = scanner.nextLine();
        System.out.println(controleDoSistema.cadastraAlunos(nome, matricula, curso));
    }

    private static void cadastrarGrupo(Scanner scanner, ControleDoSistema controleDoSistema) {
        System.out.print("Nome do grupo: ");
        String nomeDoGrupo = scanner.nextLine();
        System.out.println(controleDoSistema.cadastrarGrupo(nomeDoGrupo));
    }

    private static void exibeAluno(Scanner scanner, ControleDoSistema controleDoSistema) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println(controleDoSistema.consultarAluno(matricula));
    }

    private static void alocarAlunoOuImprimirGrupo(Scanner scanner, ControleDoSistema controleDoSistema) {
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
        String escolha = scanner.nextLine().toUpperCase();
        if (escolha.equals("A")){
            System.out.print("Matricula: ");
            String matricula = scanner.nextLine();
            System.out.print("Grupo: ");
            String grupo = scanner.nextLine();
            System.out.println(controleDoSistema.alocarAlunosEmGrupo(matricula, grupo));
        }
        else if (escolha.equals("I")){
            System.out.print("Nome do Grupo: ");
            String nomeGrupo = scanner.nextLine();
            System.out.println(controleDoSistema.imprimirGrupos(nomeGrupo));
        }
        else {
            throw new IllegalArgumentException("Você precisa escolher entre A ou I.");
        }
    }

    private static void registrarAlunoQueRespondeu(Scanner scanner, ControleDoSistema controleDoSistema){
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println(controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro(matricula));
    }

    private static void imprimirAlunosQueResponderam(ControleDoSistema controleDoSistema){
        System.out.println(controleDoSistema.imprimirAlunosQueRespodemQuestoesNoQuadro());
    }

}
