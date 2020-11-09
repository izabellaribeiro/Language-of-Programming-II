package fornecedor;

import cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;


    @BeforeEach
    void setUp() {
        this.fornecedor = new Fornecedor("Izabella", "izabella.silva@ccc.ufcg.edu.br", "88336801");
    }

    @Test
    void testaConstrutorComRecebimentoDeNomeInválido() {
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "izabellaribeiro@gmail.com", "(83) 986577074"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "izabellaribeiro@gmail.com", "(83) 986577074"));
        assertThrows(NullPointerException.class, () -> new Fornecedor(null, "izabellaribeiro@gmail.com", "(83) 986577074"));
    }

    @Test
    void testaConstrutorComNomeVazioOuNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "", "(83) 986577074"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", " ", "(83) 986577074"));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Izabella", null, "(83) 986577074"));

    }

    @Test
    void testaConstrutorComTelefoneInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "izabellaribeiro@gmail.com", ""));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "izabellaribeiro@gmail.com", " "));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Izabella", "izabellaribeiro@gmail.com", null));
    }


    @Test
    void getNome() { assertEquals("Izabella", this.fornecedor.getNome());
    }

    @Test
    void setNome() {
        this.fornecedor.setNome("Vanessa");
        assertEquals("Vanessa - izabella.silva@ccc.ufcg.edu.br - 88336801", this.fornecedor.toString());
    }

    @Test
    void setEmail() {
        this.fornecedor.setEmail("vanessasilva@gmail.com");
        assertEquals("Izabella - vanessasilva@gmail.com - 88336801", this.fornecedor.toString());
    }

    @Test
    void setTelefone() {
        this.fornecedor.setTelefone("86577074");
        assertEquals("Izabella - izabella.silva@ccc.ufcg.edu.br - 86577074", this.fornecedor.toString());
    }

    @Test
    void testToString() {
        assertEquals("Izabella - izabella.silva@ccc.ufcg.edu.br - 88336801", this.fornecedor.toString());
    }

    @Test
    void testEquals() {
        Fornecedor fornecedor2 = new Fornecedor("Izabella", "izabella.silva@ccc.ufcg.com.br", "89768901");
        assertTrue(this.fornecedor.equals(fornecedor2));
    }

    @Test
    void testHashCode() {
        Fornecedor fornecedor2 = new Fornecedor("Izabella", "izabella.silva@ccc.ufcg.com.br", "89768901");
        assertEquals(this.fornecedor.hashCode(), fornecedor2.hashCode());
    }
}