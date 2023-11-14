package Project_1.Programming_Assignments.Birthday;

public class TestBirthdays
{
    public static void main(String[]args)
    {
        Birthdays classB = new Birthdays();

        System.out.println("Probability of one pair of students having the same birthday out of 100 classes with 22 students each: " + classB.run(22, 100));
    }    
}
