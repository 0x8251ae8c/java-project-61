package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var randomNumber = generateRandomNumber();
        var rightAnswer = isEven(randomNumber) ? "yes" : "no";
        var question = "Question: " + randomNumber;

        return new String[]{question, rightAnswer};
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
