package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUM_OF_ROUNDS = 3;

    public static void runGame(String rules, String[][] gameData) {
        var scanner = new Scanner(System.in);
        var userName = greetUser(scanner);

        System.out.println(rules);

        for (var round : gameData) {
            System.out.println("Question: " + round[0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.toLowerCase().equals(round[1])) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + round[1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    static String greetUser(Scanner scanner) {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
