/**
 * This is a Score Class that is used in Yahtzee.java
 * CPSC 224-02, Spring 2020
 * Programming Assignment #3
 * Sources: Professor Worobec's yahtzee1.cpp file
 *
 * @author Brian Steuber
 * @version v1.0 2/10/20
 */

public class Score {
    /**
     * calculates the score of a hand by addition
     *
     * @param array the ints in the players hand
     * @param n number being passed in
     * @return the largest n of a kind
     */
    public static int nOfAKindFound(int[] array, int n)
    {
        int found = 0;
        int count = 0;
        for(int dieVal = 1; dieVal <= Dice.getNumSides(); dieVal++)
        {
            count = 0;
            for(int diePos = 0; diePos < Hand.getNumDice(); diePos++)
            {
                if(array[diePos] == dieVal)
                    count++;
            }
            if(count >= n)
                found = count;
        }
        return found;
    }

    /**
     * calculates the number of consecutive dice in a row
     *
     * @param array the ints in the players hand
     * @param n number being passed in
     * @return length of the longest straight found
     */
    public static int nStraightFound(int array[], int n)
    {
        int found = 0;
        int length = 1;
        int count = Hand.getNumDice()-1;
        while(count > 0) {
            if(array[count] - 1 == array[count-1])
                length++;
            count--;
        }
        if(length >= n)
            found = length;
        return found;
    }

    /**
     * calculates if there are 3 of a kind and a pair in the player's hand
     *
     * @param array the ints in the players hand
     * @return foundFH true if there is 3 of a kind and a pair in the player's hand
     */
    public static boolean fullHouseFound(int[] array)
    {
        if(nOfAKindFound(array, 2) >= 2 && nOfAKindFound(array, 3) >= 3)
        {
            return true;
        }
        return false;
    }

    /**
     * calculates the total of the upperhand
     *
     * @return total/score of the upperhand
     */
    public static int totalUpperHand()
    {
        int total = 0;
        for(int i = 0; i < Dice.getNumSides(); i++)
        {
            total+=Scorecard.gScore[i];
        }
        return total;
    }

    /**
     * calculates the total of the lowerhand
     *
     * @return total/score of the lowerhand
     */
    public static int totalLowerHand()
    {
        int total = 0;
        for(int i = Dice.getNumSides(); i < Scorecard.getArraySize(); i++)
        {
            total+=Scorecard.gScore[i];
        }
        return total;
    }

    /**
     * calculates the bonus based on the players score during the round
     *
     * @return bonus point potential
     */
    public static int calculateBonus()
    {
        int bonus = 0;
        for(int i = 1; i <= Dice.getNumSides(); i++)
        {
            bonus += (i*3);
        }
        return bonus;
    }
}
