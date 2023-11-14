package Project_1.Programming_Assignments.Cars_CSV;

public class Car 
{
    String type, col;
    int year, miles;

    /**
     * Constructor for Car class
     * 
     * @param CarType
     * @param Year
     * @param Color
     * @param Miles
     */
    public Car(String CarType, int Year, String Color, int Miles)
    {
        type = CarType;
        year = Year;
        col = Color;
        miles = Miles;
    }

    /**
     * Sets type of car to parameter t
     * 
     * @param t type of car
     */
    public void setCarType(String t)
    {
        type = t;
    }

    /**
     * Get car type of car object
     * 
     * @return car type
     */
    public String getCarType()
    {
        return type;
    }

    /**
     * Sets year of car object to parameter y
     * 
     * @param y car year
     */
    public void setYear(int y)
    {
        year = y;
    }

    /**
     * Gets year of car object
     * 
     * @return year of car
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Sets color of car
     * 
     * @param c car color
     */
    public void setColor(String c)
    {
        col = c;
    }

    /**
     * Gets color of car object
     * 
     * @return color of car
     */
    public String getColor()
    {
        return col;
    }

    /**
     * Sets mileage of car
     * 
     * @param m mileage
     */
    public void setMiles(int m)
    {
        miles = m;
    }

    /**
     * Gets mileage of car object
     * 
     * @return mileage of car
     */
    public int getMiles()
    {
        return miles;
    }
}
