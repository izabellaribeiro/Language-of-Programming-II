package cliente;

import util.Validador;

import java.util.HashMap;

/** Classe criada para o controle de ações para clientes.
 * **/

public class ClienteController {

    /*Iniciação de classe de Validador que será usado para verificação de entradas*/
    private Validador validador;

    /*Map para o armazenamento de clientes cadastrados. */
    private HashMap<String, Cliente> clientes;


    /*Construtor*/
    public ClienteController() {
        this.clientes = new HashMap<String, Cliente>();
        this.validador = new Validador();
    }

    /** Método responsável pelo cadastro de clientes
     * @param cpf cpf para a identificação de cada cliente
     * @param  nome nome do cliente
     * @param  localizacao local onde o cliente geralmente fica
     * @param email email do cliente.
     * @return o cpf do cliente, quando ocorrer uma ação bem sucedida. */
    public String adicionaCliente(String cpf, String nome, String email , String localizacao) {
        this.validador.validacaoCPF(cpf);
        this.validador.validacaoStringNulaOuVazia(nome, "O NOME");
        this.validador.validacaoStringNulaOuVazia(email, "O EMAIL");
        this.validador.validacaoStringNulaOuVazia(localizacao, "A LOCALIDADE");
        Cliente cliente = new Cliente(cpf, nome, email,  localizacao);
        this.clientes.put(cliente.getCpf(), cliente);
        return cliente.getCpf();
    }

    /** Método responsável pela exibição de um cliente, de acordo com a sua identificação (cpf)
     * @param cpf para a busca dos dados do cliente.
     * @return mensagem de final de ação (quando sucedida ou não).
     * */
    public String exibeCliente(String cpf) {
        this.validador.validacaoCPF(cpf);
        if (!this.clientes.containsKey(cpf)) {
            return "CLIENTE NÃO ENCONTRADO!";
        }
        return this.clientes.get(cpf).toString();
    }

    /** Método responsável pela exibição de todos os clientes já cadastrados no sistema
     * @return todos os clientes já cadastrados e seus respectivos toStrings. */
    public String mostrarClientesCadastrados(){
        String clientesCadastrados = "";
        if (this.clientes.isEmpty()) {
            clientesCadastrados = "Não há clientes ainda.";
        }else{
            for (Cliente cliente: this.clientes.values()) {
                clientesCadastrados += cliente.toString() + " | ";
            }
        }
        return clientesCadastrados;
    }

    /** Método responsável pelo requerimento de edição de informações do cliente, exceto o campo de cpf, já que é
     * um identificador.
     * @param cpf para saber qual o cliente que será editado.
     * @param atributo qual o campo que será editado.
     * @param novoValor novo conteudo que o campo escolhido vai conter.
     */
    public boolean editaCliente(String cpf, String atributo, String novoValor){
        this.validador.validacaoCPF(cpf);
        this.validador.validacaoStringNulaOuVazia(atributo, "O CAMPO DE EDICAO");
        this.validador.validacaoStringNulaOuVazia(atributo, "O CONTEUDO");
        String campoDeEdicaoFormatado = atributo.toUpperCase().trim();

        if (!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("O cpf digitado não está presente na lista de clientes.");
        }
        else if (campoDeEdicaoFormatado.equals("CPF")) {
            throw new IllegalArgumentException("O valor do CPF não pode ser alterado, é uma identificação única.");
        }
        else if (campoDeEdicaoFormatado.equals("NOME")) {
            this.clientes.get(cpf).setNome(novoValor);
        }
        else if (campoDeEdicaoFormatado.equals("LOCALIZACAO")) {
            this.clientes.get(cpf).setLocalizacao(novoValor);
        }
        else if (campoDeEdicaoFormatado.equals("EMAIL")) {
            this.clientes.get(cpf).setEmail(novoValor);
        }
        else {
            throw new IllegalArgumentException("Esse atributo passado não existe no sistema!");
        }
        return true;
    }

    /** Método responsável pela remoção de clientes
     * @param cpf para identificação de qual cliente será removido do sistema.
     * */
    public boolean removeCliente(String cpf) {
        this.validador.validacaoCPF(cpf);

        if (!this.clientes.containsKey(cpf)) {
          throw new IllegalArgumentException("O cpf digitado não está presente na lista de clientes.");
        }
        this.clientes.remove(cpf);
        return true;
    }
}
