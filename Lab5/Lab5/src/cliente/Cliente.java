package cliente;

import util.Validador;

import java.util.Objects;

/** Classe responsável pelo armazenamento de informações de cada cliente. */

public class Cliente {

   /**Identificador de cada cliente*/
    private String cpf;

    /**Nome do cliente*/
    private String nome;

    /**email do cliente*/
    private String email;

    /**onde o cliente geralmente fica.*/
    private String localizacao;

    /**Validador de strings*/
    Validador validador = new Validador();

    /**Construtor*/
    public Cliente(String cpf, String nome, String email, String localizacao){
        this.validador.validacaoCPF(cpf);
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME ");
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL ");
        this.validador.validacaoStringNulaOuVazia(nome, "A LOCALIZAÇÃO ");
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /** @return cpf do cliente.*/
    public String getCpf() {
        return cpf;
    }

    /** Altera o nome do cliente
     * @param nome que vai ser o conteúdo da alteração.*/
    public void setNome(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.nome = nome;
    }

    /** Altera o email do cliente
     * @param email que vai ser o conteúdo da alteração.*/
    public void setEmail(String email) {
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL ");
        this.email = email;
    }

    /** Altera o nome do cliente
     * @param localizacao que vai ser o conteúdo da alteração.*/
    public void setLocalizacao(String localizacao) {
        this.validador.validacaoStringNulaOuVazia(localizacao, "A LOCALIZAÇÃO");
        this.localizacao = localizacao;
    }

    /** Organiza informações de um cliente retornando-as.
     * @return retorna essas informações. */
    @Override
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}
