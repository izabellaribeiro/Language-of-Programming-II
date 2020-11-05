import util.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**Classe que centraliza todos os métodos e funcionalidades, controlando-os para a execução.*/

public class ControleDoSistema {


    /**Abriga todos os alunos já cadastrados no sistema*/
    private Map<String,Aluno> alunosCadastrados;


    /**Abriga todos os grupos de estudos já cadastrados.*/
    private Map<String, GrupoDeEstudos> gruposDeEstudos;


    /**Abriga os alunos que responderam as questões no quadro*/
    private ArrayList<Aluno> alunosQueRespodemQuestoesNoQuadro;

    /**Verifica a entrada de parâmetros nos métodos.*/
    private Validador validador;

    /**Construtor*/
    public ControleDoSistema() {
        this.alunosCadastrados = new HashMap<String, Aluno>();
        this.gruposDeEstudos = new HashMap<String, GrupoDeEstudos>();
        this.alunosQueRespodemQuestoesNoQuadro = new ArrayList<Aluno>();
        this.validador = new Validador();
    }

    /**Cadastra alunos no sistema
     * @param matricula que será utilizada para cadastrar alunos no sistema.
     * @param nome nome do aluno.
     * @param curso que o aluno pertence.
     * @return mensagem de retorno após o cadastro.*/
    public String cadastraAlunos(String matricula, String nome, String curso){
        this.validador.validacaoString(matricula, "Matrícula do Aluno: ");
        this.validador.validacaoString(nome, "Nome do Aluno: ");
        this.validador.validacaoString(curso, "Curso do Aluno: ");
        Aluno aluno = new Aluno(nome, matricula, curso);
        if (this.alunosCadastrados.containsKey(aluno.getMatriculaAluno())) {
             return "ESSA MATRÍCULA JÁ TEM UM CADASTRO, TENTE OUTRA!";
         }

        this.alunosCadastrados.put(aluno.getMatriculaAluno(), aluno);
        return "Cadastro realizado com sucesso!";
    }

    /**Consulta um aluno já ou não cadastrado no sistema.
     * @param matricula que será usada para consultar o aluno.
     * @return mensagem de retorno para essa ação. */
    public String consultarAluno(String matricula) {
        this.validador.validacaoString(matricula, "Matrícula: ");
        if (this.alunosCadastrados.containsKey(matricula)) {
            return this.alunosCadastrados.get(matricula).toString();
        }
        return "Aluno não cadastrado!";
    }

    /**Cadastra grupo de estudos.
     * @param nomeGrupo que será utilizado como identificador do grupo.
     * @return mensagem de sucessão ou não dessa ação.*/
    public String cadastrarGrupo(String nomeGrupo){
        this.validador.validacaoString(nomeGrupo, "Nome do Grupo: ");
        GrupoDeEstudos grupo = new GrupoDeEstudos(nomeGrupo);
        if (!this.gruposDeEstudos.containsKey(grupo.getNome().toUpperCase())) {
            this.gruposDeEstudos.put(grupo.getNome().toUpperCase(), grupo);
            return "Cadastro de grupo realizado!";
        }
        return "Grupo já cadastrado!";
    }

    /**Aloca um aluno a um determinado grupo.
     * @param matricula matrícula do aluno para alocação.
     * @param nomeGrupoDeEstudos que será o grupo que o aluno será alocado.
     * @return mensagem de resposta a essa ação, havendo possibilidade ou NÃO. */
    public String alocarAlunosEmGrupo(String matricula, String nomeGrupoDeEstudos) {
        this.validador.validacaoString(matricula, "Matrícula: ");
        this.validador.validacaoString(nomeGrupoDeEstudos, "Nome do Grupo: ");
        if (!this.gruposDeEstudos.containsKey(nomeGrupoDeEstudos.toUpperCase()) && this.alunosCadastrados.containsKey(matricula)){
            return "Grupo não cadastrado!";
        }
        else if(!this.alunosCadastrados.containsKey(matricula) && this.gruposDeEstudos.containsKey(nomeGrupoDeEstudos.toUpperCase())) {
            return "Aluno não cadastrado!";
        }
        else if(!this.gruposDeEstudos.containsKey(nomeGrupoDeEstudos.toUpperCase()) &&
                !this.alunosCadastrados.containsKey(matricula)) {
            return "Grupo de Estudo não cadastrado \nAluno não cadastrado!";
        }
        this.gruposDeEstudos.get(nomeGrupoDeEstudos.toUpperCase()).cadastraAlunoNoGrupo(this.alunosCadastrados.get(matricula));
        return "Aluno alocado!";
    }

    /**Imprime grupos já cadastrados no sistema.
     * @param nomeGrupoDeEstudos nome do grupo de estudos que será mostrado.
     * @return alunos do grupo informado. */
    public String imprimirGrupos(String nomeGrupoDeEstudos) {
        this.validador.validacaoString(nomeGrupoDeEstudos, "Nome: ");
        if (!this.gruposDeEstudos.containsKey(nomeGrupoDeEstudos.toUpperCase())) {
            return "Grupo não cadastrado!";
        }
        return "Alunos do grupo " + nomeGrupoDeEstudos.toUpperCase() + ":\n"
                + this.gruposDeEstudos.get(nomeGrupoDeEstudos.toUpperCase()).toString();
    }

    /**Cadastra os alunos que estão a responder as questões no quadro, de acordo com a sua atividade.
     * @param matricula do aluno para identificação e cadastro dos alunos que responderam.
     * @return mensagem de sucessão ou não de aluno na lista. */
    public String cadastrarAlunosQueRespodemQuestoesNoQuadro(String matricula){
        this.validador.validacaoString(matricula, "Matrícula: ");
        if (!this.alunosCadastrados.containsKey(matricula)) {
            return "Aluno não cadastrado!";
        }
        alunosQueRespodemQuestoesNoQuadro.add(this.alunosCadastrados.get(matricula));
        return "ALUNO REGISTRADO!";
    }

    /**Imprime todos os alunos que já responderam as questões.
     * @return alunos que já responderam ou uma mensagem de não sucessão do processo. */
    public String imprimirAlunosQueRespodemQuestoesNoQuadro(){
        if (alunosQueRespodemQuestoesNoQuadro.size() >= 1) {
            String alunosQueResponderam = "";
            for (int i = 0; i < this.alunosQueRespodemQuestoesNoQuadro.size(); i++) {
                alunosQueResponderam += (i + 1) + ". " + this.alunosQueRespodemQuestoesNoQuadro.get(i).toString() + "\n";
            }
            return alunosQueResponderam;
        }
        return "Nenhum aluno respondeu às questões do quadro!";
    }
}