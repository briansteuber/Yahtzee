/**
 * This is a LowerScorecard Class that manages the scorecard in Yahtzee
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */

public class LowerScorecard {

    /**
     * Function to get index
     *
     * @param i index
     * @return value at that index
     */
    public static int returnVal(int i)
    {
        return Scorecard.gScore[i];
    }

    /**
     * Displays the lowercard
     */
    public static void lowerCard(){
        dispThreeK();
        dispFourK();
        dispFullHouse();
        dispSmStraight();
        dispLaStraight();
        dispYahtzee();
        dispChance();
    }

    /**
     * Displays the game lowercard
     */
    public static void gLowerCard()
    {
        System.out.println("Lower Scorecard");
        System.out.println("-------------------------");
        gDispThreeK();
        gDispFourK();
        gDispFullHouse();
        gDispSmStraight();
        gDispLaStraight();
        gDispYahtzee();
        gDispChance();
        System.out.println("-------------------------");
    }

    /**
     * Displays three of a kind
     */
    public static void dispThreeK()
    {
        int i = Dice.getNumSides();
        if(returnVal(i) == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the 3 Of A Kind line");
        }
    }

    /**
     * Displays four of a kind
     */
    public static void dispFourK()
    {
        int i = Dice.getNumSides() + 1;
        if(returnVal(i) == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the 4 Of A Kind line");
        }
    }

    /**
     * Displays full house
     */
    public static void dispFullHouse()
    {
        int i = Dice.getNumSides() + 2;
        if(returnVal(i) == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the Full House line");
        }
    }

    /**
     * Displays small straight
     */
    public static void dispSmStraight()
    {
        int i = Dice.getNumSides() + 3;
        if(returnVal(i) == -1) {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the Small Straight line");
        }
    }

    /**
     * Displays large straight
     */
    public static void dispLaStraight()
    {
        int i = Dice.getNumSides() + 4;
        if(returnVal(i) == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the Large Straight line");
        }
    }

    /**
     * Displays yahtzee
     */
    public static void dispYahtzee()
    {
        int i = Dice.getNumSides() + 5;
        if(returnVal(i) == -1) {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the Yahtzee line");
        }
    }

    /**
     * displays chance
     */
    public static void dispChance(){
        int i = Dice.getNumSides() + 6;

        if(returnVal(i) == -1) {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.rScore[i]) + " on the Chance line");
        }
    }

    /**
     * Displays game three of a kind
     */
    public static void gDispThreeK()
    {
        int i = Dice.getNumSides();
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the 3 Of A Kind line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the 3 Of A Kind line");
        }
    }

    /**
     * Displays game four of a kind
     */
    public static void gDispFourK(){
        int i = Dice.getNumSides() + 1;

        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the 4 Of A Kind line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the 4 Of A Kind line");
        }
    }

    /**
     * Displays game full house
     */
    public static void gDispFullHouse()
    {
        int i = Dice.getNumSides() + 2;
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the Full House line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the Full House line");
        }
    }

    /**
     * Displays game small straight
     */
    public static void gDispSmStraight()
    {
        int i = Dice.getNumSides() + 3;
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the Small Straight line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the Small Straight line");
        }
    }

    /**
     * Displays game large straight
     */
    public static void gDispLaStraight()
    {
        int i = Dice.getNumSides() + 4;
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the Large Straight line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the Large Straight line");
        }
    }

    /**
     * Displays game Yahztee
     */
    public static void gDispYahtzee()
    {
        int i = Dice.getNumSides() + 5;
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the Yahtzee line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the Yahtzee line");
        }
    }

    /**
     * Displays game chance
     */
    public static void gDispChance()
    {
        int i = Dice.getNumSides() + 6;
        if(Scorecard.gScore[i] == -1)
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i] + 1) + " on the Chance line");
        }
        else
        {
            System.out.println("(" + (i + 1) + ") Score " + (Scorecard.gScore[i]) + " on the Chance line");
        }
    }
}
