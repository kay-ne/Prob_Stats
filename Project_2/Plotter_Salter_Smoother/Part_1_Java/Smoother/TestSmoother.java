package Project_2.Plotter_Salter_Smoother.Part_1_Java.Smoother;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestSmoother 
{
    public static void main(String[]args)
    {
        Smoother smooth = new Smoother();

        File file = new File("Project_2\\Plotter_Salter_Smoother\\Part_1_Java\\Smoother\\SmootherData.csv");

        try
        {
            BufferedReader salterFile = new BufferedReader(new FileReader("Project_2\\Plotter_Salter_Smoother\\Part_1_Java\\Salter\\SalterData.csv"));

            // copy salterdata to smoother arraylist
            smooth.copyDataToArrayList(salterFile);
            salterFile.close();

            // figure 6 - plotter: 100 points, salter: [5-205]
            smooth.smoother(3); // window value: 3
            // smooth.smoother(10); // window value: 10
            // smooth.smoother(20); // window value: 20
            // smooth.smoother(50); // window value: 50

            /*  
                any number greater than half the points or equal to the number of points will give error
                    because they will cause an out of bounds error. values less than or equal to 0 will 
                    also be caught because it does not make sense to smooth with negatives and 0.

                smooth.smoother(75);
                smooth.smoother(100);
                smooth.smoother(0); 
                smooth.smoother(-8);
            */

            // write smoothed data to csv
            FileWriter w;
            if(!smooth.dataSmoothed.isEmpty())
            {
                w = new FileWriter(file);
                w.write("X,Y\n");
                for(int i = 0; i < smooth.dataSmoothed.size(); i++)
                {
                    w.write(String.valueOf(smooth.dataSmoothed.get(i).getX()) + "," + String.valueOf(smooth.dataSmoothed.get(i).getY()) + "\n");
                }

                w.close();
                System.out.println("Writing to: \"" + file.getName() + "\" was successful!");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred: " + e);
        }
    }
}
