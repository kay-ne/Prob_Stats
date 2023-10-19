package StatsLibrary.Chapter3;

public class testDistributions 
{
    public static void main(String[]args)
    {
        Binomial b = new Binomial();
        Geometric g = new Geometric();
        Hypergeometric h = new Hypergeometric();
        NegativeBinomial n = new NegativeBinomial();
        Poisson p = new Poisson();
        Tchebysheff t = new Tchebysheff();

        // Numbers from Exercise 3.43 in textbook: Many utility companies promote energy... all 5 qualify
        System.out.println("\n===== binomial probability distribution =====");
        System.out.println("Probability: " + b.binomial(.7, .3, 5, 5));
        System.out.println("Expected Value: " + b.binomialExpectedValue(.7, 5));
        System.out.println("Expected Variance: " + b.binomialExpectedVariance(.7, .3, 5));

        // Numbers from Exercise 3.67 in textbook: Suppose that 30% of the applicants...
        System.out.println("\n===== geometric probability distribution =====");
        System.out.println("Probability: " + g.geometric(.3,.7, 5));
        System.out.println("Expected Value: " + g.geometricExpectedValue(.3));
        System.out.println("Expected Variance " + g.geometricExpectedVariance(.3));

        // Numbers from Exercise 3.103 in textbook: A warehouse contains ten printing machines...
        System.out.println("\n===== hypergeometric probability distribution =====");
        System.out.println("Probability: " + h.hypergeometric(10, 5, 4, 0));
        System.out.println("Expected Value: " + h.hyperExpectedValue(10, 5, 4));
        System.out.println("Expected Variance " + h.hyperExpectedVariance(10, 5, 4));

        // Numbers from Exercise 3.92 in textbook: Ten percent of the engines manufactured...
        System.out.println("\n===== negative binomial probability distribution =====");
        System.out.println("Probability: " + n.negativeBinomial(1, 2, .9, .1));
        System.out.println("Expected Value: " + n.negativeExpectedValue(1, .9));
        System.out.println("Expected Variance " + n.negativeExpectedVariance(1, .9));

        // Numbers from Poisson Lecture from Oct. 16, 2023: Example: Computer crashes every 4 months. Probability of no crashes?
        System.out.println("\n===== poisson probability distribution =====");
        System.out.println("Probability: " + p.poisson(0, 1));

        // Numbers from Tchebysheff Lecture from Oct. 18, 2023: Example 2
        System.out.println("\n===== tchebysheff's theoreom probability distribution =====");
        System.out.println("Probability: " + t.tchebysheff(16, 6, 11, 3) + "%");
    }
}
