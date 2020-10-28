import java.io.*;
import java.util.Scanner;
import java.util.Set;

/**
 * This is a Setup Class that is used in Yahtzee.java
 * CPSC 224-02, Spring 2020
 * Programming Assignment #2
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */
public class Setup {

    private static int num_rolls; //numrolls

    /**
     * accessor method
     *
     * @return num_rolls
     */
    public static int getNumRolls()
    {
        return num_rolls;
    }

    /**
     * mutator method
     *
     * @param rolls sets rolls
     */
    public static void setNumRolls(int rolls)
    {
        num_rolls = rolls; //mutator
    }

    /**
     * this function is the start of the game
     * it allows the user to change the configuration
     *
     * @throws IOException file input/output
     */
    public static void startGame() throws IOException
    {
        char change = 'n';
        Scanner scan = new Scanner(System.in);
        Files.ReadInFile(); //i/o
        System.out.println("You are playing with " + Hand.getNumDice() + " " + Dice.getNumSides() + "-sided dice");
        System.out.println("You get " + num_rolls + " rolls per hand");
        System.out.println();
        System.out.println("Enter 'y' if you would like to change the configuration \nor 'n' to keep the same configuration.");
        Scanner scanner = new Scanner(System.in);
        change = scanner.next().charAt(0);
        if(change == 'y') //they want to change the configuration
        {
            Writer wr = new FileWriter("src/yahtzeeConfig.txt"); //variable to file
            int num; // number being written

            // Changes die
            System.out.println("Enter the number of sides on each die ");
            num = scan.nextInt();
            Dice.setNumSides(num);
            wr.write(String.valueOf(num));
            wr.append(" ");

            //Changes die
            System.out.println("Enter the number of dice in play ");
            num = scan.nextInt();
            Hand.setNumDice(num);
            wr.write(String.valueOf(num));
            wr.append(" ");

            //Changes Turns
            System.out.println("Enter the number of rolls per hand ");
            num = scan.nextInt();
            Setup.setNumRolls(num);
            wr.write(String.valueOf(num));
            wr.append(" ");
            wr.close();
        }
    }
}
