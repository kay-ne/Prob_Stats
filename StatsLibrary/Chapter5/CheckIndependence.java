package StatsLibrary.Chapter5;

import java.text.DecimalFormat;

public class CheckIndependence 
{
    DecimalFormat df = new DecimalFormat("#.##");
    
    /**
     * Method to check if independent.
     *      If true, it is independent.
     *      If false, it is dependent.
     * 
     * @param x y1
     * @param y y2
     * @param z result wanted to check independence
     * @return boolean
     */
    public boolean checkIndependence(double x, double y, double z)
    {
        if((Double.parseDouble(df.format(x * y)) == Double.parseDouble(df.format(z))))
        {
            return true;
        }
        return false;
    }
}
