package StatsLibrary.Chapter3;

import StatsLibrary.Chapter2.Factorial;

public class Poisson extends Factorial
{
    /**
     * Method to calculate poisson probability distribution
     * 
     * @param y random variable
     * @param lambda mean number of occurrences in the interval
     * @return double probability
     */
    public double poisson(int y, double lambda)
    {
        return (Math.pow(lambda, y)/factorial(y).doubleValue())*Math.pow(Math.E, -lambda);
    }
}
