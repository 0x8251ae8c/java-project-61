package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final String RULES = "What number is missing in the progression?";
    static final int PROGRESSION_SIZE = 10;
    static final int MIN_STEP_VALUE = 1;
    static final int MAX_STEP_VALUE = 10;

    public static void run() {
        var rounds = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var progressionStartNumber = Utils.generateRandomNumber();
        var progressionStep = Utils.generateRandomNumber(MIN_STEP_VALUE, MAX_STEP_VALUE);
        var progression = generateProgression(progressionStartNumber, progressionStep, PROGRESSION_SIZE);
        var hiddenValueIndex = Utils.generateRandomNumber(0, PROGRESSION_SIZE - 1);
        var question = generateQuestion(progression, hiddenValueIndex);
        var rightAnswer = progression[hiddenValueIndex];

        return new String[]{question, rightAnswer};
    }

    private static String[] generateProgression(int first, int step, int size) {
        var progression = new String[size];

        for (var i = 0; i < size; i += 1) {
            progression[i] = Integer.toString(first + step * i);
        }
        return progression;
    }

    private static String generateQuestion(String[] progression, int hiddenValueIndex) {
        var items = progression.clone();
        items[hiddenValueIndex] = "..";
        return String.join(" ", items);
    }
}
