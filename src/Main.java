package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hangman hangman = new Hangman();
        WordGenerator wordGenerator = new WordGenerator();
        String answer = "да";
        System.out.println("Игра Виселица\n");
        while (!answer.equals("нет")) {
            if (answer.equals("да")) {
                System.out.println(hangman.makeNewGallow());
                String word = wordGenerator.generateWord();
                Game game = new Game(word);
                game.startGame();
            }
            System.out.println("\nХотите продолжить? да/нет");
            answer = scanner.nextLine();
        }
    }
}