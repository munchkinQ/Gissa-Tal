package Gissa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double randomNumber = (Math.random() * 100 + 1);

        int number = (int) (randomNumber);

        int timesPlayed = 0;

        boolean play = true;

        boolean isUserInputCorrect = false;

        while (play == true) { // == play is there for clarity, clean code

            isUserInputCorrect = false; // resetting value for subsequent times played

            System.out.println("Guess a number between 1 and 100" /* + number */);

            try {

                int userGuess = scanner.nextInt();
                scanner.nextLine(); // fixed scanner bug
                if (number > userGuess) {
                    System.out.println("Your guess it too low!");
                    timesPlayed++;
                    continue;
                } else if (number < userGuess) {
                    System.out.println("Your guess is too high!");
                    timesPlayed++;
                    continue;
                } else if (number == userGuess) {
                    timesPlayed++;
                    System.out.println("Your guess is correct! It took you " + timesPlayed
                            + " tries to figure out the right number.");

                    while (isUserInputCorrect == false) {

                        System.out.println("Would you like to play again? Yes/No");
                        String answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {
                            randomNumber = (Math.random() * 100 + 1); // setting a new random number
                            number = (int) (randomNumber);
                            timesPlayed = 0; // resetting the counter
                            isUserInputCorrect = true;
                            continue;
                        } else if (answer.equalsIgnoreCase("no")) {
                            System.out.println("Okay, thanks for playing!");
                            play = false;
                            isUserInputCorrect = true;
                            break;
                        } else {
                            System.out.println("Answer input incorrectly, please answer in Yes/No format.");
                            continue;
                        }
                    }
                }
            }

            catch (InputMismatchException e) {
                // preventing crashes in case of string input, etc

                System.out.println("Answer input incorrectly, please input your guess in integers");
                scanner.nextLine();
            }
        }

        scanner.close();

    }
}
