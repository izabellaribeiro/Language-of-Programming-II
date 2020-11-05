package agenda;

import java.util.Objects;

/**
 * Classe que irá recolher informações e características sobre cada contato.
 * *
 * @author Izabella Ribeiro de Souza Silva.
 *
 */

public class Contato {

    /**Nome do contato**/
    private String nome;

    /**Sobrenome do contato**/
    private String sobrenome;

    /**Primeiro telefone do contato**/
    private String telefone1;

    /**Segundo telefone do contato**/
    private String telefone2;

    /**Terceiro telefone do contato**/
    private String telefone3;

    /**Telefone de prioridade do contato**/
    private String telefonePrioritario;

    /**Telefone de contato para WhatsApp do contato, se houver**/
    private String contatoWhatsApp;

    /**Quantidade de telefones que são recolhidos**/
    private static final int QUANTIDADE_DE_CONTATOS = 4;

    /**Valor que ao ser utilizado para a subtrações dos índices no array numerosTelefonicosPassados, já que em um array, os valores começam com 0 e não com 1**/
    private static final int INDICE_DE_SUBTRACAO_PADRAO = 1;

    /**Array de números telefônicos que serão cadastrados para um melhor acesso aos dados.**/
    private String[] numerosTelefonicosPassados;

    /**
     * Construtor que irá recolher o nome e o sobrenome.
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     */
    public Contato(String nome, String sobrenome, String telefone1, String telefone2, String telefone3, String telefonePrioritario, String contatoWhatsApp) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            cadastraTelefones(telefone1, telefone2, telefone3, telefonePrioritario, contatoWhatsApp);
    }



    /**
     * Inicializa os telefones recolhidos durante a passagem de informações do objeto.
     * @param telefone1 primeiro contato
     * @param telefone2 segundo contato
     * @param telefone3 terceiro contato
     * @param telefonePrioritario contato de mais influência
     * @param contatoWhatsApp contato para comunicação via whatsapp
     * @return    */
    private boolean cadastraTelefones(String telefone1, String telefone2, String telefone3, String telefonePrioritario, String contatoWhatsApp){
            this.telefone1 = telefone1;
            this.telefone2 = telefone2;
            this.telefone3 = telefone3;
            this.numerosTelefonicosPassados = new String[QUANTIDADE_DE_CONTATOS];
        cadastraContatosPassadosEmUmArray();
            if (contatoWhatsApp.equals("1") || contatoWhatsApp.equals("2") || contatoWhatsApp.equals("3")) {
                this.contatoWhatsApp = this.numerosTelefonicosPassados[Integer.parseInt(contatoWhatsApp)];
                if (this.contatoWhatsApp.equals("") || this.contatoWhatsApp.equals(" ")) {
                    this.contatoWhatsApp = "NÃO TEM!";
                }
            }
            else {
                this.contatoWhatsApp = "NÃO TEM!";
            }

            if (telefonePrioritario.equals("") || telefonePrioritario.equals(" ") || Integer.parseInt(telefonePrioritario) > 3) {
                this.telefonePrioritario = "NÃO TEM!";
            }
            else {
                this.telefonePrioritario = this.numerosTelefonicosPassados[Integer.parseInt(telefonePrioritario)];
                if (this.telefonePrioritario.equals("") || this.telefonePrioritario.equals(" ")){
                    this.telefonePrioritario = "NÃO TEM!";
                }
            }

        return true;
    }

    /**Cadastra os contatos em um array a parte, para que, quando for necessário verificar qual o contato de prioridade e o contato de whatsapp, facilitar o acesso.*/
    private void cadastraContatosPassadosEmUmArray(){
        this.numerosTelefonicosPassados[1] = this.telefone1;
        this.numerosTelefonicosPassados[2] = this.telefone2;
        this.numerosTelefonicosPassados[3] = this.telefone3;
    }

    /**Retorna o nome do Contato**/
    public String getNome() {
        return this.nome;
    }

    /**Retorna o sobrenome do Contato*/
    public String getSobrenome() {
        return this.sobrenome;
    }

    /**Retorna o telefone prioritário*/
    public String getTelefonePrioritario() {
        return this.telefonePrioritario;
    }

    /**Retorna o contato de WhatsApp*/
    public String getContatoWhatsApp() {
        return this.contatoWhatsApp;
    }

    /**Retorna a exibição do contato com suas características.*/
    @Override
    public String toString() {
        return  "Dados do Contato" + "\n" + this.nome + " " + this.sobrenome + "\n" + this.telefonePrioritario + " (prioritário)" + "\n" + this.contatoWhatsApp +
                " (zap)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getNome(), contato.getNome()) &&
                Objects.equals(getSobrenome(), contato.getSobrenome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSobrenome());
    }
    
}
