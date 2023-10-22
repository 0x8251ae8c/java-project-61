package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX_10 = 10;
    private static final int RANDOM_NUMBER_MAX_100 = 100;
    private static final int STEP_MIN = 1;
    private static final int STEP_MAX = 100;
    private static final int PROGRESSION_SIZE = 10;

    public static void play() {
        var gameTask = "What number is missing in the progression?";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var progression = new String[PROGRESSION_SIZE];
            var firstItem = getRandomNumber(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX_100);
            var step = getRandomNumber(STEP_MIN, STEP_MAX);
            for (var j = 0; j < progression.length; j += 1) {
                progression[j] = Integer.toString(firstItem + j * step);
            }
            var randomItem = getRandomNumber(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX_10) - 1;
            var rightAnswer = progression[randomItem];
            progression[randomItem] = "..";
            var question = String.join(" ", progression);
            gameData[i][0] = question;
            gameData[i][1] = rightAnswer;
        }

        Engine.runGame(gameTask, gameData);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
