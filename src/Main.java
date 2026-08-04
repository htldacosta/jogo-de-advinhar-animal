import service.MotorDoJogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu nome para começar: ");
        String nome = sc.nextLine();

        // Instanciamos o motor passando o nome do jogador
        MotorDoJogo motor = new MotorDoJogo(nome);

        // Damos o play no jogo!
        motor.iniciarPartida();

        sc.close();

        
    }


}