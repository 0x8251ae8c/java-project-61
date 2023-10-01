package hexlet.code;

import java.util.Scanner;

public class App {
    private static String userName = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        var choice = scanner.nextInt();

        System.out.println();

        switch (choice) {
            case 1:
                greeting();
                break;
            case 2:
                playEven();
                break;
            default:
        }
    }

    private static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    private static void playEven() {
        greeting();

        if (Even.play()) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
