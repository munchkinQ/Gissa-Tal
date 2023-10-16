package Gissa;

import java.util.InputMismatchException; //importing tool to prevent crashes in case of string input when an integer is expected
import java.util.Scanner; //importing scanner for later use

public class app {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // setting up scanner to take in user input

        double randomNumber = (Math.random() * 100 + 1); // introducing the variable and setting it's value

        int number = (int) (randomNumber); // changing the variable from a double into an int

        int timesPlayed = 0; // setting up the variable for storing how many times the user has guessed

        boolean play = true;

        boolean isUserInputCorrect = false; // setting values to check if user input is input correctly

        while (play == true) { // == play is there for clarity

            isUserInputCorrect = false; // resetting value for subsequent times played

            System.out.println("Guess a number between 1 and 100" /* + number */);

            try { // try catch for incorrect inputs

                int userGuess = scanner.nextInt(); // userGuess is now the variable that stores the guessed number
                scanner.nextLine(); // fixed scanner bug here instead, now it won't interfere on replays

                if (number > userGuess) {
                    System.out.println("Your guess it too low!");
                    timesPlayed++; // incrementing the variable that will tell the user how many guesses it took
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
                        // scanner.nextLine(); //encountered scanner bug, 2nd time around it doesn't
                        // bug, however...
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
                scanner.nextLine(); // consuming this one too, in case of scanner bug
            }
        }

        scanner.close(); // closing scanner to prevent resource leak

    }
}
