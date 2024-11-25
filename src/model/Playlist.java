package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String nome;  // Declarado como final
    private final List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void listarMusicas() {
        System.out.println("Playlist: " + nome);
        for (Musica musica : musicas) {
            System.out.println("\n" + musica);
        }
    }

    public String getNome() {
        return nome;
    }
}
