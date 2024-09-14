package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    static String rules = "What is the result of the expression?";

    public static void run() {
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            gameData[i] = generateRound();
        }

        Engine.runGame(rules, gameData);
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

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
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
