package fornecedor;

import util.Validador;

import java.util.HashMap;

/*Classe criada para o controle de ações dos fornecedores. */

public class FornecedorController {

    /*Map para o armazenamento de fornecedores cadastrados. */
    private HashMap<String, Fornecedor> fornecedores;

    /*Iniciação de classe de Validador que será usado para verificação de entradas*/
    private Validador validador;

    /*Construtor*/
    public FornecedorController(){
        this.fornecedores = new HashMap<>();
        this.validador = new Validador();
    }

    /** Método responsável pelo cadastro de clientes
     * @param  nome nome do cliente
     * @param email email do cliente.
     * @param telefone do cliente.
     * @return nome do fornecedor, quando ocorrer uma ação bem sucedida. */
    public String cadastraFornecedor(String nome, String email, String telefone) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL");
        this.validador.validacaoStringNulaOuVazia(telefone, "O TELEFONE");
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        this.fornecedores.put(fornecedor.getNome(), fornecedor);
        return fornecedor.getNome();
    }

    /** Método responsável pela exibição de um cliente, de acordo com a sua identificação (cpf)
     * @param nome para a busca dos dados do cliente.
     * @return mensagem de final de ação (quando sucedida ou não).
     * */
    public String exibeFornecedor(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        if (!this.fornecedores.containsKey(nome)) {
            return "FORNECEDOR NÃO ENCONTRADO!";
        }
        return this.fornecedores.get(nome).toString();
    }

    /** Método responsável pela exibição de todos os fornecedores já cadastrados no sistema
     * @return todos os fornecedores já cadastrados e seus respectivos toStrings. */
    public String mostrarClientesCadastrados(){
        String fornecedoresCadastrados = "";
        if (this.fornecedores.isEmpty()) {
            fornecedoresCadastrados = "Não há fornecedores ainda!";
        }else{
            for (Fornecedor fornecedor: this.fornecedores.values()) {
                fornecedoresCadastrados += fornecedor.toString() + " | ";
            }
        }
        return fornecedoresCadastrados;
    }

    /** Método responsável pelo requerimento de edição de informações do forncedor, exceto o campo de nome, já que é
     * um identificador.
     * @param nome para saber qual o forncedorque será editado.
     * @param atributo qual o campo que será editado.
     * @param novoValor novo conteudo que o campo escolhido vai conter.
     */
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

    /** Método responsável pela remoção de clientes
     * @param nome para identificação de qual fornecedor será removido do sistema.
     * */
    public boolean removeFornecedor(String nome) {
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        if (!this.fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("O cpf digitado não está presente na lista de clientes.");
        }
        this.fornecedores.remove(nome);
        return true;
    }
}

