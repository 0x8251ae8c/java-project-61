package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static final int NUM_OF_ROUNDS = 3;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What is the result of the expression?");


        for (var i = 0; i < NUM_OF_ROUNDS; i += 1) {
            var round = generateRound();
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

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    private static String[] generateRound() {
        String[] operators = {"+", "-", "*"};
        String[] round = new String[2];

        var operand1 = generateRandomNumber(0, 100);
        var operand2 = generateRandomNumber(0, 100);
        var operator = operators[generateRandomNumber(0, 3)];
        var rightAnswer = calculateRightAnswer(operand1, operand2, operator);

        round[0] = "Question: " + operand1 + " " + operator + " " + operand2;
        round[1] = "" + rightAnswer;

        return round;
    }

    private static int calculateRightAnswer(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> throw new RuntimeException("Unknown operand");
        };
    }
}
