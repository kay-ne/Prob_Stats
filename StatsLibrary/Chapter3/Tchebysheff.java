package StatsLibrary.Chapter3;

public class Tchebysheff
{
    /**
     * Method to calculate tchebysheff theorem probability
     * 
     * @param upper upper bound of range
     * @param lower lower bound of range
     * @param mean mean
     * @param s standard deviation
     * @return double probability
     */
    public double tchebysheff(int upper, int lower, int mean, int s)
    {
        int a = upper - mean;
        int b = mean - lower;
        
        double k = (double)a/s;

        if(a != b || k < 1)
        {
            return 0;
        }
        else
        {
            return (1-(1/Math.pow(k, 2)))*100;
        }
    }
}
