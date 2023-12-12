package StatsLibrary.Chapter5;

public class TestChapter5 
{
    public static void main(String[]args)
    {
        CheckIndependence c = new CheckIndependence();
        Conditional con = new Conditional();

        /*
         * Numbers from Independent RV Lecture from Nov. 29.
         * Def. 5.8 with example from professor: 
         *      1/36 = 1/6 * 1/6 is independent
         *      1/36 = 1/5 * 1/7 are dependent
         * 
         * Changed 1/7 to 1/9 because of how I coded the method, because of the decimal formatting, 1/5 * 1/7 was close to 1/36 and returned true.
         */
        System.out.println("========== TEST CHECK INDEPENDENCE ==========");
        System.out.println("Is   1/6 * 1/6 = 1/36   independent?: " + c.checkIndependence(0.16666667, 0.16666667, 0.02777778)); // expected true
        System.out.println("Is   1/5 * 1/9 = 1/36   independent?: " + c.checkIndependence(0.2, 0.11111111, 0.02777778)); // expected false

        /*
         * Numbers gotten from Conditional Prob lecture. (Unfortunately cannot find the date of lecture).
         * Ex. 5.7
         */
        System.out.println("\n========== TEST CONDITIONAL DISTRIBUTION ==========");
        System.out.println("Conditional discrete of (2/15) / (8/15): " + con.conditonal(0.13333333, 0.53333333));
    }    
}
