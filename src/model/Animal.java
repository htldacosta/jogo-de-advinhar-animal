package model;

import enums.Caracteristica;

import java.util.Arrays;
import java.util.List;

public class Animal {
    private String nome;
    private List<Caracteristica> dicas;

    public Animal(String nome, List<Caracteristica> dicas) {
        this.nome = nome;
        this.dicas = dicas;
    }

    public Animal(String nome, Caracteristica... caracteristicas) {
        this.nome = nome;

        this.dicas = Arrays.asList(caracteristicas);
    }

    public String getNome() {
        return nome;
    }

    public Caracteristica getDica(int indice) {
        if (indice >= 0 && indice < dicas.size()) {
            return dicas.get(indice);
        }
        return null;
    }
}
