import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleDoSistemaTest {

    private ControleDoSistema controleDoSistema;

    @BeforeEach
    void setUp() {
        controleDoSistema = new ControleDoSistema();
    }

    @Test
    void cadastraAlunosNulosOuVazios() {
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastraAlunos(null, "Izabella", "geografia"));
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastraAlunos("119210321", null, "geografia"));
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastraAlunos("119210321", "Valéria", null));
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastraAlunos(null, null, null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.cadastraAlunos("", "", ""));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.cadastraAlunos("78965231", "", "Física"));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.cadastraAlunos("", "Cláudia", "Física"));
    }

    @Test
    void cadastraAlunos(){
        this.controleDoSistema.cadastraAlunos("7568965423", "laura", "geografia");
        assertEquals("Cadastro realizado com sucesso!", controleDoSistema.cadastraAlunos("119210321", "iza", "matematica"));
        assertEquals("ESSA MATRÍCULA JÁ TEM UM CADASTRO, TENTE OUTRA!", controleDoSistema.cadastraAlunos("7568965423", "Izabella", "cc"));
        assertEquals("ESSA MATRÍCULA JÁ TEM UM CADASTRO, TENTE OUTRA!", controleDoSistema.cadastraAlunos("7568965423", "laura", "cc"));
    }

    @Test
    void consultarAlunoComMatriculaNulaOuVazia() {
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.consultarAluno(null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.consultarAluno(""));
    }

    @Test
    void consultarAluno(){
        this.controleDoSistema.cadastraAlunos("119210321", "Izabella", "CC");
        assertEquals("Aluno não cadastrado!", this.controleDoSistema.consultarAluno("12"));
        assertEquals("Aluno: 119210321 - Izabella - CC", this.controleDoSistema.consultarAluno("119210321"));
    }

    @Test
    void cadastrarGrupoComNomeNuloOuVazio() {
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastrarGrupo(null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.cadastrarGrupo(""));
    }

    @Test
    void cadastraGrupo(){
        this.controleDoSistema.cadastrarGrupo("Java");
        assertEquals("Cadastro de grupo realizado!", this.controleDoSistema.cadastrarGrupo("Listas"));
        assertEquals("Grupo já cadastrado!", this.controleDoSistema.cadastrarGrupo("Java"));
    }

    @Test
    void alocarAlunosEmGrupoComMatriculaENomeNulosOuVazios(){
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo(null, null));
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo(null, "Java"));
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo("19234567", null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo("", ""));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo("", "Java"));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.alocarAlunosEmGrupo("2568974125", ""));
    }

    @Test
    void alocarAlunosEmGrupo() {
        this.controleDoSistema.cadastrarGrupo("Listas");
        this.controleDoSistema.cadastrarGrupo("Python");
        this.controleDoSistema.cadastraAlunos("119245689", "Izabela", "cc");
        this.controleDoSistema.cadastraAlunos("119210321", "Izabela", "cc");
        assertEquals("Grupo não cadastrado!", this.controleDoSistema.alocarAlunosEmGrupo("119245689", "Java"));
        assertEquals("Aluno não cadastrado!", this.controleDoSistema.alocarAlunosEmGrupo("2525", "listas"));
        assertEquals("Grupo de Estudo não cadastrado \nAluno não cadastrado!", this.controleDoSistema.alocarAlunosEmGrupo("210568965", "Java"));
        assertEquals("Aluno alocado!", this.controleDoSistema.alocarAlunosEmGrupo("119245689", "listas"));
        assertEquals("Aluno alocado!", this.controleDoSistema.alocarAlunosEmGrupo("119245689", "listAS"));
        assertEquals("Aluno alocado!", this.controleDoSistema.alocarAlunosEmGrupo("119210321", "listAS"));
        assertEquals("Aluno alocado!", this.controleDoSistema.alocarAlunosEmGrupo("119210321", "python"));
    }

    @Test
    void imprimirGruposComNomeDoGrupoNullOuVazio(){
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.imprimirGrupos(null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.imprimirGrupos(""));
    }
    @Test
    void imprimirGrupos() {
        this.controleDoSistema.cadastrarGrupo("Listas");
        this.controleDoSistema.cadastrarGrupo("Python");
        this.controleDoSistema.cadastraAlunos("119245689", "Izabela", "cc");
        this.controleDoSistema.cadastraAlunos("119210321", "Izabela", "cc");
        this.controleDoSistema.cadastraAlunos("210568947", "Julia", "espanhol");
        this.controleDoSistema.cadastraAlunos("210568947", "Fernanda", "espanhol");
        this.controleDoSistema.alocarAlunosEmGrupo("119245689", "listas");
        this.controleDoSistema.alocarAlunosEmGrupo("119245689", "listAS");
        this.controleDoSistema.alocarAlunosEmGrupo("119210321", "listAS");
        this.controleDoSistema.alocarAlunosEmGrupo("119210321", "python");
        assertEquals("Grupo não cadastrado!", this.controleDoSistema.imprimirGrupos("Java"));
        assertEquals("Alunos do grupo LISTAS:\n* Aluno: 119245689 - Izabela - cc\n* Aluno: 119210321 - Izabela - cc\n",
                this.controleDoSistema.imprimirGrupos("Listas"));
        assertEquals("Alunos do grupo PYTHON:\n* Aluno: 119210321 - Izabela - cc\n",
                this.controleDoSistema.imprimirGrupos("python"));
    }

    @Test
    void testNullOuVazioNoCadastroDeAlunosQueResponderam(){
        assertThrows(NullPointerException.class, () -> this.controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro(null));
        assertThrows(IllegalArgumentException.class, () -> this.controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro(""));
    }

    @Test
    void cadastrarAlunosQueRespodemQuestoesNoQuadro() {
        assertEquals("Aluno não cadastrado!",
                this.controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro("191919"));

        this.controleDoSistema.cadastraAlunos("119210321", "Izabella Ribeiro", "Geografia");
        assertEquals("ALUNO REGISTRADO!",
                this.controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro("119210321"));
    }

    @Test
    void imprimirAlunosQueRespodemQuestoesNoQuadro() {
        this.controleDoSistema.cadastraAlunos("119245689", "Izabela", "cc");
        this.controleDoSistema.cadastraAlunos("119210321", "Izabela", "cc");
        this.controleDoSistema.cadastraAlunos("210568947", "Julia", "espanhol");
        assertEquals("Nenhum aluno respondeu às questões do quadro!", this.controleDoSistema.imprimirAlunosQueRespodemQuestoesNoQuadro());
        this.controleDoSistema.cadastrarAlunosQueRespodemQuestoesNoQuadro("119210321");
        assertEquals("1. Aluno: 119210321 - Izabela - cc\n", this.controleDoSistema.imprimirAlunosQueRespodemQuestoesNoQuadro());
    }
}