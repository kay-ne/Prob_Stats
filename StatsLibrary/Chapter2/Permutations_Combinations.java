package StatsLibrary.Chapter2;

import java.math.BigInteger;

public class Permutations_Combinations extends Factorial
{
    /**
     * Method for calculating permutations of 2 numbers
     * 
     * @param n total number
     * @param r number taken
     * @return BigInteger total of ordered combinations
     */
    public BigInteger permutations(int n, int r)
    {
        return factorial(n).divide(factorial(n-r));
    }

    /**
     * Method of calculating combinations of 2 numbers
     * 
     * @param n total number 
     * @param r number chosen
     * @return BigInteger total of any ordered combinations
     */
    public BigInteger combinations(int n, int r)
    {   
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(r).multiply(factorial(n-r));

        return numerator.divide(denominator);
    }
}
