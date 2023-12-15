package Project_2.Plotter_Salter_Smoother.Part_1_Java.Salter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Project_2.Plotter_Salter_Smoother.Part_1_Java.Plotter.PlotterData;

public class Salter
{
    ArrayList<PlotterData> salterData = new ArrayList<>();

    /**
     * Method to copy data from plotter file to ArrayList
     * 
     * @param plotter csv file
     */
    public void copyDataToArrayList(BufferedReader plotter)
    {
        try
        {
            String line;
            // skips X,Y
            if((line = plotter.readLine()) != null)
            {
                plotter.mark(line.length());
            }

            while((line = plotter.readLine()) != null)
            {
                String[] x = line.split("[,]");
                PlotterData point = new PlotterData(Double.valueOf(x[0]), Double.valueOf(x[1]));
                salterData.add(point);
            }
        }
        catch (IOException e) 
        {
            System.out.println("An error has occurred: " + e);
        }
    }

    /**
     * Method to salt data.
     * 
     * @param salt_min int of minimum salt range
     * @param salt_max int of maximum salt range
     */
    public void salter(int salt_min, int salt_max)
    {
        Random rand = new Random();

        // salting min and max has to be positive
        if(salt_max == salt_min || salt_max <= 0 || salt_min <= 0)
        {
            System.out.println("Error: You cannot have max and min for salting be equal to each other and they should be greater than 0!");
        }
        if(salt_min > salt_max)
        {
            System.out.println("Error: Minimum should be less than maximum.");
        }
        else
        {
            for(int i = 0; i < salterData.size(); i++)
            {
                int randSalt = rand.nextInt((salt_max+1) - salt_min)+salt_min;

                double newY;
                if(rand.nextInt(2) == 0) // adding
                {
                    newY = salterData.get(i).getY() - randSalt;
                }
                else // subtracting
                {
                    newY = salterData.get(i).getY() + randSalt;
                }
                salterData.get(i).setY(newY);
            }
        }
    }
}
