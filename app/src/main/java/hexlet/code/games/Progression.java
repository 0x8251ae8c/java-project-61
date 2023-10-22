package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void play() {
        var gameTask = "What number is missing in the progression?";
        var gameData = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < Engine.NUM_OF_ROUNDS; i += 1) {
            var progression = new String[10];
            var firstItem = getRandomNumber(1, 100);
            var step = getRandomNumber(1, 10);
            for (var j = 0; j < progression.length; j += 1) {
                progression[j] = Integer.toString(firstItem + j * step);
            }
            var randomItem = getRandomNumber(0, 9);
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
