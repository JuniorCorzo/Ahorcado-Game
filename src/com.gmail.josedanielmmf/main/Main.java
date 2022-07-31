package com.gmail.josedanielmmf.main;

import com.gmail.josedanielmmf.game.AhorcadoGame;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        
        AhorcadoGame ahorcadoGame = new AhorcadoGame();

        int opciones = 1;
        while (opciones != 0){
            System.out.println("Bienvenido al juego del ahoracado"
                    + "\nPara jugar oprima 1"
                    + "\nPara salir oprima 0");
            opciones = Integer.parseInt(console.nextLine());
            switch (opciones) {
                case 0 -> {
                    System.out.println("Gracias por jugar");
                    break;
                }
                case 1 -> {
                    System.out.println("Vamo a jugar");
                    ahorcadoGame.setWord();
                    System.out.println("\nEscriba una letra");
                    String letter = console.nextLine();
                    while (!letter.equalsIgnoreCase("abandonar")) {
                        if (letter.equalsIgnoreCase(ahorcadoGame.getWord())) {
                            System.out.println("Bien lo salvaste del suicidio\n");
                            break;
                        }

                        String game = ahorcadoGame.game(letter);
                        System.out.println(game);

                        if(ahorcadoGame.getWord().equalsIgnoreCase(ahorcadoGame.getResultWorld())){
                            System.out.println("Bien lo salvaste del suicidio\n");
                            break;
                        }

                        if (ahorcadoGame.getError()){
                            if (ahorcadoGame.getErrors() == 11){
                                System.out.println("Perdiste el man se suicido");
                                break;
                            }
                            System.out.println("Fallaste te quedan " + ((ahorcadoGame.getErrors() - 11) * -1) + " intentos\n");
                        }

                        letter = console.nextLine();
                    }
                }
            }
        }

    }
}
