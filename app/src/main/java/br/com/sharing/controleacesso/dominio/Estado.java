package br.com.sharing.controleacesso.dominio;

public enum Estado {
    DISPONIVEL("Disponível"), ALUGADO ("Alugado");

    private String descricao;

    Estado(String descricao){this.descricao = descricao;}

    @Override
    public String toString() {
        return this.descricao;
    }
}
