package repository;

import model.Musica;
import model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Informa ao Spring que esta classe deve ser gerenciada como um Bean
public class PlataformaStreamingRepository implements IPlataformaStreaming {

    // Listas para armazenar dados em memória
    private final List<Musica> musicas = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    @Override
    public void removerMusica(String titulo) {
        musicas.removeIf(musica -> musica.getTitulo().equalsIgnoreCase(titulo));
    }

    @Override
    public Musica buscarMusica(String titulo) {
        return musicas.stream()
                .filter(musica -> musica.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Musica> listarMusicas() {
        return new ArrayList<>(musicas);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void removerUsuario(String nome) {
        usuarios.removeIf(usuario -> usuario.getNome().equalsIgnoreCase(nome));
    }

    @Override
    public Usuario buscarUsuario(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
