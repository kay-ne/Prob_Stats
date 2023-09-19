package Programming_Assignments.MontyHall;

public class TestMontyHall 
{
    public static void main(String[]args)
    {
        MontyHall testMH = new MontyHall();

        double resultNC = testMH.noChange(10000);
        double resultC = testMH.changes(10000);

        System.out.println("Probability of not changing answer: " + resultNC);
        System.out.println("Probability of changing answer: " + resultC);
    }
}
