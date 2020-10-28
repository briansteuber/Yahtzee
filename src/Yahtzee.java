import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * This program simulates a  Yahtzee game
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/28/20
 */

public class Yahtzee {
    /**
     * Brain of the program
     * Tests the messages outside of this function
     *
     * @param args command line args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        char playAgain = 'y'; //replay variable
        while (playAgain == 'y')
        {
            Setup.startGame(); //starts game
            Scorecard.setArraySize(); //sets size
            Hand hand1 = new Hand(); //makes a hand object
            System.out.println();
            Scanner dieKept = new Scanner(System.in); // kept
            Scanner scanner = new Scanner(System.in); // scanner object
            Scorecard.inItGScore(); //sets array
            int gameC = 0; //counter
            while (gameC < Scorecard.getArraySize())
            {
                char show; // s variable
                System.out.println("'s' - See Your Scorecard or 'n' to roll");
                show = scanner.next().charAt(0); //stored
                if (show == 's') {
                    Scorecard.showEntire(hand1); //display board
                }
                Scorecard.inItRScore(); //array
                char[] keep = new char[Hand.getNumDice()]; //kept die
                for (int dieNumber = 0; dieNumber < Hand.getNumDice(); dieNumber++)
                {
                    keep[dieNumber] = 'n';
                }
                int turn = 1;
                while (turn < Setup.getNumRolls())
                {
                    if (turn == 1)
                    {
                        for (int i = 0; i < Hand.getNumDice(); i++)
                            hand1.theDice[i] = Dice.rollDie(); // rolls die
                    }
                    System.out.println();
                    System.out.print("Your roll was: ");
                    hand1.showHand(); // shows roll
                    System.out.println();
                    System.out.print("enter dice to keep (y or n): ");
                    String keepT; //kept string
                    keepT = dieKept.next(); // variable
                    for (int i = 0; i < Hand.getNumDice(); i++)
                    {
                        keep[i] = keepT.charAt(i); // storing
                    }
                    for (int dieNumber = 0; dieNumber < Hand.getNumDice(); dieNumber++)
                    {
                        if (keep[dieNumber] == 'n')
                        {
                            hand1.theDice[dieNumber] = hand1.reRoll(hand1.theDice[dieNumber]); // reroll
                        }
                    }
                    turn++;
                }
                // last roll of the hand
                System.out.println();
                System.out.print("Your roll was: ");
                hand1.showHand();
                hand1.sortHand(hand1.theDice);
                System.out.println();
                System.out.print("Here is your sorted hand: ");
                hand1.showHand();
                System.out.println();
                Scorecard.upperCard(hand1);
                Scorecard.lowerCard(hand1);
                LowerScorecard.lowerCard();
                int line; //inputed from user
                System.out.println();
                System.out.print("Enter the line to score: ");
                line = scanner.nextInt(); // score
                Scorecard.pickLine(line); // variable
                gameC += 1;
            }

            int totalUpper = Score.totalUpperHand();
            int bonus;
            int totalLower = Score.totalLowerHand();
            int totalGame;
            if (totalUpper >= Score.calculateBonus()) // bonus
            {
                bonus = 35;
            }
            else
            {
                bonus = 0;
            }
            totalGame = totalUpper + totalLower + bonus; // total score
            System.out.println();
            System.out.println("Great work! You finished playing Yahtzee!");
            System.out.println();
            System.out.println("Here are the total scores: ");
            System.out.println("---------------");
            System.out.println("Upper Card:  " + totalUpper);
            System.out.println("Bonus (" + Score.calculateBonus() + "):  " + bonus);
            System.out.println("Total Upper: " + (totalUpper + bonus));
            System.out.println("Lower Card:  " + totalLower);
            System.out.println("---------------");
            System.out.println("Game Total:  " + totalGame);
            System.out.println();
            System.out.println("Enter 'y' to play again or anything else to quit: ");
            playAgain = scanner.next().charAt(0); // playagain??
        }
    }
}
