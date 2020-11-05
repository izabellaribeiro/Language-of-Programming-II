package util;

public class Validador {

    public void validacaoString(String string, String mensagem){
        validacaoStringNula(string, mensagem);
        validacaoStringVazia(string, mensagem);
    }

    private void validacaoStringNula(String string, String mensagem){
        if (string == null) {
            throw new NullPointerException(mensagem + " não pode ser Nula!");
        }
    }

    private void validacaoStringVazia(String string, String mensagem) {
        if ("".equals(string.trim())) {
            throw new IllegalArgumentException(mensagem + " não pode ser Vazia!");
        }
    }
}
