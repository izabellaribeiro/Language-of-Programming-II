package fornecedor;

import produto.Produto;
import util.Validador;

import java.util.HashMap;
import java.util.Objects;

/*Classe responsável pelo armazenamento de informações de cada fornecedor. */

public class Fornecedor {

    /*Nome do fornecedor*/
    private String nome;

   /*Email do fornecedor*/
    private String email;

    /*Telefone do fornecedor*/
    private String telefone;

    /*Validador de entradas*/
    private Validador validador = new Validador();

    /*Produtos do fornecedor*/
    private HashMap produtos;

    /*Construtor*/
    public Fornecedor(String nome, String email, String telefone) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL");
        this.validador.validacaoStringNulaOuVazia(telefone, "O TELEFONE");
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap();
    }

    /*Retorna o nome para identificação do fornecedor. */
    public String getNome() {
        return nome;
    }

    /*Muda o atributo nome do fornecedor*/
    public void setNome(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.nome = nome;
    }

    /*Muda o atributo email do fornecedor*/
    public void setEmail(String email) {
        this.validador.validacaoStringNulaOuVazia(nome, "O EMAIL");
        this.email = email;
    }

    /*Muda o atributo telefone do fornecedor*/
    public void setTelefone(String telefone) {
        this.validador.validacaoStringNulaOuVazia(nome, "O TELEFONE");
        this.telefone = telefone;
    }

    /*Retorna os dados do fornecedor em string. */
    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
