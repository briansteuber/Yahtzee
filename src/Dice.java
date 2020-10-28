import java.util.Random;
/**
 * This is a Dice Class that is used in Yahtzee.java
 * CPSC 224-02, Spring 2020
 * Programming Assignment #2
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */
public class Dice {

    private static int num_Sides; //numSides
    private static int side_Up; //sideUp

    /**
     * Constructor
     *
     * @param numSides sets num_Sides to numSides being passed in
     */
    public Dice(int numSides)
    {
        num_Sides = numSides;
    }
    /**
     * Function that rolls a die and returns a random number
     *
     * @return side_Up: num rolled
     */
    public static int rollDie()
    {
        side_Up = (int) (Math.random() * num_Sides) + 1;
        return side_Up;
    }
    /**
     * Accessor Method
     *
     * @return num_Sides
     */
    public static int getNumSides()
    {
        return num_Sides;
    }
    /**
     * Mutator Method
     *
     * @param numsides sets num_Sides
     */
    public static void setNumSides(int numsides)
    {
        num_Sides = numsides;
    }
}
