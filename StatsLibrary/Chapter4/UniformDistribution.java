package StatsLibrary.Chapter4;

public class UniformDistribution 
{
    /**
     * Method for calculating probability of a uniform distribution.
     * 
     * @param d max value you want to find
     * @param c min value of interval you want to find
     * @param b total value of uniform interval
     * @param a min value of uniform interval
     * @return double probability
     */
    public double uniform(double d, double c, double b, double a)
    {
        return (d-c)/(b-a) * 100;
    }

    /**
     * Method for calculating the mean of uniform distribution.
     * 
     * @param b total value of uniform interval
     * @param a min value of uniform interval
     * @return double mean
     */
    public double expectedMean(double b, double a)
    {
        return (b+a)/2;
    }

    /**
     * Method for calculating the variance of uniform distribution.
     * 
     * @param b total value of uniform interval
     * @param a min value of uniform interval
     * @return double variance
     */
    public double expectedVariance(double b, double a)
    {
        return (Math.pow((b-a), 2))/12;
    }
}
