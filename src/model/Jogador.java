package model;

public class Jogador {
    private String nome;
    private int pontuacaoTotal;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacaoTotal = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontuacaoTotal += pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

}
