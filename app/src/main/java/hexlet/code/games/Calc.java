package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 100;

    public static void play() {
        var gameTask = "What is the result of the expression?";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        Character[] operations = {'+', '-', '*'};

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var operation = operations[getRandomNumber(0, 2)];
            var number1 = getRandomNumber(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            var number2 = getRandomNumber(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            var question = Integer.toString(number1) + " " + operation + " " + Integer.toString(number2);
            var rightAnswer = count(operation, number1, number2);
            gameData[i][0] = question;
            gameData[i][1] = Integer.toString(rightAnswer);
        }

        Engine.runGame(gameTask, gameData);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static int count(Character operation, int number1, int number2) {
        return switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> 0;
        };
    }
}
