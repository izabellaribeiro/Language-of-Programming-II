package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("13786914400", "Izabella", "izabellaribeiro@gmail.com", "lsd");
    }


    @Test
    void testaConstrutorComRecebimentoDeCPFInválido(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("111111111", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(NullPointerException.class, () -> new Cliente(null, "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente(" ", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000601", "Izabella", "izabellaribeiro@gmail.com", "splab"));
    }

    @Test
    void testaConstrutorComNomeVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", " ", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", null, "izabellaribeiro@gmail.com", "splab"));

    }

    @Test
    void testaConstrutorComEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "izabellaribeirogmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "izabellaribeirogmail", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", " ", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", null, "splab"));
    }

    @Test
    void testaConstrutorComLocalizacaoVaziaOuNula(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "izabellaribeiro@gmail.com", " "));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "izabellaribeiro@gmail.com", ""));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("13786958822", "Izabella", "izabellaribeiro@gmail.com", null));
    }

    @Test
    void getCpf() {
        assertEquals("13786914400", this.cliente.getCpf());
    }

    @Test
    void setNome() {
        this.cliente.setNome("Vanessa");
        assertEquals("Vanessa - lsd - izabellaribeiro@gmail.com", this.cliente.toString());
    }

    @Test
    void setEmail() {
        this.cliente.setEmail("izabellaribeiro5@gmail.com");
        assertEquals("Izabella - lsd - izabellaribeiro5@gmail.com", this.cliente.toString());
    }

    @Test
    void setLocalizacao() {
        this.cliente.setLocalizacao("splab");
        assertEquals("Izabella - splab - izabellaribeiro@gmail.com", this.cliente.toString());
    }

    @Test
    void testToString() {
        assertEquals("Izabella - lsd - izabellaribeiro@gmail.com", this.cliente.toString());
    }

    @Test
    void testEquals() {
        Cliente cliente2 = new Cliente("13786914400", "Vanessa", "vanessa234alves@gmail.com", "lab3");
        assertTrue(this.cliente.equals(cliente2));
    }

    @Test
    void testHashCode() {
        Cliente cliente2 = new Cliente("13786914400", "Vanessa", "vanessa234alves@gmail.com", "lab3");
        assertEquals(this.cliente.hashCode(), cliente2.hashCode());
    }

}