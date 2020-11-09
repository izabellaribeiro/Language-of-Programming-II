package fornecedor;

import cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorControllerTest {

    FornecedorController controller;

    @BeforeEach
    void setUp() {
        controller = new FornecedorController();
    }

    @Test
    void cadastraFornecedor() {
        assertEquals("Izabella", this.controller.cadastraFornecedor("Izabella", "izabella.silva@gmail.com", "88336801"));
    }

    @Test
    void cadastraFornecedorComNomeVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "izabella.silva@gmail.com", "88338601"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor(" ", "izabella.silva@gmail.com", "88338601"));
        assertThrows(NullPointerException.class, () -> new Fornecedor(null, "izabella.silva@gmail.com", "88338601"));
    }

    @Test
    void cadastraFornecedorComEmailVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "", "88338601"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", " ", "88338601"));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Izabella", null, "88338601"));
    }

    @Test
    void cadastraFornecedorComTelefoneVazioOuNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "izabella.silva@gmail.com", ""));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Izabella", "izabella.silva@gmail.com", " "));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Izabella", "izabella.silva@gmail.com", null));
    }

    @Test
    void exibeFornecedor() {
        this.controller.cadastraFornecedor("Izabella", "izabella.silva@gmail.com", "88336801");
        assertEquals("Izabella - izabella.silva@gmail.com - 88336801", this.controller.exibeFornecedor("Izabella"));
    }

    @Test
    void exibeFornecedorNaoEncontrado(){
        assertEquals("FORNECEDOR NÃO ENCONTRADO!", this.controller.exibeFornecedor("Fernanda"));
    }

    @Test
    void exibeFornecedorNuloOuVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.exibeFornecedor(""));
        assertThrows(IllegalArgumentException.class, () -> this.controller.exibeFornecedor(" "));
        assertThrows(NullPointerException.class, () -> this.controller.exibeFornecedor(null));
    }

    @Test
    void mostrarFornecedoresCadastrados() {
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        this.controller.cadastraFornecedor("Vanuza", "vanuzaribeiro@gmail.com", "88336804");
        assertEquals("Vanuza - vanuzaribeiro@gmail.com - 88336804 | Izabella - izabellaribeiro@gmail.com - 88336801 | ", this.controller.mostrarClientesCadastrados());
    }

    @Test
    void tentaEdicaoFornecedorNome() {
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        assertThrows(IllegalArgumentException.class, () ->  this.controller.editaFornecedor("Izabella", "nome", "Vanessa"));
    }

    @Test
    void editaFornecedorEmail(){
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        this.controller.editaFornecedor("Izabella", "email", "izabella.silva@gmail.com");
        assertEquals("Izabella - izabella.silva@gmail.com - 88336801", this.controller.exibeFornecedor("Izabella"));
    }

    @Test
    void editaFornecedorTelefone(){
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        this.controller.editaFornecedor("Izabella", "telefone", "86577074");
        assertEquals("Izabella - izabellaribeiro@gmail.com - 86577074", this.controller.exibeFornecedor("Izabella"));
    }

    @Test
    void tentativaEdicaoNaoCadastrado(){
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");

    }

    @Test
    void tentativaParametrosNulos(){
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        assertThrows(NullPointerException.class, () -> this.controller.editaFornecedor(null, "email", "izinha1234@gmail.com"));
        assertThrows(NullPointerException.class, () -> this.controller.editaFornecedor("Izabella", null, "izinha1234@gmail.com"));
        assertThrows(NullPointerException.class, () -> this.controller.editaFornecedor("Izabella", "telefone", null));
    }

    @Test
    void tentativaParametrosVazios(){
        this.controller.cadastraFornecedor("Izabella", "izabellaribeiro@gmail.com", "88336801");
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaFornecedor("", "email", "izinha1234@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaFornecedor("Izabella", " ", "izinha1234@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controller.editaFornecedor("Izabella", "", " "));
    }

    @Test
    void removeFornecedor() {
        this.controller.cadastraFornecedor("Izabella", "izabella.silva@ccc.ufcg.edu.br", "88336801");
        assertTrue(this.controller.removeFornecedor("Izabella"));
    }

    @Test
    void removeFornecedorNomeNuloOuVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeFornecedor(""));
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeFornecedor(" "));
        assertThrows(NullPointerException.class, () -> this.controller.removeFornecedor(null));
    }

    @Test
    void removeFornecedorNaoCadastrado(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.removeFornecedor("Izabella"));
    }

}