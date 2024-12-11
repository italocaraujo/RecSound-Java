package service;

import model.Genero;
import model.Musica;
import model.Usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.GeneroRepository;
import repository.IPlataformaStreaming;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // Define esta classe como um Bean gerenciado pelo Spring
public class PlataformaStreamingService {

    private final IPlataformaStreaming streamingRepository;
    private final GeneroRepository generoRepository;

    // Construtor com injeção de dependências
    public PlataformaStreamingService(IPlataformaStreaming streamingRepository, GeneroRepository generoRepository) {
        this.streamingRepository = Objects.requireNonNull(streamingRepository, "O repositório de streaming é obrigatório.");
        this.generoRepository = Objects.requireNonNull(generoRepository, "O repositório de gêneros é obrigatório.");
    }

    // Serviço para adicionar uma música com validação de entradas
    public void adicionarMusica(String titulo, String artista, String letra, String nomeGenero) {
        validarString(titulo, "O título da música é obrigatório.");
        validarString(artista, "O artista da música é obrigatório.");
        validarString(nomeGenero, "O nome do gênero é obrigatório.");

        Genero genero = generoRepository.buscarGenero(nomeGenero)
                .orElseThrow(() -> new IllegalArgumentException("Gênero não encontrado: " + nomeGenero));

        Musica musica = new Musica(titulo, artista, letra, genero);
        streamingRepository.adicionarMusica(musica);
    }

    // Serviço para listar todas as músicas
    public List<Musica> listarMusicas() {
        return streamingRepository.listarMusicas();
    }

    // Serviço para buscar uma música pelo título com validação
    public Musica buscarMusica(String titulo) {
        validarString(titulo, "O título da música é obrigatório.");
        return Optional.ofNullable(streamingRepository.buscarMusica(titulo))
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada: " + titulo));
    }

    // Serviço para cadastrar um usuário
    public void cadastrarUsuario(String nome) {
        validarString(nome, "O nome do usuário é obrigatório.");
        Usuario usuario = new Usuario(nome);
        streamingRepository.cadastrarUsuario(usuario);
    }

    // Serviço para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return streamingRepository.listarUsuarios();
    }

    // Serviço para listar todos os gêneros
    public List<Genero> listarGeneros() {
        return generoRepository.listarGeneros();
    }

    // Método utilitário para validação de strings
    private void validarString(String valor, String mensagemErro) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensagemErro);
        }
    }
}
