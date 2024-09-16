package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var number = generateRandomNumber(1, 100);
        var question = "Question: " + number;
        var rightAnswer = isPrime(number) ? "yes" : "no";

        return new String[]{question, rightAnswer};
    }

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (var i = number / 2; i > 1; i -= 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
