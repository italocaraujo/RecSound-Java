package view;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import model.Genero;
import org.springframework.context.annotation.ComponentScan;
import repository.GeneroRepository;
import service.PlataformaStreamingService;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"view", "service", "repository", "controller", "model"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(
            PlataformaStreamingService streamingService,
            GeneroRepository generoRepo
    ) {
        return args -> {
            // Criando gêneros pré-definidos
            generoRepo.adicionarGenero(new Genero("Pop", "Música popular"));
            generoRepo.adicionarGenero(new Genero("Rock", "Música de rock"));

            // Menu interativo
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n=== Plataforma de Streaming ===");
                System.out.println("1. Cadastrar Usuário");
                System.out.println("2. Adicionar Música");
                System.out.println("3. Listar Músicas");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao;
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Por favor, insira um número.");
                    continue;
                }

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();
                        try {
                            streamingService.cadastrarUsuario(nomeUsuario);
                            System.out.println("Usuário cadastrado com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.print("Digite o título da música: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Digite o artista: ");
                        String artista = scanner.nextLine();
                        System.out.print("Digite a letra (opcional, pressione Enter para pular): ");
                        String letra = scanner.nextLine();
                        System.out.print("Digite o gênero da música: ");
                        String nomeGenero = scanner.nextLine();
                        try {
                            streamingService.adicionarMusica(titulo, artista, letra.isBlank() ? null : letra, nomeGenero);
                            System.out.println("Música adicionada com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar música: " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println("\n=== Lista de Músicas ===");
                        streamingService.listarMusicas().forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.println("Encerrando o programa. Até logo!");
                        return; // Sai do programa
                    }
                    default -> System.out.println("Opção inválida! Por favor, escolha entre 1 e 4.");
                }
            }
        };
    }
}
