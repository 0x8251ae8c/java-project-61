package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    static final String RULES = "What is the result of the expression?";
    static final int MIN_RANDOM_NUMBER = 0;
    static final int MAX_RANDOM_NUMBER = 100;

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        String[] operators = {"+", "-", "*"};

        var operand1 = Engine.generateRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        var operand2 = Engine.generateRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        var operator = operators[Engine.generateRandomNumber(0, operators.length)];
        var rightAnswer = "" + calculateRightAnswer(operand1, operand2, operator);
        var question = "Question: " + operand1 + " " + operator + " " + operand2;

        return new String[]{question, rightAnswer};
    }

    private static int calculateRightAnswer(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> throw new RuntimeException("Unknown operator");
        };
    }
}
