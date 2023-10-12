package StatsLibrary.Chapter3;

import StatsLibrary.Chapter2.Permutations_Combinations;

public class Binomial extends Permutations_Combinations
{
    /**
     * Method to calculate binomial
     * 
     * @param p probability of success
     * @param q probability of failure
     * @param n number of trials
     * @param y number of successes
     * @return double probability
     */
    public double binomial(double p, double q, int n, int y)
    {
        return combinations(n, y).doubleValue()*Math.pow(p, y)*Math.pow(q, (n-y));
    }

    /**
     * Method to calculate the expected value
     * 
     * @param p probability of success
     * @param n number of trials
     * @return double expected value
     */
    public double binomialExpectedValue(double p, int n)
    {
        return n*p;
    }

    /**
     * Method to calculate the expected variance
     * 
     * @param p probability of success
     * @param q probability of failure
     * @param n number of trials
     * @return double expected variance
     */
    public double binomialExpectedVariance(double p, double q, int n)
    {
        return n*p*q;
    }
}
