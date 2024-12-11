package controller;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.LastFmService;

@RestController
@RequestMapping("/api/lastfm")
public class LastFmController {

    private final LastFmService lastFmService;

    @Autowired
    public LastFmController(LastFmService lastFmService) {
        this.lastFmService = lastFmService;
    }

    // Endpoint para buscar informações sobre um artista
    @GetMapping("/artista")
    public JsonObject buscarArtista(@RequestParam String nome) {
        return lastFmService.buscarArtista(nome);
    }
}
