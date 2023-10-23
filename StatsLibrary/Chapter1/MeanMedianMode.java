package StatsLibrary.Chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeanMedianMode
{
    /**
     * Method to calculate the mean
     * 
     * @param userInputNumbers ArrayList of Double
     * @return double mean
     */
    public double findMean(ArrayList<Double> userInputNumbers)
    {
        double result = getSum(userInputNumbers)/userInputNumbers.size();
        return result;
    }

    /**
     * Method to calculate sum of values
     * 
     * @param userInputNumbers ArrayList of Double
     * @return double sum
     */
    public double getSum(ArrayList<Double> userInputNumbers)
    {
        double sum = 0;

        for(double singleElement : userInputNumbers)
        {
            sum = sum + singleElement;
        }

        return sum;
    }

    /**
     * Method to finding the median
     * 
     * @param userInputNumbers ArrayList of Double
     * @return double median
     */
    public double findMedian(ArrayList<Double> userInputNumbers)
    {
        // sort the arraylist in ascending order
        Collections.sort(userInputNumbers);

        int middle = userInputNumbers.size()/2;

        if(userInputNumbers.size() % 2 == 0)
        {
            return (userInputNumbers.get(middle) + userInputNumbers.get(middle-1))/2;
        }
        else
        {
            return userInputNumbers.get(middle);
        }
    }

    /**
     * Method to find the mode(s) of an ArrayList
     * 
     * @param userInputNumbers ArrayList of Double
     */
    public void findMode(ArrayList<Double> userInputNumbers)
    {
        Collections.sort(userInputNumbers);
        HashMap<Double, Integer> dataList = new HashMap<Double, Integer>();

        // get different elements in list and add to hashmap dataList with frequency they appear
        for(int i = 0; i < userInputNumbers.size()-1; i++)
        {
            if(userInputNumbers.get(i+1) > userInputNumbers.get(i))
            {
                dataList.put(userInputNumbers.get(i), Collections.frequency(userInputNumbers, userInputNumbers.get(i)));
                dataList.put(userInputNumbers.get(i+1), Collections.frequency(userInputNumbers, userInputNumbers.get(i+1)));
            }
        }

        // get the max frequency from values
        Integer max = 0;
        for(Double j : dataList.keySet())
        {
            if(dataList.get(j) > max)
            {
                max = dataList.get(j);
            }
        }

        /* 
         * Got help from the solution to figure out the number of duplicate values from:
         * Sharma, S. (2011, August 1). [Comment on the online forum post *Find duplicate values in Java Map?*]. Stack Overflow. https://stackoverflow.com/a/6895217.
         */
        List<Integer> valuesList = new ArrayList<Integer>(dataList.values());
        Set<Integer> valuesSet = new HashSet<Integer>(dataList.values());

        if(max == 1 || valuesSet.size() == 1 || valuesSet.isEmpty() || valuesList.isEmpty())
        {
            System.out.println("There are no modes in the list.");
        }
        else
        {
            for(Double i : dataList.keySet())
            {
                if(dataList.get(i) == max)
                {
                    System.out.println("Mode: " + i + " | Count: " + max);
                }
            }
        }
    }
}