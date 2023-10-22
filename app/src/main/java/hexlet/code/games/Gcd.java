package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    public static void play() {
        var gameTask = "Find the greatest common divisor of given numbers.";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var number1 = getRandomNumber(1, 100);
            var number2 = getRandomNumber(1, 100);
            var question = Integer.toString(number1) + " " + Integer.toString(number2);
            var rightAnswer = gcd(number1, number2);
            gameData[i][0] = question;
            gameData[i][1] = Integer.toString(rightAnswer);
        }

        Engine.runGame(gameTask, gameData);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return (a + b);
    }
}
