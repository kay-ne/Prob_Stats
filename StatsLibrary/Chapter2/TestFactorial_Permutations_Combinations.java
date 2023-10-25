package StatsLibrary.Chapter2;

public class TestFactorial_Permutations_Combinations 
{
    public static void main(String[]args)
    {
        Permutations_Combinations test = new Permutations_Combinations();

        System.out.println("Factorial: " + test.factorial(7));

        // Numbers from Exercise 2.37 part a in textbook: A businesswoman in Philadelphia is preparing an itinerary for a visit to six major cities... 
        System.out.println("Permutations of 6 P 6: " + test.permutations(6, 6));

        // Numbers from Exercise 2.51 part a in textbook: A local fraternity is conducting a raffle where 50 tickets... a. all of the prizes?
        System.out.println("Combinations of 50 C 3: " + test.combinations(50, 3));
    }
}
