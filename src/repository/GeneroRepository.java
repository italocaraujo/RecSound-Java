package repository;

import model.Genero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GeneroRepository {
    private final List<Genero> generos = new ArrayList<>();

    public void adicionarGenero(Genero genero) {
        generos.add(genero);
    }

    public Optional<Genero> buscarGenero(String nome) {
        return generos.stream()
                .filter(genero -> genero.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public List<Genero> listarGeneros() {
        System.out.println("Gêneros disponíveis:");
        generos.forEach(System.out::println);
        return null;
    }
}
