package Gissa;

import java.util.Scanner; //importing scanner for later use

public class app {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //setting up scanner to take in user input
        
        double randomNumber = (Math.random() * 100 + 1); //introducing the variable and setting it's value

        int number = (int) (randomNumber); //changing the variable from a double into an int

        int timesPlayed = 0; //setting up the variable for storing how many times the user has guessed

        boolean play = true;

        while (play == true) {
            
            System.out.println("Guess a number between 1 and 100");
            int userGuess = scanner.nextInt(); //userGuess is now the variable that stores the guessed number

            if (number > userGuess) {
            System.out.println("Your guess it too low!");
            timesPlayed++; //incrementing the variable that will tell the user how many guesses it took
            continue;
        }
            else if (number < userGuess) {
                System.out.println("Your guess is too high!");
                timesPlayed++;
                continue;
            } else if (number == userGuess) {
                System.out.println("Your guess is correct! It took you " + timesPlayed + " tries to figure out the right number.");
                System.out.println("Would you like to play again? Yes/No");
                scanner.nextLine(); //encountered scanner bug
                String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")) {
                        randomNumber = (Math.random() * 100 + 1); //setting a new random number
                        number = (int) (randomNumber);
                        timesPlayed = 0; //resetting the counter
                        continue;
                    } else if (answer.equalsIgnoreCase("no")) {
                        play = false;
                        break;
                    } else {
                        System.out.println("Answer incorrectly input, starting over");
                        continue; //will need to be modified so that the question is asked again, not restarted
                    }
                
            } else { //this does not account for an inputed string
                System.out.println("Answer incorrectly input, starting over");
                continue;
            }

        } scanner.close(); //closing scanner to prevent resource leak
        
        
    }

}
