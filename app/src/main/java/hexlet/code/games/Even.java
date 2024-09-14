package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    static String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            gameData[i] = generateRound();
        }

        Engine.runGame(rules, gameData);
    }

    private static String[] generateRound() {
        String[] round = new String[2];

        var randomNumber = generateRandomNumber();
        var rightAnswer = isEven(randomNumber) ? "yes" : "no";

        round[0] = "Question: " + randomNumber;
        round[1] = rightAnswer;

        return round;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
