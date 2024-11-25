package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nome; // Declarado como final
    private final List<Playlist> playlists;

    public Usuario(String nome) {
        this.nome = nome;
        this.playlists = new ArrayList<>();
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
    }

    public Playlist getPlaylist(String nome) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equals(nome)) {
                return playlist;
            }
        }
        return null;
    }

    public String getNome() {
        return nome; // O método getNome() retorna o nome do usuário
    }
}
