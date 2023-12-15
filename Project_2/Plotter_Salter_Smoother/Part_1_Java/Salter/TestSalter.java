package Project_2.Plotter_Salter_Smoother.Part_1_Java.Salter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestSalter
{
    public static void main(String[]args)
    {
        Salter salt = new Salter();
        
        File file = new File("Project_2\\Plotter_Salter_Smoother\\Part_1_Java\\Salter\\SalterData.csv");

        try
        {
            BufferedReader plotterFile = new BufferedReader(new FileReader("Project_2\\Plotter_Salter_Smoother\\Part_1_Java\\Plotter\\PlotterData.csv"));

            // copy plotterdata to salterdata arraylist
            salt.copyDataToArrayList(plotterFile);
            plotterFile.close();

            // input parameters: salt_min, salt_max
            // salt data by set range

            salt.salter(5, 205); // salt high [5-200] (r: 200), points high
            // salt.salter(5, 55); // salt low [5-55] (r: 50), points high
            // salt.salter(7, 534); // salt high [7-584] (r: 577), points low
            // salt.salter(2, 3002); // salt with higher range [2-3002] (r: 3000), points low
            // salt.salter(5, 100); // salt low [5-100] (r: 95), points low

            FileWriter w;
            if(!salt.salterData.isEmpty())
            {
                w = new FileWriter(file);
                w.write("X,Y\n");
                for(int i = 0; i < salt.salterData.size(); i++)
                {
                    w.write(String.valueOf(salt.salterData.get(i).getX()) + "," + String.valueOf(salt.salterData.get(i).getY()) + "\n");
                }
                
                w.close();
                System.out.println("Writing to: \"" + file.getName() + "\" was successful!");
                
            }
            else
            {
                System.out.println("Error: Failed to write into \"" + file.getName() + "\" because data is empty!");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred: " + e);
        }
    }
}
