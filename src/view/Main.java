package view;

import controller.PlataformaStreamingController;
import model.Genero;
import repository.GeneroRepository;
import repository.PlataformaStreamingRepository;
import service.PlataformaStreamingService;

public class Main {
    public static void main(String[] args) {
        PlataformaStreamingRepository streamingRepo = new PlataformaStreamingRepository();
        GeneroRepository generoRepo = new GeneroRepository();
        PlataformaStreamingService streamingService = new PlataformaStreamingService(streamingRepo, generoRepo);
        PlataformaStreamingController controller = new PlataformaStreamingController(streamingService);

        // Criando gêneros
        generoRepo.adicionarGenero(new Genero("Pop", "Música popular"));
        generoRepo.adicionarGenero(new Genero("Rock", "Música de rock"));

        // Cadastrando usuários
        controller.cadastrarUsuario("Italo");

        // Adicionando músicas
        controller.adicionarMusica("Bohemian Rhapsody", "Queen", "Is this the real life...", "Rock");
        controller.adicionarMusica("Blinding Lights", "The Weeknd", "I said, ooooh, I'm blinded...", "Pop");

        // Listando músicas
        controller.listarMusicas();
    }
}
