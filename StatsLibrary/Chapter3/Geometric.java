package StatsLibrary.Chapter3;

public class Geometric
{
    /**
     * Method to calculate geometric probability distribution
     * 
     * @param p probability of successes
     * @param q probability of failures
     * @param y number of trials up to the first success
     * @return double probability
     */
    public double geometric(double p, double q, int y)
    {
        return Math.pow(q, y-1)*p;
    }

    /**
     * Method to calculate expected value
     * 
     * @param p probability of success
     * @return double expected value
     */
    public double geometricExpectedValue(double p)
    {
        if(p <= 0.0)
        {
            System.out.println("Cannot divide by 0 or probability cannot be negative. You have inputted p as: " + p);
            return -1;
        }
        else
        {
            return 1/p;
        }
    }

    /**
     * Method to calculate expected variance
     * 
     * @param p probability of success
     * @return double expected variance
     */
    public double geometricExpectedVariance(double p)
    {
        if(p <= 0.0)
        {
            System.out.println("Cannot divide by 0 or probability cannot be negative. You have inputted p as: " + p);
            return -1;
        }
        else
        {
            return (1-p)/Math.pow(p, 2);
        }
    }
}
