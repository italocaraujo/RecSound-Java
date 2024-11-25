package controller;

import model.Musica;
import model.Usuario;
import service.PlataformaStreamingService;

public class PlataformaStreamingController {
    private final PlataformaStreamingService streamingService;

    public PlataformaStreamingController(PlataformaStreamingService streamingService) {
        this.streamingService = streamingService;
    }

    public void adicionarMusica(String titulo, String artista, String letra, String nomeGenero) {
        streamingService.adicionarMusica(titulo, artista, letra, nomeGenero);
    }

    public void listarMusicas() {
        streamingService.listarMusicas().forEach(System.out::println);
    }

    public void cadastrarUsuario(String nome) {
        streamingService.cadastrarUsuario(nome);
    }

    public void listarUsuarios() {
        streamingService.listarUsuarios().forEach(usuario -> System.out.println(usuario.getNome()));
    }
}
