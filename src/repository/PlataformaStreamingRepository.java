package repository;

import model.Musica;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class PlataformaStreamingRepository implements IPlataformaStreaming {
    private final List<Musica> catalogo;
    private final List<Usuario> usuarios;

    public PlataformaStreamingRepository() {
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void adicionarMusica(Musica musica) {
        catalogo.add(musica);
    }

    @Override
    public void removerMusica(String titulo) {
        catalogo.removeIf(musica -> musica.toString().contains(titulo));
    }

    @Override
    public Musica buscarMusica(String titulo) {
        return catalogo.stream()
                .filter(musica -> musica.toString().contains(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Musica> listarMusicas() {
        return new ArrayList<>(catalogo);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void removerUsuario(String nome) {
        usuarios.removeIf(usuario -> usuario.getNome().equals(nome));
    }

    @Override
    public Usuario buscarUsuario(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
