/**
 * This is a Hand Class that is used in Yahtzee.java
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */
public class Hand {

    private static int numDice; //numDie
    public int[] theDice; //Die in hand

    /**
     * Constructor
     *
     */
    public Hand()
    {
        theDice = new int[numDice];
        makeHand();
    }

    /**
     * Mutator Method
     *
     * @param dice passes in num of die
     */
    public static void setNumDice(int dice)
    {
        numDice = dice;
    }

    /**
     * Makes a hand and rolls each dice
     */
    public void makeHand()
    {
        Dice dice = new Dice(Dice.getNumSides());
        int diePosition;
        for(diePosition = 0; diePosition < numDice; diePosition++)
        {
            theDice[diePosition] = dice.rollDie();
        }
    }

    /**
     * Accessor method
     *
     * @return number of dice
     */
    public static int getNumDice()
    {
        return numDice;
    }

    /**
     * Prints hand to user
     */
    public void showHand()
    {
        for(int diePosition = 0; diePosition < numDice; diePosition++)
        {
            System.out.print(theDice[diePosition] + " ");
        }
        System.out.println();
    }

    /**
     * This function sorts the players hand
     *
     * @param array the integers in the players hand after roll
     */
    public void sortHand(int[] array)
    {
        int temp;
        int count = 0;
        int countB;
        while(count < numDice-1)
        {
            countB = count+1;
            while(countB < numDice)
            {
                if (array[count] > array[countB])
                {
                    temp = array[count];
                    array[count] = array[countB];
                    array[countB] = temp;
                }
                countB++;
            }
            count++;
        }
    }

    /**
     * Rerolls die thrown out
     * @param n position
     * @return new number
     */
    public int reRoll(int n)
    {
        Dice dice = new Dice(Dice.getNumSides());
        n = dice.rollDie();
        return n;
    }

    /**
     * calculates the total value of the hand by adding the dice together
     *
     * @param array the integers in the player's hand after the roll
     * @return the dice added up
     */
    public int totalHand(int array[])
    {
        int total = 0;
        for(int diePosition = 0; diePosition < numDice; diePosition++)
        {
            total += array[diePosition];
        }
        return total;
    }
}
