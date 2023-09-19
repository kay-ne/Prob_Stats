/* 
 * MH Answering Questions
 * 
 * i. If the contestant stays with her initial choice, the probability that she wins the good prize is about 33%.
 * 
 * ii. If the contestant switches after being shown a dud and initially chose the good prize, she would get the other dud.
 * 
 * iii. If she initially selected one of the duds and is shown the other dud and switches, she would get the good prize.
 * 
 * iv. The probability of the wins if the contestant switches from her initial choice after being shown a dud, it would be about 66%.
 * 
 * v. The strategy that maximizes the probability of winning the good prize is to switch after the dud is revealed.
 * 
 */

package Programming_Assignments.MontyHall;
import java.util.Random;

public class MontyHall 
{

    /**
     * Method when user does not change their initial choice
     * 
     * @param n number of trials/rounds
     * @return probability of wins
     */
    public double noChange(int n)
    {
        int wins = 0;
        int choice = 0; // player's choice

        Random rand = new Random();
        for(int r = 0; r < n; r++)
        {
            int car = rand.nextInt(3);
            if(choice == car)
            {
                wins++;
            }
        }
        double probability = (double) wins/n;
        return probability;
    }

    /**
     * Method when user does change their initial choice when goat is revealed
     * 
     * @param n number of trials/rounds
     * @return probability of wins
     */
    public double changes(int n)
    {
        int wins = 0;
        Random rand = new Random();
        int choice = rand.nextInt(3);
        int goat = rand.nextInt(3);
        int car = rand.nextInt(3);

        for(int r = 0; r < n; r++)
        {   
            while(goat == car || goat == choice)
            {
                goat = rand.nextInt(3);
            }

            int newChoice = rand.nextInt(3);
            while(newChoice == goat || newChoice == choice)
            {
                newChoice = rand.nextInt(3);
            }

            if(newChoice == car)
            {
                wins++;
            }
            choice = rand.nextInt(3);
        }

        double probability = (double) wins/n;
        return probability;
    }
}
