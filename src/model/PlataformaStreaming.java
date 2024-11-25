package model;

import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    private final List<Musica> catalogo; // Declarado como final
    private final List<Usuario> usuarios; // Também pode ser final

    public PlataformaStreaming() {
        catalogo = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        catalogo.add(musica);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarMusicas() {
        System.out.println("\nCatálogo de Músicas:");
        for (Musica musica : catalogo) {
            System.out.println(musica);
        }
    }

    public List<Musica> getCatalogo() {
        return catalogo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
