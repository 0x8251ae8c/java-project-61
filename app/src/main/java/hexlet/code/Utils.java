package hexlet.code;

public class Utils {
    static final int MIN_RANDOM_NUMBER = 0;
    static final int MAX_RANDOM_NUMBER = 100;

    public static int generateRandomNumber(int lowerRangeLimit, int upperRangeLimit) {
        var diff = upperRangeLimit - lowerRangeLimit;
        return (int) (lowerRangeLimit + Math.random() * diff);
    }

    public static int generateRandomNumber() {
        return generateRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
