package repository;

import model.Animal;
import enums.Caracteristica;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RepositorioAnimais {
    private List<Animal> bancoDeAnimais;

    public RepositorioAnimais() {
        this.bancoDeAnimais = new ArrayList<>();
        carregarAnimais();
    }

    public void carregarAnimais() {
        bancoDeAnimais.add(new Animal("Leão", Caracteristica.MAMIFERO, Caracteristica.CARNIVORO, Caracteristica.TEM_PELOS));
        bancoDeAnimais.add(new Animal("Baleia Azul", Caracteristica.MAMIFERO, Caracteristica.AQUATICO, Caracteristica.MUITO_PESADO));
        bancoDeAnimais.add(new Animal("Pinguim", Caracteristica.AVE, Caracteristica.AQUATICO, Caracteristica.BOTA_OVO));
        bancoDeAnimais.add(new Animal("Cachorro", Caracteristica.MAMIFERO, Caracteristica.ANIMAL_DOMESTICO, Caracteristica.TEM_PELOS));
        bancoDeAnimais.add(new Animal("Cobra", Caracteristica.REPTIL, Caracteristica.CARNIVORO, Caracteristica.VENENOSO));
        bancoDeAnimais.add(new Animal("Tigre", Caracteristica.MAMIFERO, Caracteristica.CARNIVORO, Caracteristica.TEM_LISTRAS));
        bancoDeAnimais.add(new Animal("Elefante", Caracteristica.MAMIFERO, Caracteristica.HERBIVORO, Caracteristica.MUITO_PESADO));
        bancoDeAnimais.add(new Animal("Águia", Caracteristica.AVE, Caracteristica.VOADOR, Caracteristica.CARNIVORO));
        bancoDeAnimais.add(new Animal("Sapo", Caracteristica.AQUATICO, Caracteristica.PULA_ALTO, Caracteristica.VENENOSO));
        bancoDeAnimais.add(new Animal("Gato", Caracteristica.MAMIFERO, Caracteristica.ANIMAL_DOMESTICO, Caracteristica.TEM_GARRAS));
        bancoDeAnimais.add(new Animal("Canguru", Caracteristica.MAMIFERO, Caracteristica.HERBIVORO, Caracteristica.PULA_ALTO));
        bancoDeAnimais.add(new Animal("Jacaré", Caracteristica.REPTIL, Caracteristica.AQUATICO, Caracteristica.CARNIVORO));
        bancoDeAnimais.add(new Animal("Cavalo", Caracteristica.MAMIFERO, Caracteristica.HERBIVORO, Caracteristica.ANIMAL_DOMESTICO));
        bancoDeAnimais.add(new Animal("Morcego", Caracteristica.MAMIFERO, Caracteristica.VOADOR, Caracteristica.TEM_PELOS));
        bancoDeAnimais.add(new Animal("Ornitorrinco", Caracteristica.MAMIFERO, Caracteristica.AQUATICO, Caracteristica.BOTA_OVO));


    }

    public List<Animal> sortearAnimaisParaPartida(int quantidadeDeRounds) {

        List<Animal> animaisSorteados = new ArrayList<>(bancoDeAnimais);

        Collections.shuffle(animaisSorteados);

        return animaisSorteados.subList(0, quantidadeDeRounds);
    }
}
