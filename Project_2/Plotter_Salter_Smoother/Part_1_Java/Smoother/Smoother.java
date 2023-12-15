package Project_2.Plotter_Salter_Smoother.Part_1_Java.Smoother;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Project_2.Plotter_Salter_Smoother.Part_1_Java.Plotter.PlotterData;
import StatsLibrary.Chapter1.MeanMedianMode;

public class Smoother extends MeanMedianMode
{
    ArrayList<PlotterData> smootherData = new ArrayList<>();
    ArrayList<PlotterData> dataSmoothed = new ArrayList<>();

    /**
     * Method to copy data from salter file to ArrayList
     * 
     * @param salter csv file
     */
    public void copyDataToArrayList(BufferedReader salter)
    {
        try
        {
            String line;
            // skips X,Y
            if((line = salter.readLine()) != null)
            {
                salter.mark(line.length());
            }

            while((line = salter.readLine()) != null)
            {
                String[] x = line.split("[,]");
                PlotterData point = new PlotterData(Double.valueOf(x[0]), Double.valueOf(x[1]));
                smootherData.add(point);
            }
            // sort array
            Collections.sort(smootherData, PlotterData.COMPARE_BY_X);
        }
        catch (IOException e) 
        {
            System.out.println("An error has occurred: " + e);
        }
    }

    /**
     * Method to smooth data.
     * 
     * @param windowValue
     */
    public void smoother(int windowValue)
    {
        ArrayList<Double> numbersToMean = new ArrayList<>();

        for(int i = 0; i < smootherData.size(); i++)
        {
            if(windowValue == smootherData.size() || windowValue >= smootherData.size()/2)
            {
                System.out.println("You cannot have the window value be equal to the number of points or greater than half the number of points!");
                break;
            }
            if(windowValue <= 0)
            {
                System.out.println("Window value has to be greater than 0!");
                break;
            }

            // if i is the first point
            if(i == 0)
            {
                numbersToMean.add(smootherData.get(i).getY()); // save the first point into numbersToMean arraylist
                for(int j = 1; j <= windowValue; j++) // next points in windowValue from the point after the first to the windowValue
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }
            else
            // if i is the last point
            if(i == smootherData.size()-1)
            {
                numbersToMean.add(smootherData.get(i).getY()); // save current point

                for(int j = i-1; j >= (i-windowValue); j--)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }
            else
            // if points on left and right **are not** out of bounds
            if((i-windowValue) >= 0 && (i+windowValue) < smootherData.size())
            {
                // get points on left
                for(int j = i-1; j >= (i-windowValue); j--)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }

                // get points on right
                for(int j = i+1; j <= (i + windowValue); j++)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }
            else
            // if i +- windowsize is **out** of bounds on left and right
            if((i-windowValue) < 0 && (i+windowValue) > smootherData.size())
            {
                numbersToMean.add(smootherData.get(i).getY()); // save current point
                
                // get points on left
                for(int j = i-1; j >= 0; j--)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }

                // get points on right
                for(int j = i+1; j < smootherData.size(); j++)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }
            else
            // if points to **left** are out of bounds
            if((i-windowValue) < 0)
            {
                numbersToMean.add(smootherData.get(i).getY()); // save current point
                // get points on left
                for(int j = i-1; j >= 0; j--)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }

                // get points on right
                for(int j = i+1; j <= (i + windowValue); j++)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }
            else
            // if points to **right** are out of bounds
            if((i+windowValue) >= smootherData.size())
            {
                numbersToMean.add(smootherData.get(i).getY()); // save current point

                // get points on left
                for(int j = i-1; j >= (i-windowValue); j--)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }

                // get points on right
                for(int j = i+1; j < smootherData.size(); j++)
                {
                    numbersToMean.add(smootherData.get(j).getY());
                }
            }

            double result = findMean(numbersToMean);
            dataSmoothed.add(new PlotterData(smootherData.get(i).getX(), result));
            numbersToMean.clear();
        }
    }
}
