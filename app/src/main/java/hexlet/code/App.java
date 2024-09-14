package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                System.out.println();
                System.out.println("Welcome to the Brain Games!");
                System.out.print("May I have your name? ");
                String userName = scanner.next();
                System.out.println("Hello, " + userName + "!");
                break;
            case 2:
                Even.run();
                break;
            case 3:
                Calc.run();
                break;
            default:
                break;
        }
    }
}
