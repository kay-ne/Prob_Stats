package Project_2.Plotter_Salter_Smoother.Part_1_Java.Plotter;

import java.util.Comparator;

public class PlotterData 
{
    double x, y;

    /**
     * Constructor of plotter data.
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public PlotterData(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for x-coordinate.
     * 
     * @return double x-coord
     */
    public double getX()
    {
        return x;
    }

    /**
     * Getter method for y-coordinate.
     * 
     * @return double y-coord
     */
    public double getY()
    {
        return y;
    }

    /**
     * Setter method for x-coordinate.
     * 
     * @param x_coord
     */
    public void setX(double x_coord)
    {
        x = x_coord;
    }

    /**
     * Setter method for y-coordinate.
     * 
     * @param y_coord
     */
    public void setY(double y_coord)
    {
        y = y_coord;
    }

    /**
     * Comparator method to sort the arraylist in ascending order
     * 
     * Got help from: Scholtz, Bauke [BalusC]. (2009, November 28) *Sorting an ArrayList of objects using a custom sorting order.* Stack Overflow. https://stackoverflow.com/a/1814112
     * 
     */
    public static Comparator<PlotterData> COMPARE_BY_X = new Comparator<PlotterData>()
    {
        public int compare(PlotterData point1, PlotterData point2)
        {
            return Double.compare(point1.getX(), point2.getX());
        }
    };
}
