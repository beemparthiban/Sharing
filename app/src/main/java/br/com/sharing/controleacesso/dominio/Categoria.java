package br.com.sharing.controleacesso.dominio;

public enum Categoria {
    FERRAMENTAS("Ferramentas"), LIVROS ("Livros"), JOGOS ("Jogos"), COZINHA("Cozinha"), VIAGEM("Viagem"), OUTROS("Outros");

    private String descricao;

    Categoria(String descricao){this.descricao = descricao;}

    @Override
    public String toString() {
        return this.descricao;
    }
}
