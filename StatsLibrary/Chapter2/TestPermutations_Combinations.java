package StatsLibrary.Chapter2;

public class TestPermutations_Combinations 
{
    public static void main(String[]args)
    {
        Permutations_Combinations test = new Permutations_Combinations();

        System.out.println("Permutations -- 10 P 2: " + test.permutations(10, 2));
        System.out.println("Combinations -- 10 C 2: " + test.combinations(10, 2));
    }
}
