package cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {

    ClienteController controller;

    @BeforeEach
    void setUp() {
        controller = new ClienteController();
    }

    @Test
    void cadastraClientesComValoresCorretos() {
        assertEquals("13786914400",this.controller.adicionaCliente("13786914400", "João", "izabellasilva@gmail.com", "lsd"));
    }

    @Test
    void cadastraClientesComCPFInválido(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("111111111", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente(" ", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000601", "Izabella", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(NullPointerException.class, () -> new Cliente(null, "Izabella", "izabellaribeiro@gmail.com", "splab"));
    }

    @Test
    void cadastraClientesComNomeVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", " ", "izabellaribeiro@gmail.com", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", null, "izabellaribeiro@gmail.com", "splab"));
    }
    @Test
    void cadastraClientesComEmailVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", " ", "splab"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", null, "splab"));
    }

    @Test
    void cadastraClientesComLocalizacaoVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "izabellaribeiro@gmail.com", ""));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "izabellaribeiro@gmail.com", " "));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", "Izabella", "izabellaribeiro@gmail.com", null));
    }

    @Test
    void exibirCliente() {
        this.controller.adicionaCliente("13786914400", "João", "izabellaribeiro@gmail.com", "lsd");
        assertEquals("João - lsd - izabellaribeiro@gmail.com", this.controller.exibeCliente("13786914400"));
    }

    @Test
    void exibirClienteNaoEncontrado() {
        assertEquals("CLIENTE NÃO ENCONTRADO!", this.controller.exibeCliente("13786914400"));
    }

    @Test
    void exibirClienteNuloOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.controller.exibeCliente(""));
        assertThrows(IllegalArgumentException.class, () -> this.controller.exibeCliente(" "));
        assertThrows(NullPointerException.class, () -> this.controller.exibeCliente(null));
    }

    @Test
    void mostrarClientesCadastrados() {
    this.controller.adicionaCliente("13786914400", "Izabella",
            "izabella.silva@ccc.ufcg.edu.br", "lsd");
        assertEquals("Izabella - lsd - izabella.silva@ccc.ufcg.edu.br | ",
                this.controller.mostrarClientesCadastrados());
    }


    @Test
    void editarCadastroClienteNome() {
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        this.controller.editaCliente("13786914400", "nome ", "Vanessa");
        assertEquals("Vanessa - lsd - izabella.silva@ccc.ufcg.edu.br", this.controller.exibeCliente("13786914400"));
    }


    @Test
    void editarCadastroClienteEmail() {
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        this.controller.editaCliente("13786914400", "email ", "vanessa.silva@gmail.com");
        assertEquals("Izabella - lsd - vanessa.silva@gmail.com", this.controller.exibeCliente("13786914400"));
    }

    @Test
    void editarCadastroClienteLocal() {
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        this.controller.editaCliente("13786914400", "LOCALIZACAO ", "guarita");
        assertEquals("Izabella - guarita - izabella.silva@ccc.ufcg.edu.br", this.controller.exibeCliente("13786914400"));
    }

    @Test
    void tentativaDeEdicaoCPF(){
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaCliente("13786914400", "cpf ", "1689635214"));
    }

    @Test
    void tentativaDeEdicaoDeNaoCadastrado(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaCliente("13786914400", "cpf ", "1689635214"));
    }

    @Test
    void tentativaDeEdicaoParametrosNulos(){
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        assertThrows(NullPointerException.class, () -> this.controller.editaCliente(null, "cpf ", "1689635214"));
        assertThrows(NullPointerException.class, () -> this.controller.editaCliente("13786914400", null, "1689635214"));
        assertThrows(NullPointerException.class, () -> this.controller.editaCliente("13786914400", "localizacao", null));
    }

    @Test
    void tentativaEdicaoParametrosVazios(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaCliente("", "cpf ", "1689635214"));
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaCliente("13786914400", " ", "1689635214"));
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaCliente("13786914400", "", " "));
    }

    @Test
    void removeCliente(){
        this.controller.adicionaCliente("13786914400", "Izabella",
                "izabella.silva@ccc.ufcg.edu.br", "lsd");
        assertTrue(this.controller.removeCliente("13786914400"));
    }

    @Test
    void removerClienteCPFNuloOuVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeCliente(""));
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeCliente(" "));
        assertThrows(NullPointerException.class, () -> this.controller.removeCliente(null));
    }


    @Test
    void removerClienteCPFNaoCadastrado() {
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeCliente("13786914400"));
    }
}