package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        var rounds = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var randomNumber = Utils.generateRandomNumber();
        var rightAnswer = isEven(randomNumber) ? "yes" : "no";
        var question = "" + randomNumber;

        return new String[]{question, rightAnswer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
