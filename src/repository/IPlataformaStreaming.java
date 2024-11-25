package repository;

import model.Musica;
import model.Usuario;
import java.util.List;

public interface IPlataformaStreaming {
    void adicionarMusica(Musica musica);
    void removerMusica(String titulo);
    Musica buscarMusica(String titulo);
    List<Musica> listarMusicas();

    void cadastrarUsuario(Usuario usuario);
    void removerUsuario(String nome);
    Usuario buscarUsuario(String nome);
    List<Usuario> listarUsuarios();
}

