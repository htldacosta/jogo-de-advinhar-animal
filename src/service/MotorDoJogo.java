package service;

import enums.Caracteristica;
import model.Animal;
import model.Jogador;
import repository.RepositorioAnimais;

import java.util.List;
import java.util.Scanner;

public class MotorDoJogo {

    private Scanner scanner;
    private Jogador jogador;
    private RepositorioAnimais repositorio;

    public MotorDoJogo(String nomeDoJogador) {
        this.scanner = new Scanner(System.in);
        this.jogador = new Jogador(nomeDoJogador);
        this.repositorio = new RepositorioAnimais();
    }

    public void iniciarPartida() {
        System.out.println("==================================================");
        System.out.println("Bem-vindo ao Jogo de Adivinhar Animais da GTV Systems!");
        System.out.println("Jogador: " + jogador.getNome());
        System.out.println("==================================================\n");

        // 1. Sorteamos 3 animais para os 3 rounds
        List<Animal> animaisDaPartida = repositorio.sortearAnimaisParaPartida(3);

        // 2. Loop FOR para controlar os Rounds
        for (int i = 0; i < animaisDaPartida.size(); i++) {
            System.out.println(">>> ROUND " + (i + 1) + " <<<");

            // Passamos o animal sorteado da vez para a lógica de round
            jogarRound(animaisDaPartida.get(i));
            System.out.println("--------------------------------------------------\n");
        }

        // 3. Fim do Jogo e Saída de Dados
        System.out.println("=== FIM DE JOGO ===");
        System.out.println("Pontuação final de " + jogador.getNome() + ": " + jogador.getPontuacaoTotal() + " pontos.");
    }

    private void jogarRound(Animal animal) {
        int pontosDaRodada = 10;
        int tentativas = 0;
        boolean acertou = false;

        // Loop WHILE para controlar as 3 chances do jogador
        while (tentativas < 3 && !acertou) {

            // Pegamos a dica (0, 1 ou 2) baseada no número da tentativa atual
            Caracteristica dicaEnum = animal.getDica(tentativas);

            // Passamos o Enum pelo Switch Case para gerar uma frase amigável
            String dicaFormatada = traduzirDica(dicaEnum);

            System.out.println("Dica " + (tentativas + 1) + " (Valendo " + pontosDaRodada + " pontos): Este animal " + dicaFormatada);
            System.out.print("Qual é o seu palpite? ");

            String palpite = scanner.nextLine().trim();

            // if/else para validar o palpite ignorando letras maiúsculas/minúsculas
            if (palpite.equalsIgnoreCase(animal.getNome())) {
                System.out.println("-> PARABÉNS! Você acertou e ganhou " + pontosDaRodada + " pontos!");
                jogador.adicionarPontos(pontosDaRodada); // Encapsulamento em ação!
                acertou = true; // Quebra o while
            } else {
                System.out.println("-> ERROU!");
                tentativas++; // Computa o erro

                // Regra da pontuação decrescente
                if (tentativas == 1) {
                    pontosDaRodada = 9;
                } else if (tentativas == 2) {
                    pontosDaRodada = 8;
                } else {
                    pontosDaRodada = 0; // Estourou as 3 tentativas
                }
            }
        }

        // Se saiu do while e não acertou, revela o animal
        if (!acertou) {
            System.out.println("\nQue pena! O round acabou e você não pontuou.");
            System.out.println("O animal era: " + animal.getNome().toUpperCase());
        }
    }

    private String traduzirDica(Caracteristica caracteristica) {
        switch (caracteristica) {
            case MAMIFERO: return "é um mamífero.";
            case AQUATICO: return "vive na água.";
            case AVE: return "é uma ave.";
            case REPTIL: return "é um réptil.";
            case CARNIVORO: return "se alimenta de carne.";
            case HERBIVORO: return "se alimenta de plantas.";
            case TEM_PELOS: return "possui o corpo coberto por pelos.";
            case BOTA_OVO: return "bota ovos.";
            case VENENOSO: return "possui veneno.";
            case ANIMAL_DOMESTICO: return "costuma ser domesticado por humanos.";
            case TEM_LISTRAS: return "tem listras pelo corpo.";
            case MUITO_PESADO: return "é conhecido por ser extremamente pesado.";
            case VOADOR: return "tem a capacidade de voar.";
            case PULA_ALTO: return "consegue dar grandes saltos.";
            case TEM_GARRAS: return "possui garras afiadas.";
            default: return "tem uma característica misteriosa.";
        }
    }



}
