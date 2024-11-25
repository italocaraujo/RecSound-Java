package model;

public class Genero {
    private final String nome;
    private final String descricao;

    public Genero(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + ": " + descricao;
    }
}
