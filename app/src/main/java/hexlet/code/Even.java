package hexlet.code;

import java.util.Scanner;

public class Even {
    public static boolean play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        String[] answers = {"yes", "no"};

        for (var i = 0; i < 3; i += 1) {
            var randomNumber = Even.getRandomNumber(0, 100);
            System.out.println("Question: " + randomNumber);
            var rightAnswer = answers[randomNumber % 2];
            System.out.print("Your answer: ");
            var userAnswer = scanner.nextLine();
            if (rightAnswer.equalsIgnoreCase(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + rightAnswer + "'.");
                return false;
            }
        }
        return true;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
