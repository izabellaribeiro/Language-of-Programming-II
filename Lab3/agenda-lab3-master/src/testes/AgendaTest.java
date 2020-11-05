package testes;

import agenda.Agenda;
import agenda.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgendaTest {

    /**Inicializando a agenda*/
    private Agenda agenda;

    /**Inicializando Contato*/
    private Contato contato;

    /**Atribuindo valores que serão usado no restante dos métodos*/
    @BeforeEach
    void setUp() {
        agenda = new Agenda();
        contato = new Contato("Izabella", "Ribeiro","88339801", "985674102","25253698", "1", "2");
    }

    /**Testes de cadastro de contato*/
    @Test
    void cadastraContato() {
        assertTrue(agenda.cadastraContato(1, contato));
        assertTrue(agenda.cadastraContato(100, contato));
        Contato contato2 = new Contato("Fabiola", "Valesca", "88336801", "965321458", "25369874", "1", "2");
        assertTrue(agenda.cadastraContato(1, contato2));
        assertFalse(agenda.cadastraContato(0, contato2));
        assertFalse(agenda.cadastraContato(101, contato2));
    }

    /**Testes de exibição de contato*/
    @Test
    void exibirContato() {
        Contato contato2 = new Contato("Valquiria", "Santos","81529094", "88336801", "", "1", "");
        Contato contato3 = new Contato("Vanuza", "Souza", "86577074", "963358414", "", "2", "3");
        Contato contato4 = new Contato("Vanessa", "Soares", "88336801", "86577074", "","", "6");
        Contato contato5 = new Contato("Vanessa", "Soares", "", "", "88336801","1", "2");
        agenda.cadastraContato(1, contato);
        agenda.cadastraContato(2, contato2);
        agenda.cadastraContato(3, contato3);
        agenda.cadastraContato(4, contato4);
        agenda.cadastraContato(5, contato5);
        assertEquals("POSICAO INVALIDA!", agenda.exibirContato(0));
        assertEquals("POSICAO INVALIDA!", agenda.exibirContato(101));
        assertEquals("POSICAO INVALIDA!", agenda.exibirContato(10));
        assertEquals("Dados do Contato\nIzabella Ribeiro\n88339801 (prioritário)\n985674102 (zap)", agenda.exibirContato(1));
        assertEquals("Dados do Contato\nValquiria Santos\n81529094 (prioritário)\nNÃO TEM! (zap)", agenda.exibirContato(2));
        assertEquals("Dados do Contato\nVanuza Souza\n963358414 (prioritário)\nNÃO TEM! (zap)", agenda.exibirContato(3));
        assertEquals("Dados do Contato\nVanessa Soares\nNÃO TEM! (prioritário)\nNÃO TEM! (zap)", agenda.exibirContato(4));
        assertEquals("Dados do Contato\nVanessa Soares\nNÃO TEM! (prioritário)\nNÃO TEM! (zap)", agenda.exibirContato(5));
    }

    /**Teste de listagem de contatos na agenda*/
    @Test
    void listarContatos() {
        Contato contato2 = new Contato("Valquiria", "Santos","81529094", "88336801", "", "1", "");
        Contato contato3 = new Contato("Vanuza", "Souza", "86577074", "963358414", "", "2", "3");
        agenda.cadastraContato(1, contato);
        agenda.cadastraContato(2, contato2);
        agenda.cadastraContato(3, contato3);
        assertEquals("1 - Izabella Ribeiro\n2 - Valquiria Santos\n3 - Vanuza Souza\n", agenda.listarContatos());

    }

    /**Teste de listagens de contatos preferidos.*/
    @Test
    void listarTelefonesPreferidos() {
        Contato contato2 = new Contato("Valquiria", "Santos","81529094", "88336801", "", "1", "");
        Contato contato3 = new Contato("Vanuza", "Souza", "86577074", "963358414", "", "2", "3");
        agenda.cadastraContato(1, contato);
        agenda.cadastraContato(2, contato2);
        agenda.cadastraContato(3, contato3);
        assertEquals("Izabella Ribeiro - 88339801\nValquiria Santos - 81529094\nVanuza Souza - 963358414\n", agenda.listarTelefonesPreferidos());
    }

    /**Teste de listagens de contatos Whatsapp.*/
    @Test
    void listarContatosWhatsApp() {
        Contato contato2 = new Contato("Valquiria", "Santos","81529094", "88336801", "", "1", "");
        Contato contato3 = new Contato("Vanuza", "Souza", "86577074", "963358414", "", "2", "3");
        agenda.cadastraContato(1, contato);
        agenda.cadastraContato(2, contato2);
        agenda.cadastraContato(3, contato3);
        assertEquals("Izabella Ribeiro - 985674102\nValquiria Santos - NÃO TEM!\nVanuza Souza - NÃO TEM!\n", agenda.listarContatosWhatsApp());
    }
}


