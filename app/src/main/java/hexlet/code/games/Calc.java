package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    static final String RULES = "What is the result of the expression?";

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        String[] operators = {"+", "-", "*"};

        var operand1 = generateRandomNumber(0, 100);
        var operand2 = generateRandomNumber(0, 100);
        var operator = operators[generateRandomNumber(0, 3)];
        var rightAnswer = "" + calculateRightAnswer(operand1, operand2, operator);
        var question = "Question: " + operand1 + " " + operator + " " + operand2;

        return new String[]{question, rightAnswer};
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
