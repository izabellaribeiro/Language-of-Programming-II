import util.Validador;

import java.util.Objects;

/**
 * Classe formulada para armazenar características inerentes ao Aluno.
 * */

public class Aluno {

    /**valor que será recolhido para o nome do aluno. **/
    private String nomeAluno;

    /**Matrícula do aluno. **/
    private String matriculaAluno;

    /**Curso que o aluno faz parte. **/
    private String curso;

    private Validador validador;

    /**Construtor da classe que, recebe nome, matrícula e curso.
     * @param nomeAluno nome do aluno a ser cadastrado.
     * @param matriculaAluno matrícula do aluno a ser cadastrado.
     * @param curso curso que o aluno participa. */
    public Aluno(String nomeAluno, String matriculaAluno, String curso) {
        this.validador = new Validador();
        this.validador.validacaoString(nomeAluno, "Nome: ");
        this.validador.validacaoString(matriculaAluno, "Matrícula: ");
        this.validador.validacaoString(curso, "Curso: ");
        this.nomeAluno = nomeAluno;
        this.matriculaAluno = matriculaAluno;
        this.curso = curso;
    }

    /**Retorna a matrícula do aluno
     * @return matricula do aluno. */
    public String getMatriculaAluno() {
        return this.matriculaAluno;
    }

    /**toString() informativo para reportar as características de cada Aluno.
     * @return caracteristicas do aluno **/
    @Override
    public String toString() {
        return "Aluno: " + this.matriculaAluno + " - " + this.nomeAluno + " - " + this.curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getMatriculaAluno(), aluno.getMatriculaAluno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatriculaAluno());
    }
}
