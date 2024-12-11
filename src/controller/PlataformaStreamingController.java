package controller;

import model.Musica;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PlataformaStreamingService;

import java.util.List;

@RestController // Define esta classe como um controlador REST gerenciado pelo Spring
@RequestMapping("/api/streaming") // Define o prefixo para os endpoints deste controlador
public class PlataformaStreamingController {

    private final PlataformaStreamingService streamingService;

    @Autowired // Injeta automaticamente o serviço no construtor
    public PlataformaStreamingController(PlataformaStreamingService streamingService) {
        this.streamingService = streamingService;
    }

    // Endpoint para adicionar uma música
    @PostMapping("/musicas")
    public void adicionarMusica(@RequestParam String titulo, @RequestParam String artista,
                                @RequestParam(required = false) String letra, @RequestParam String nomeGenero) {
        streamingService.adicionarMusica(titulo, artista, letra, nomeGenero);
    }

    // Endpoint para listar músicas
    @GetMapping("/musicas")
    public List<Musica> listarMusicas() {
        return streamingService.listarMusicas();
    }

    // Endpoint para cadastrar um usuário
    @PostMapping("/usuarios")
    public void cadastrarUsuario(@RequestParam String nome) {
        streamingService.cadastrarUsuario(nome);
    }

    // Endpoint para listar usuários
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return streamingService.listarUsuarios();
    }
}
