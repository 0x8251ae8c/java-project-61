package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX = 100;

    public static void play() {
        var gameTask = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        String[] answers = {"yes", "no"};

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var randomNumber = getRandomNumber(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            gameData[i][0] = Integer.toString(randomNumber);
            var rightAnswer = answers[randomNumber % 2];
            gameData[i][1] = rightAnswer;
        }

        Engine.runGame(gameTask, gameData);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
