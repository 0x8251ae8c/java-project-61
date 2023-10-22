package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void play() {
        var gameTask = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var number = getRandomNumber(1, 100);
            var question = Integer.toString(number);
            var rightAnswer = isPrimeNumber(number) ? "yes" : "no";
            gameData[i][0] = question;
            gameData[i][1] = rightAnswer;
        }

        Engine.runGame(gameTask, gameData);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i < number / 2; i += 1) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
