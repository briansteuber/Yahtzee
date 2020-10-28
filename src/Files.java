import java.io.*;
import java.util.Scanner;
/**
 * This Files class is used in Yahtzee.java
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */
public class Files {
    public static int TurnsIn; // Turns
    public static int SidesIn; // Sides
    public static int DieIn; // Die
    /**
     * This function reads in the values from the text file
     */
    public static void ReadInFile()
    {
        Scanner inFile = null; // input
        try {
            inFile = new Scanner(new java.io.File("src/yahtzeeConfig.txt"));
            if(inFile.hasNextInt())
            {
                //Tests to see if file is there and can read
                File file = new File("src/yahtzeeConfig.txt");
                System.out.println("src/yahtzeeConfig.txt is a file? "+ file.isFile());
                SidesIn = inFile.nextInt();
                Dice.setNumSides(SidesIn);
                DieIn = inFile.nextInt();
                Hand.setNumDice(DieIn);
                TurnsIn = inFile.nextInt();
                Setup.setNumRolls(TurnsIn);
                inFile.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found"); // File not found
        }
    }
}
