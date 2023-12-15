package Project_2.Plotter_Salter_Smoother.Part_1_Java.Plotter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class TestPlotter 
{
    public static void main(String[]args)
    {
        Plotter plot = new Plotter();

        // input parameters: x_min, x_max, # of points, coefficients a, b, c (a != 0)
        // range is inclusive
        
        plot.plotter(-50, 50, 100, 1, 3, -5); // high range, high points
        // plot.plotter(-50, 50, 20, 1, 3, -5); // high range, low points
        // plot.plotter(20, 30, 100, 1, 3, -5); // low range, high points
        // plot.plotter(20, 30, 20, 1, 3, -5); // low range, low points

        File file = new File("Project_2\\Plotter_Salter_Smoother\\Part_1_Java\\Plotter\\PlotterData.csv");
        
        FileWriter w;
        try 
        {
            w = new FileWriter(file);
            if(!plot.data.isEmpty())
            {
                w.write("X,Y\n");
                for(int i = 0; i < plot.data.size(); i++)
                {
                    w.write(String.valueOf(plot.data.get(i).getX()) + "," + String.valueOf(plot.data.get(i).getY()) + "\n");
                }
                System.out.println("Writing to: \"" + file.getName() + "\" was successful!");
            }
            else
            {
                System.out.println("Error: Failed to write into \"" + file.getName() + "\" because data is empty!");
            }
            w.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error has occurred: " + e);
        }
    }
}
