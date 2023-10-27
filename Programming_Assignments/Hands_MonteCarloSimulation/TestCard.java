package Programming_Assignments.Hands_MonteCarloSimulation;

/* !! Read:
 * Compared probabilities from this website int the 'Results & Discussion' section:
 *      Perry, P. (2008, Dec. 31). Monte Carlo Poker Odds [Blog Post]. Retrieved from https://ptrckprry.com/blog/programming/2008/12/31/monte-carlo-poker-odds/.
 * 
 * Each method takes 2 parameters: 
 *      n = number of trials
 *      c = number of cards for hand
 * 
 * For royal flush: had to increase the number of trials from 10,000 to 1,000,000 to get results. If probability outputs as 0.0%, run it again.
 */

public class TestCard
{
    public static void main(String[]args)
    {
        HandEvaluator hand = new HandEvaluator();
        
        System.out.println("\nProbability of Success for **Pair**: " + hand.pair(10000, 5) + "%");

        System.out.println("\nProbability of Success for **Three of a Kind**: " + hand.three(10000, 5) + "%");

        // TODO: straight

        System.out.println("\nProbability of Success for **Flush**: " + hand.flush(10000, 5) + "%");

        System.out.println("\nProbability of Success for **Full House**: " + hand.fullHouse(10000, 5) + "%");

        System.out.println("\nProbability of Success for **Four of a Kind**: " + hand.four(10000, 5) + "%");

        // TODO: straight flush

        System.out.println("\nProbability of Success for **Royal Flush**: " + hand.royalFlush(1000000, 5) + "%");
    }    
}
