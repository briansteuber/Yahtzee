/**
 * This is a Scorecard Class that manages the scorecard in Yahtzee
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */
public class Scorecard {

    private static int arraySize; //size of array
    public static int[] rScore; //round score
    public static int[] gScore; //game score

    /**
     * Sets the arrays
     */
    public static void setArraySize()
    {
        arraySize = Dice.getNumSides() + 7; // accounts for lower scorecard
        rScore = new int[arraySize];
        inItRScore();
        gScore = new int[arraySize];
        inItGScore();
    }

    /**
     * Accessor Method
     *
     * @return number of digits in the array
     */
    public static int getArraySize()
    {
        return arraySize;
    }

    /**
     * shows the scorecard
     *
     * @param hand returns the scorecard
     */
    public static void showEntire(Hand hand)
    {
        gUpperCard(hand);
        LowerScorecard.gLowerCard();
    }

    /**
     * Initializes the round Score
     */
    public static void inItRScore()
    {
        for(int i = 0; i < arraySize; i++)
        {
            rScore[i] = -1;
        }
    }

    /**
     * Initializes the game Score
     */
    public static void inItGScore()
    {
        for(int i = 0; i < arraySize; i++)
        {
            gScore[i] = -1;
        }
    }

    /**
     * Uppercard function
     *
     * @param hand updates score on uppercard
     */
    public static void upperCard(Hand hand)
    {
        //upper scorecard
        for(int dieValue = 1; dieValue <= Dice.getNumSides(); dieValue++)
        {
            int currCount = 0;
            for (int diePosition = 0; diePosition < Hand.getNumDice(); diePosition++)
            {
                if (hand.theDice[diePosition] == dieValue)
                {
                    currCount++;
                }
            }
            if(gScore[dieValue-1] == -1)
            {
                System.out.println("(" + dieValue + ") Score " + (dieValue * currCount) + " on the " + dieValue + " line");
            }
            rScore[dieValue-1] = dieValue*currCount;
        }
    }

    /**
     * game Uppercard Function
     *
     * @param hand returns upper game scorecard
     */
    public static void gUpperCard(Hand hand)
    {
        //upper scorecard
        System.out.println();
        System.out.println("Upper Scorecard");
        System.out.println("-------------------------");
        for(int dieValue = 1; dieValue <= Dice.getNumSides(); dieValue++)
        {
            if(gScore[dieValue-1] == -1)
            {
                System.out.println("(" + dieValue + ") Score " + (gScore[dieValue-1]+1) + " on the " + dieValue + " line");
            }
            else
            {
                System.out.println("(" + dieValue + ") Score " + (gScore[dieValue - 1]) + " on the " + dieValue + " line");
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * lowercard score
     *
     * @param hand updates score for lower scorecard
     */
    public static void lowerCard(Hand hand)
    {
        if(Score.nOfAKindFound(hand.theDice, 3) >= 3)
        {
            rScore[Dice.getNumSides()] = hand.totalHand(hand.theDice);
        }
        else
        {
            rScore[Dice.getNumSides()] = 0;
        }
        if(Score.nOfAKindFound(hand.theDice, 4) >= 4)
        {
            rScore[Dice.getNumSides()+1] = hand.totalHand(hand.theDice);
        }
        else
        {
            rScore[Dice.getNumSides()+1] = 0;
        }
        if(Score.fullHouseFound(hand.theDice))
        {
            rScore[Dice.getNumSides()+2] = 25;
        }
        else
        {
            rScore[Dice.getNumSides()+2] = 0;
        }
        if(Score.nStraightFound(hand.theDice, Hand.getNumDice() -1) >= Hand.getNumDice()-1)
        {
            rScore[Dice.getNumSides()+3] = 30;
        }
        else
        {
            rScore[Dice.getNumSides()+3] = 0;
        }
        if(Score.nStraightFound(hand.theDice, Hand.getNumDice()) >= Hand.getNumDice())
        {
            rScore[Dice.getNumSides()+4] = 40;
        }
        else
        {
            rScore[Dice.getNumSides()+4] = 0;
        }
        if(Score.nOfAKindFound(hand.theDice, 4) >= Hand.getNumDice())
        {
            rScore[Dice.getNumSides()+5] = 50;
        }
        else
        {
            rScore[Dice.getNumSides()+5] = 0;
        }
        rScore[Dice.getNumSides()+6] = hand.totalHand(hand.theDice);
    }

    /**
     * Assigns a line entered in by user
     *
     * @param line assigns gamescore value from roundscore value entered in
     */
    public static void pickLine(int line)
    {
        gScore[line-1] = rScore[line-1];
    }
}
