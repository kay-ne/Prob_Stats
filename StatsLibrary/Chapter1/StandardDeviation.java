package StatsLibrary.Chapter1;

import java.util.ArrayList;

public class StandardDeviation extends MeanMedianMode
{
    /**
     * Method to calculate the standard deviation from ArrayList
     * 
     * @param userInputNumbers ArrayList of Double
     * @return double standard deviation
     */
    public double findStandardDeviation(ArrayList<Double> userInputNumbers)
    {
        double mean = findMean(userInputNumbers);
        int size = userInputNumbers.size();

        ArrayList<Double> data = new ArrayList<>();

        for(int i = 0; i < userInputNumbers.size(); i++)
        {
            data.add(Math.pow((userInputNumbers.get(i) - mean), 2));
        }

        double sum = getSum(data);

        double variance = findVariance(sum, size);

        return Math.sqrt(variance);
    }

    /**
     * Method to calculate variance
     * 
     * @param sum sum of values
     * @param size size of list
     * @return double variance
     */
    public double findVariance(double sum, int size)
    {
        return sum/(size-1);
    }
}
