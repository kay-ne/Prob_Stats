package StatsLibrary.Chapter2;

public class testConditional_Bayes_Independent 
{
    public static void main(String[]args)
    {
        Conditional_Bayes_Independent test = new Conditional_Bayes_Independent();

        System.out.println("===== conditional probability =====");
        // Numbers from Exercise 2.71 part a from textbook: If two events, A & B...
        System.out.println("Conditional probability of P(A|B): " + test.conditional(.1, .3));

        System.out.println("\n===== bayes' theorem =====");
        // Numbers from Exercise 2.125 from textbook: A diagnostic test for a disease...
        System.out.println("Bayes' theorem: " + test.bayes(.9, .9, .01, .99));

        System.out.println("\n===== testing if 2 events are independent =====");
        // independent (true)
        // Numbers from Exercise 2.72 (Sept. 21, 2023) from textbook: For certain population of employees... 
        System.out.println("Testing independence of event A and event B: " + test.independent(.6, .4, .24));

        // independent (false)
        // Same problem as above, changing probability of event B to .3
        System.out.println("Testing independence of event A and event B: " + test.independent(.6, .3, .24));
    }
}
