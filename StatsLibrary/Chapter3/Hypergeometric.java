package StatsLibrary.Chapter3;

import StatsLibrary.Chapter2.Permutations_Combinations;

public class Hypergeometric extends Permutations_Combinations
{
    //TODO: Handle 0 cases. How?
    
    /**
     * Method to calculate hypergeometric probability
     * 
     * @param N size of population
     * @param n number taken from total
     * @param r total number of successful objects
     * @param y number taken from r of what is wanted
     * @return double probability
     */
    public double hypergeometric(int N, int n, int r, int y)
    {
        double numerator = combinations(r, y).multiply(combinations(N-r, n-y)).doubleValue();
        double denominator = combinations(N, n).doubleValue();

        return numerator/denominator;
    }

    /**
     * Method to calculate expected value for hypergeometric dist.
     * 
     * @param N size of population
     * @param n number taken from total
     * @param r total number of successful objects
     * @return double expected value
     */
    public double hyperExpectedValue(int N, int n, int r)
    {
        return (double) (n*r)/N;
    }

    /**
     * Method to calculate expected variance for hypergeometric dist.
     * 
     * @param N size of population
     * @param n number taken from total
     * @param r total number of successful objects
     * @return double expected variance
     */
    public double hyperExpectedVariance(int N, int n, int r)
    {
        return (double) n * (double) r/N * (double) (N-r)/N * (double) (N-n)/(N-1);
    }
}
