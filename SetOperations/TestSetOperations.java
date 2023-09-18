package Programming_Assignments.SetOperations;

import java.util.ArrayList;

public class TestSetOperations {
    public static void main(String[]args)
    {
        SetOperations testSet = new SetOperations();
        ArrayList<String> S = new ArrayList<>();

        S.add("Monday");
        S.add("Tuesday");
        S.add("Wednesday");
        S.add("Thursday");
        S.add("Friday");
        S.add("Saturday");
        S.add("Sunday");

        ArrayList<String> a = new ArrayList<>();
        a.add("Tuesday");
        a.add("Wednesday");
        
        ArrayList<String> b = new ArrayList<>();
        b.add("Monday");
        b.add("Tuesday");
        b.add("Sunday");

        ArrayList<String> resultUnion = testSet.union(a, b);
        ArrayList<String> resultInter = testSet.intersect(a, b);
        ArrayList<String> resultCompl = testSet.complement(S, a);

        System.out.println("Set S: " + S);
        System.out.println("Subset A: " + a);
        System.out.println("Subset B: " + b);
        System.out.println("====================");
        System.out.println("Union of Subsets A and B: " + resultUnion);
        System.out.println("Intersection of Subsets A and B: " + resultInter);
        System.out.println("Complement of A from Set S: " + resultCompl);
    }
}
