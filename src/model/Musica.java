package model;

public class Musica {
    private final String titulo;
    private final String artista;
    private final String letra;
    private final Genero genero;

    public Musica(String titulo, String artista, String letra, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.letra = letra;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getLetra() {
        return letra;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + genero.getNome() + ")";
    }
}

