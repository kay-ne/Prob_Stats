package Project_2.Plotter_Salter_Smoother.Part_1_Java.Plotter;

/* !!! Note on Plotter Method [Also discussed in my report on page 14 (and a little bit on 15)]
 * 
 * TL;DR: The max and min for ranges are inclusive. Below is my reasoning.
 * 
 * + I was unsure if the maximum and minimum numbers in the range were inclusive or exclusive, so I decided to make them inclusive
 *      because if I was inputting a range, I would expect points to be on the numbers I have set. 
 * 
 * ++ It also depends on how the user interperets the program, but I thought about this for too long for my liking so I just decided 
 *      to make them inclusive by finding the y-coords for the max and min before finding the other y-coords for the randomly 
 *      generated x-coords in the for loop.
 *      
 *      Because I am adding the two points of maximum and minimum first, I decreased the 'z' variable for number of points by 2.
 * 
 * +++ Last note: I did try to make the range be inclusive inside the for loop, but that made some points on the x-axis go over the 
 *      range. Even though they were only over some decimals and never going to the next integer, those points were still over the ranges and I 
 *      did not like that.
 */

import java.util.ArrayList;
import java.util.Random;

public class Plotter
{
    ArrayList<PlotterData> data = new ArrayList<>();
    Random rand = new Random();
    
    /**
     * Method to create points for parabola plot.
     * 
     * @param x_min minimum range on x-axis
     * @param x_max maximum range on x-axis
     * @param z number of points in range
     * @param a first coefficient
     * @param b second coeeficient
     * @param c third coefficient
     */
    public void plotter(int x_min, int x_max, int z, int a, int b, int c)
    {
        if(a == 0)
        {
            System.out.println("Error: 'a' cannot equal 0.");
        }
        if(x_min == 0 && x_max == 0 || x_min == x_max)
        {
            System.out.println("Error: You cannot have both 'x_min' and 'x_max' cannot equal 0 and they cannot be the same value.");
        }
        if(x_min > x_max)
        {
            System.out.println("Error: Minimum should be less than maximum.");
        }
        else
        {
            // calculating y-coords for maximum and minimum
            // maximum y-coord
            double y_coord = (double) a * Math.pow(x_max, 2) + b*x_max + c;
            PlotterData point = new PlotterData(x_max, y_coord);
            data.add(point);

            // minimum y-coord
            y_coord = (double) a * Math.pow(x_min, 2) + b*x_min + c;
            point = new PlotterData(x_min, y_coord);
            data.add(point);

            // calculating y-coords for randomly generated x-coords in between the ranges
            for(int i = 0; i < z-2; i++)
            {
                double x_coord = rand.nextDouble(x_max-x_min)+x_min;
                y_coord = (double) a * Math.pow(x_coord, 2) + b*x_coord + c;

                point = new PlotterData(x_coord, y_coord);
                data.add(point);
            }
        }
    }
}