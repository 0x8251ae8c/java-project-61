package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUM_OF_ROUNDS = 3;

    public static void runGame(String gameTask, String[][] gameData) {
        var scanner = new Scanner(System.in);
        var userName = greeting();

        System.out.println(gameTask);

        for (var i = 0; i < NUM_OF_ROUNDS; i += 1) {
            var question = gameData[i][0];
            var rightAnswer = gameData[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var userAnswer = scanner.nextLine();

            if (rightAnswer.equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + rightAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static String greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
