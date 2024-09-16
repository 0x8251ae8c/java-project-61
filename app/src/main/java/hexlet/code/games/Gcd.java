package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var number1 = generateRandomNumber(1, 100);
        var number2 = generateRandomNumber(1, 100);
        var rightAnswer = "" + gcd(number1, number2);
        var question = "Question: " + number1 + " " + number2;

        return new String[]{question, rightAnswer};
    }

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    private static int gcd(int number1, int number2) {
        var minNumber = Math.min(number1, number2);
        for (var i = minNumber; i > 1; i -= 1) {
            if ((number1 % i == 0) && (number2 % i == 0)) {
                return i;
            }
        }
        return 1;
    }
}