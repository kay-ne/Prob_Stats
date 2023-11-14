package StatsLibrary.Chapter4;

public class TestChapter4 
{
    public static void main(String[]args)
    {
        // !! did not do expected mean or the distribution function and density function because I would need calculus
        // testing variance of continuous random variable
        
        // Numbers gotten from textbook Example 4.6 on pg. 171: "In example 4.4 we determined..."
        // Expected answer: ~0.15
        System.out.println("===== continuous RV -- variance =====");
        ContinuousRV_Variance v = new ContinuousRV_Variance();
        System.out.println("Variance with E(Y^2) = 2.4, and E(Y) = 1.5: " + v.variance(2.4, 1.5) + "\n");

        // Numbers gotten from textbook, HW 4.51 and 4.52: "The cycle time for trucks..." and "Refer to Excersize 4.51..."
        // Expected answers: Probability: 25%,  Mean: 60,  Variance: 33.33
        System.out.println("===== uniform distribution =====");
        UniformDistribution u = new UniformDistribution();
        System.out.println("Probability of uniform distribution with d = 70, c = 65, b = 70, a = 50: " + u.uniform(70, 65, 70, 50) + "%");
        System.out.println("Mean of uniform distribution with b = 70, a = 50: " + u.expectedMean(70, 50));
        System.out.println("Variance of uniform distribution with b = 70, a = 50: " + u.expectedVariance(70, 50));
    }
}
