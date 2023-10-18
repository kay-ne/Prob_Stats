package StatsLibrary.Chapter2;

import java.math.BigInteger;

public class Factorial 
{
    /**
     * Method to find factorial of a number
     * 
     * Factorial method taken from:
     * Paul, J. (2015, Aug. 26). How to calculate large factorial using BigInteger in Java? Example tutorial [Blog Post]. Retrieved from https://javarevisited.blogspot.com/2015/08/how-to-calculate-large-factorials-using-BigInteger-Java-Example.html.
     * 
     * @param n int number
     * @return BigInteger factorial of n
     */
    public BigInteger factorial(int n)
    {
        BigInteger result = BigInteger.ONE;

        for(int i = n; i > 0; i--)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}