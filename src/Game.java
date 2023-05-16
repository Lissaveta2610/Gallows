package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Scanner scanner = new Scanner(System.in);
    private final Hangman hangman = new Hangman();
    private final char LETTER_MASK = '_';
    private int lifes = 7;
    private final String secret;
    private final List<Character> woldMask = new ArrayList<>();
    private final List<Character> wronglyGuessedLetters = new ArrayList<>();

    public Game (String word) {
        secret = word.toLowerCase();
        for (int i = 0; i < secret.length(); i++) {
            woldMask.add(LETTER_MASK);
        }
    }

    public void startGame() {
        printProgress();
        int count = 0;
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Введите букву: ");
            } else {
                char userVariant = input.charAt(0);
                if (wronglyGuessedLetters.contains(userVariant) || woldMask.contains(userVariant)) {
                    System.out.println("Эту букву ты уже вводил, проробуй снова! " +
                            "\nВведите букву: ");
                } else {
                    if (openCorrectLetter(userVariant)) {
                        System.out.println("Правильно!");
                        if (!woldMask.contains(LETTER_MASK)) {
                            System.out.println("Вы выйграли!");
                            break;
                        }
                    } else {
                        System.out.println("Неправильно!");
                        count++;
                        hangman.addElementToGallow(count);
                        wronglyGuessedLetters.add(userVariant);
                        if (--lifes == 0) {
                            System.out.println("\nВы проиграли...");
                            break;
                        }
                    }
                    printProgress();
                }
            }
        }
        System.out.println("Это было слово: " + secret);
    }

    private boolean openCorrectLetter(char userVariant) {
        boolean isGuessed = false;
        for (int index = secret.indexOf(userVariant); index >= 0;
             index = secret.indexOf(userVariant, index + 1)) {
            woldMask.set(index, userVariant);
            isGuessed = true;
        }
        return isGuessed;
    }

    private void setWoldMask() {
        System.out.print("Слово: ");
        for (char letter : woldMask) {
            System.out.print(" " + letter);
        }
    }

    private void countRemainingLifes() {
        System.out.println("\nОставшиеся жизни: ");
        for (int i = 1; i <= lifes; i++) {
            System.out.print("* ");
        }
    }

    private void printProgress() {
        setWoldMask();
        countRemainingLifes();
        System.out.println("\nВведите букву: ");
    }
}
