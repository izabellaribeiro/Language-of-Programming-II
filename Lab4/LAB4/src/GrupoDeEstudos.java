import util.Validador;

import java.util.ArrayList;
import java.util.Objects;

/**Classe que vai ser responsável por carregar características inerentes ao Grupo de Estudos criado.*/

public class GrupoDeEstudos {

    /**Nome de identificação do grupo de estudos.*/
    private String nome;

    /**Agrupamento de alunos que o grupo de Estudo irá ter.*/
    private ArrayList<Aluno> alunosDoGrupo;

    /**Valida as strings que serão dadas de entrada.*/
    private Validador validador;

   /**Construtor
    * @param nome do grupo de estudos.*/
    public GrupoDeEstudos(String nome){
        this.validador = new Validador();
        this.validador.validacaoString(nome, "Nome do Grupo: ");
        this.nome = nome;
        this.alunosDoGrupo = new ArrayList<>();
    }

    /**Verifica se o aluno já tem cadastro dentro do grupo de estudo, podendo impedir o recadastro do msm.
     * @param aluno aluno.
     * @return se um aluno está contido dentro do grupo.*/
    private boolean seJaTemCadastro(Aluno aluno){ return (this.alunosDoGrupo.contains(aluno)); }

    /**Cadastra o aluno no grupo de estudo.
     * @param aluno aluno que vai ser cadastrado.
     * @return se o aluno pode ser ou não cadastrado. */
    public boolean cadastraAlunoNoGrupo(Aluno aluno) {if (!seJaTemCadastro(aluno)) { this.alunosDoGrupo.add(aluno); return true;} return false;}

    /**Retorna o nome do grupo de Estudos.
     * @return nome*/
    public String getNome() {
        return nome;
    }

    /**Retorna todos os alunos cadastrados no grupo de estudos com uma formatação em forma de String.
     * @return alunos do grupo.*/
    @Override
    public String toString() {
        String alunosESeusToStrings = "";
        for (int i = 0; i < this.alunosDoGrupo.size(); i++) {
            alunosESeusToStrings += "* " + this.alunosDoGrupo.get(i) + "\n";
        }
        return alunosESeusToStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrupoDeEstudos)) return false;
        GrupoDeEstudos that = (GrupoDeEstudos) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(alunosDoGrupo, that.alunosDoGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, alunosDoGrupo);
    }
}

