import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoDeEstudosTest {

    private GrupoDeEstudos grupo1;

    @BeforeEach
    void setUp() {
        this.grupo1 = new GrupoDeEstudos("Java");
    }

    @Test
    void testConstrutorParametroNull(){
        assertThrows(NullPointerException.class, () -> new GrupoDeEstudos(null));
    }

    @Test
    void testConstrutorParametroVazio(){
        assertThrows(IllegalArgumentException.class, () -> new GrupoDeEstudos(" "));
        assertThrows(IllegalArgumentException.class, () -> new GrupoDeEstudos(""));
    }

    @Test
    void cadastraAlunoNoGrupo() {
        Aluno aluno1 = new Aluno("Izabella", "119210321", "cc");
        Aluno aluno2 = new Aluno("Izabella", "119210321", "geografia");
        Aluno aluno3 = new Aluno("Izabella", "586", "geografia");
        Aluno aluno4 = new Aluno("Carol", "589647", "geografia");
        assertTrue(grupo1.cadastraAlunoNoGrupo(aluno1));
        assertFalse(grupo1.cadastraAlunoNoGrupo(aluno2));
        assertTrue(grupo1.cadastraAlunoNoGrupo(aluno3));
        assertTrue(grupo1.cadastraAlunoNoGrupo(aluno4));
    }

    @Test
    void testToString() {
        Aluno aluno1 = new Aluno("Izabella", "119210321", "cc");
        Aluno aluno2 = new Aluno("Izabella", "119210321", "geografia");
        Aluno aluno3 = new Aluno("Izabella", "586", "geografia");
        Aluno aluno4 = new Aluno("Carol", "589647", "geografia");
        grupo1.cadastraAlunoNoGrupo(aluno1);
        grupo1.cadastraAlunoNoGrupo(aluno2);
        grupo1.cadastraAlunoNoGrupo(aluno3);
        grupo1.cadastraAlunoNoGrupo(aluno4);
        assertEquals("* Aluno: 119210321 - Izabella - cc\n* Aluno: 586 - Izabella - geografia\n* Aluno: 589647 - Carol - geografia\n", grupo1.toString());
    }

    @Test
    void testEquals() {
        GrupoDeEstudos grupo2 = new GrupoDeEstudos("Java");
        assertTrue(grupo1.equals(grupo2));
    }

    @Test
    void testHashCode() {
        GrupoDeEstudos grupo2 = new GrupoDeEstudos("Java");
        assertEquals(this.grupo1.hashCode(), grupo2.hashCode());
    }
}