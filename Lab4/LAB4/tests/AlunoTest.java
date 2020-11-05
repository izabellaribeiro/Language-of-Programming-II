import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno1;

    @BeforeEach
    void setUp() {
        this.aluno1 = new Aluno("Izabella", "119210321", "cc");
    }

    @Test
    void testConstrutorParametrosNull(){
        assertThrows(NullPointerException.class, () -> new Aluno(null, "gabriel", "cc"));
        assertThrows(NullPointerException.class, () -> new Aluno("lala", null, "cc"));
        assertThrows(NullPointerException.class, () -> new Aluno("12312", "gabriel", null));
    }

    @Test
    void testConstrutorParametrosVazios(){
        assertThrows(IllegalArgumentException.class, () -> new Aluno("", "gabriel", "cc"));
        assertThrows(IllegalArgumentException.class, () -> new Aluno("gabriela", "", "cc"));
        assertThrows(IllegalArgumentException.class, () -> new Aluno("lala", "23456", ""));
        assertThrows(IllegalArgumentException.class, () -> new Aluno(" ", "gabriel", "cc"));
        assertThrows(IllegalArgumentException.class, () -> new Aluno("gabriela", " ", "cc"));
        assertThrows(IllegalArgumentException.class, () -> new Aluno("lala", "23456", " "));
    }

    @Test
    void testToString1() {
        assertEquals("Aluno: 119210321 - Izabella - cc", aluno1.toString());
    }

    @Test
    void testEquals1() {
        Aluno aluno2 = new Aluno("Izabella", "119210321", "geografia");
        assertTrue(aluno1.equals(aluno1));
    }

    @Test
    void testHashCode1() {
        Aluno aluno2 = new Aluno("Izabella", "119210321", "geografia");
        assertEquals(this.aluno1.hashCode(), aluno2.hashCode());
    }
}