package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static final int NUM_OF_ROUNDS = 3;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (var i = 0; i < NUM_OF_ROUNDS; i += 1) {
            var randomNumber = generateRandomNumber();
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            String rightAnswer = isEven(randomNumber) ? "yes" : "no";
            if (userAnswer.toLowerCase().equals(rightAnswer)) {
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

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
