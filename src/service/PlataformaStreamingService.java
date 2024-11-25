package service;

import model.Genero;
import model.Musica;
import model.Usuario;
import repository.GeneroRepository;
import repository.IPlataformaStreaming;

import java.util.List;
import java.util.Optional;

public class PlataformaStreamingService {
    private final IPlataformaStreaming streamingRepository;
    private final GeneroRepository generoRepository;

    public PlataformaStreamingService(IPlataformaStreaming streamingRepository, GeneroRepository generoRepository) {
        this.streamingRepository = streamingRepository;
        this.generoRepository = generoRepository;
    }

    // Serviço para adicionar uma música com validação
    public void adicionarMusica(String titulo, String artista, String letra, String nomeGenero) {
        if (titulo == null || titulo.isEmpty() || artista == null || artista.isEmpty()) {
            throw new IllegalArgumentException("Título e artista da música são obrigatórios.");
        }

        Optional<Genero> generoOptional = generoRepository.buscarGenero(nomeGenero);
        if (generoOptional.isEmpty()) {
            throw new IllegalArgumentException("Gênero não encontrado: " + nomeGenero);
        }

        Genero genero = generoOptional.get();
        Musica musica = new Musica(titulo, artista, letra, genero);
        streamingRepository.adicionarMusica(musica);
    }

    // Serviço para listar músicas
    public List<Musica> listarMusicas() {
        return streamingRepository.listarMusicas();
    }

    // Serviço para buscar uma música por título
    public Musica buscarMusica(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("O título da música é obrigatório.");
        }

        Musica musica = streamingRepository.buscarMusica(titulo);
        if (musica == null) {
            throw new IllegalArgumentException("Música não encontrada: " + titulo);
        }
        return musica;
    }

    // Serviço para cadastrar um usuário
    public void cadastrarUsuario(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }

        Usuario usuario = new Usuario(nome);
        streamingRepository.cadastrarUsuario(usuario);
    }

    // Serviço para listar usuários
    public List<Usuario> listarUsuarios() {
        return streamingRepository.listarUsuarios();
    }

    // Serviço para listar gêneros
    public List<Genero> listarGeneros() {
        return generoRepository.listarGeneros();
    }
}
