package StatsLibrary.Chapter2;

public class Conditional_Bayes_Independent
{
    /**
     * Method to calculate probability with conditional -- A given that B has been observed
     * 
     * @param AnB probability of events A intersect B
     * @param B probability of event B
     * @return double probability
     */
    public double conditional(double AnB, double B)
    {
        return AnB/B;
    }

    /**
     * Method to calculate probabiity with Bayes' -- B given that A has been observed
     * 
     * @param BgA probability of B given A
     * @param BgA_comp probability of B given A complement
     * @param B probability of event B occurring
     * @param B_comp probability of B complement
     * @return double probability
     */
    public double bayes(double BgA, double BgA_comp, double B, double B_comp)
    {
        return (BgA*B)/((BgA*B)+(BgA_comp*B_comp));
    }

    /**
     * Method to determine 2 events are independent
     * 
     * @param A probability of event A
     * @param B probability of event B
     * @param AnB probability of A intersect B
     * @return boolean
     */
    public boolean independent(double A, double B, double AnB)
    {
        if(A == conditional(AnB, B) || B == conditional(AnB, A) || AnB == A*B)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
