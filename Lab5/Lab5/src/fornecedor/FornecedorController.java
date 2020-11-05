package fornecedor;

import util.Validador;

import java.util.HashMap;

public class FornecedorController {

    HashMap<String, Fornecedor> fornecedores;
    Validador validador;

    public FornecedorController(){
        this.fornecedores = new HashMap<>();
        this.validador = new Validador();
    }

    public String cadastraFornecedor(String nome, String email, String telefone) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL");
        this.validador.validacaoStringNulaOuVazia(telefone, "O TELEFONE");
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        this.fornecedores.put(fornecedor.getNome(), fornecedor);
        return fornecedor.getNome();
    }

    public String exibeFornecedor(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        if (!this.fornecedores.containsKey(nome)) {
            return "CLIENTE NÃO ENCONTRADO!";
        }
        return this.fornecedores.get(nome).toString();
    }

    public String mostrarClientesCadastrados(){
        String fornecedoresCadastrados = "";
        if (this.fornecedores.isEmpty()) {
            fornecedoresCadastrados = "Não há clientes ainda.";
        }else{
            for (Fornecedor fornecedor: this.fornecedores.values()) {
                fornecedoresCadastrados += fornecedor.toString() + " | ";
            }
        }
        return fornecedoresCadastrados;
    }

    public boolean editaFornecedor(String nome, String atributo, String novoValor) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.validador.validacaoStringNulaOuVazia(atributo, "O ATRIBUTO");
        this.validador.validacaoStringNulaOuVazia(novoValor, "O CONTEUDO");
        String atributoFormatado = atributo.toUpperCase().trim();

        if (!this.fornecedores.containsKey(nome)){
            throw new IllegalArgumentException("O cpf digitado não está presente na lista de clientes.");
        }
        else if (atributoFormatado.equals("NOME")) {
            throw new IllegalArgumentException("O valor do NOME não pode ser alterado, é uma identificação única.");
        }
        else if (atributoFormatado.equals("EMAIL")) {
            this.fornecedores.get(nome).setEmail(novoValor);
        }
        else if (atributoFormatado.equals("TELEFONE")) {
            this.fornecedores.get(nome).setTelefone(novoValor);
        }
        else {
            throw new IllegalArgumentException("Esse atributo passado não existe no sistema!");
        }
        return true;
    }

    public void removeCliente(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        if (!this.fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("O cpf digitado não está presente na lista de clientes.");
        }
        this.fornecedores.remove(nome);
    }
}

