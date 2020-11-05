package testes;

import agenda.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContatoTest {

    /**Inicializando */
    private Contato contato;

    /**Recebe nome e sobrenome no construtor*/
    @BeforeEach
    void setUp() {
        contato = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "81529094","1", "2");
    }

    /**testa valores retornados no toString()*/
    @Test
    void testToString() {
        contato = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "81529094","1", "2");
        assertEquals("Dados do Contato\nIzabella Ribeiro\n88336801 (prioritário)\n86577074 (zap)", contato.toString());
        contato = new Contato("Vanessa", "Soares", "88336801", "86577074", "","1", "3");
        assertEquals("Dados do Contato\nVanessa Soares\n88336801 (prioritário)\nNÃO TEM! (zap)", contato.toString());
        contato = new Contato("Vanessa", "Soares", "88336801", "86577074", "","5", "3");
        assertEquals("Dados do Contato\nVanessa Soares\nNÃO TEM! (prioritário)\nNÃO TEM! (zap)", contato.toString());
        contato = new Contato("Vanessa", "Soares", "88336801", "86577074", "","", "6");
        assertEquals("Dados do Contato\nVanessa Soares\nNÃO TEM! (prioritário)\nNÃO TEM! (zap)", contato.toString());
        contato = new Contato("Vanessa", "Soares", "", "", "88336801","1", "2");
        assertEquals("Dados do Contato\nVanessa Soares\nNÃO TEM! (prioritário)\nNÃO TEM! (zap)", contato.toString());
    }

    @Test
    void equals(){
        contato = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "81529094","1", "2");
        Contato  contato2 = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "","1", "3");
        assertTrue(contato.equals(contato2));
    }

    @Test
    void testHashCode() {
        contato = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "81529094","1", "2");
        Contato  contato2 = new Contato("Izabella", "Ribeiro", "88336801", "86577074", "","1", "3");
        assertEquals(contato.hashCode(), contato2.hashCode());
    }
}