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
            System.out.println("Distance from 'a' and 'b' to the mean does not equal or k is < 1. You have inputted the following as... a: " + a + ", b: " + b + ".");
            System.out.println("'k' was calculated from a/s (s is standard deviation) which resulted in: k: " + k);
            return -1;
        }
        else
        {
            return (1-(1/Math.pow(k, 2)))*100;
        }
    }
}
