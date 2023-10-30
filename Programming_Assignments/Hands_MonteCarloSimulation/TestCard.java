package Programming_Assignments.Hands_MonteCarloSimulation;

/* !! Read:
 * Compared probabilities from this website in the 'Results & Discussion' section:
 *      Perry, P. (2008, Dec. 31). Monte Carlo Poker Odds [Blog Post]. Retrieved from https://ptrckprry.com/blog/programming/2008/12/31/monte-carlo-poker-odds/.
 * 
 * runMonteCarlo method takes 2 parameters: 
 *      n = number of trials
 *      c = number of cards for hand
 * 
 * Had to increase n from '10,000' to '1,000,000' to get results for 'Straight Flush' and 'Royal Flush'. If result for those two appear as '0.0%' run again until a different result appears.
 */

public class TestCard
{
    public static void main(String[]args)
    {
        HandEvaluator hand = new HandEvaluator();

        System.out.println("\n===== Monte Carlo Simulation of Poker Hands =====");
        hand.runMonteCarlo(1000000, 5);
    }
}
