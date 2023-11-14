package StatsLibrary.Chapter4;

public class ContinuousRV_Variance 
{
    /**
     * Method to find variance for continuous random variables
     * @param EY2 expected value but E(Y^2), y-squared
     * @param EY the expected value aka mean aka E(Y)
     * @return double variance
     */
    public double variance(double EY2, double EY)
    {
        return EY2 - Math.pow(EY, 2);
    }    
}
