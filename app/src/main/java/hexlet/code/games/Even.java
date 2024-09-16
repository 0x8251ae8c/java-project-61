package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int MIN_RANDOM_NUMBER = 1;
    static final int MAX_RANDOM_NUMBER = 100;

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var randomNumber = generateRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        var rightAnswer = isEven(randomNumber) ? "yes" : "no";
        var question = "Question: " + randomNumber;

        return new String[]{question, rightAnswer};
    }

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
