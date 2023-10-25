package StatsLibrary.Chapter3;

import StatsLibrary.Chapter2.Permutations_Combinations;

public class NegativeBinomial extends Permutations_Combinations
{
    /**
     * Method to calculate negative binomial probability distribution
     * 
     * @param r wanted number for success at 'y' trial
     * @param y number of trials
     * @param p probability of success
     * @param q probability of failure
     * @return double probability
     */
    public double negativeBinomial(int r, int y, double p, double q)
    {
        return combinations(y-1, r-1).doubleValue()*Math.pow(p, r)*Math.pow(q, y-r);
    }

    /**
     * Method to calculate negative binomial expected value
     * 
     * @param r wanted number for success at 'y' trial
     * @param p probability of success
     * @return double expected value
     */
    public double negativeExpectedValue(int r, double p)
    {
        if(p <= 0.0)
        {
            System.out.println("Cannot divide by 0 or probability cannot be negative. You have inputted p as: " + p);
            return -1;
        }
        else
        {
            return r/p;
        }
        
    }

    /**
     * Method to calculate negative binomial expected variance
     * 
     * @param r wanted number for success at 'y' trial
     * @param p probability of success
     * @return double expected variance
     */
    public double negativeExpectedVariance(int r, double p)
    {
        if(p <= 0.0)
        {
            System.out.println("Cannot divide by 0 or probability cannot be negative. You have inputted p as: " + p);
            return -1;
        }
        else
        {
            return (r*(1-p))/Math.pow(p, 2);
        }
        
    }
}
