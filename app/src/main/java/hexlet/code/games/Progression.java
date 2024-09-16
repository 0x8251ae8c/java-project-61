package hexlet.code.games;

import hexlet.code.Engine;
import java.util.StringJoiner;

public class Progression {
    static final String RULES = "What number is missing in the progression?";
    static final int PROGRESSION_SIZE = 10;

    public static void run() {
        var rounds = Engine.generateGameData();

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var progressionStartNumber = generateRandomNumber(0, 100);
        var progressionStep = generateRandomNumber(1, 10);
        var progression = generateProgression(progressionStartNumber, progressionStep);
        var hiddenValueIndex = generateRandomNumber(0, PROGRESSION_SIZE - 1);
        var question = generateQuestion(progression, hiddenValueIndex);
        var rightAnswer = "" + progression[hiddenValueIndex];

        return new String[]{question, rightAnswer};
    }

    private static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    private static int[] generateProgression(int first, int step) {
        var numbers = new int[PROGRESSION_SIZE];
        numbers[0] = first;
        for (var i = 1; i < PROGRESSION_SIZE; i += 1) {
            numbers[i] = numbers[i - 1] + step;
        }
        return numbers;
    }

    private static String generateQuestion(int[] progression, int hiddenValueIndex) {
        var sj = new StringJoiner(" ");
        for (var i = 0; i < progression.length; i += 1) {
            var item = (i == hiddenValueIndex) ? ".." : Integer.toString(progression[i]);
            sj.add(item);
        }
        return sj.toString();
    }
}
