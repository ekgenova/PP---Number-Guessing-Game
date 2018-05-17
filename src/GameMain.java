import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {

        //Variables
        int maxNumber = 100;
        int minNumber = 0;
        int numberGuess = 50;
        int turns = 0;

        //Scanner
        Scanner userInput = new Scanner(System.in);
        System.out.println("Think of a number between 1-100and type y to start.");
        String higherLower = userInput.nextLine();

        //type y to begin game
        if (higherLower.equalsIgnoreCase("y")) {
            Boolean isPlaying = true;
            //game begins
            while (isPlaying) {
                System.out.println("Is your number " + numberGuess + " ? Higher/Lower/Correct");
                higherLower = userInput.nextLine();
                if (higherLower.equalsIgnoreCase("higher")) {
                    minNumber = numberGuess;
                    numberGuess = higher(minNumber, maxNumber, numberGuess);
                    turns = turns +1;
                } else if (higherLower.equalsIgnoreCase("lower")) {
                    maxNumber = numberGuess;
                    numberGuess = lower(minNumber, maxNumber, numberGuess);
                    turns = turns + 1;
                } else if (higherLower.equalsIgnoreCase("correct")) {
                    System.out.println("Your number is: " + numberGuess + "! I guessed your number in " + turns + " turns. Thanks for playing.");
                    isPlaying = false;
                }

                if (numberGuess == minNumber+1 && numberGuess == maxNumber-1){
                    System.out.println("Your number can only be: " + numberGuess + "! I guessed your number in " + turns + " turns. Thanks for playing.");
                    isPlaying = false;
                }
            }
        }
    }

    public static int higher(int numberMin, int numberMax, int numberGuess) {
        numberGuess = numberMin + (numberMax - numberMin) / 2;
        return numberGuess;
    }

    public static int lower(int numberMin, int numberMax, int numberGuess) {
        numberGuess = numberMax - (numberMax - numberMin) / 2;
        return numberGuess;
    }
}


