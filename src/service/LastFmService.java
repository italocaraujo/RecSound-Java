package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class LastFmService {

    @Value("${lastfm.api.key}")
    private String apiKey;

    @Value("${lastfm.api.url}")
    private String baseUrl;

    private final OkHttpClient httpClient = new OkHttpClient();

    public JsonObject buscarArtista(String nomeArtista) {
        String url = baseUrl + "?method=artist.getinfo&artist=" + nomeArtista + "&api_key=" + apiKey + "&format=json";

        Request request = new Request.Builder().url(url).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return JsonParser.parseString(response.body().string()).getAsJsonObject();
            } else {
                throw new RuntimeException("Erro na chamada à API: " + response.code());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar artista: " + e.getMessage(), e);
        }
    }
}
