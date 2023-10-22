package StatsLibrary.Chapter1;
import java.util.ArrayList;

public class TestMeanMedianMode 
{
    public static void main(String[]args)
    {
        MeanMedianMode test = new MeanMedianMode();
        StandardDeviation testSD = new StandardDeviation();

        ArrayList<Double> testNumbers = new ArrayList<>();

        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(3.0);
        testNumbers.add(1.0);
        testNumbers.add(6.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);

        System.out.println("List as inputted: " + testNumbers);

        double testerResultsMean = test.findMean(testNumbers);
        double testerResultsMedian = test.findMedian(testNumbers);
        double testerResultsSD = testSD.findStandardDeviation(testNumbers);

        System.out.println("Sorted list: " + testNumbers);

        System.out.println("\nThis is the **mean or average** of testNumbers: " + testerResultsMean);
        System.out.println("This is the **median** of testNumbers: " + testerResultsMedian);

        System.out.println("\nMode(s) of testNumbers: ");
        test.findMode(testNumbers);

        System.out.println("\nThis is the **variance**: " + Math.pow(testerResultsSD, 2));
        System.out.println("This is the **standard deviation** of testNumbers: " + testerResultsSD);

        // Numbers from Relative Frequency Histograms Lecture from Sept. 08, 2023
        System.out.println("\nTesting variance with sum = 886, size = 6: " + testSD.findVariance(886, 6));
    }    
}