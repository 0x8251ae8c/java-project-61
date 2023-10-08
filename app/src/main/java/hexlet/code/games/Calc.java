package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void play() {
        var gameTask = "What is the result of the expression?";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        Character[] operations = {'+', '-', '*'};

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var operation = operations[getRandomNumber(0, 2)];
            var number1 = getRandomNumber(0, 100);
            var number2 = getRandomNumber(0, 100);
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
