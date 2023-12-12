package StatsLibrary.Chapter5;

public class Conditional 
{
    /*
     * combined conditional discrete and conditional density because they are
     *      the same process in solving.
     */

    /**
     * Method to find conditional distribution and conditional density.
     *      conditional distribution:
     *          p(y1, y2) / p2(y2)
     *      
     *      conditional density:
     *          f(y1, y2) / f2(y2)
     * 
     * @param x (y1, y2)
     * @param y (y2)
     * @return
     */
    public double conditonal(double x, double y)
    {
        return x/y;
    }
}
