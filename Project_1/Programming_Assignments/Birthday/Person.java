public class Person 
{
    int month, day;
    public Person(int month, int day)
    {
        this.month = month;
        this.day = day;
    }

    /**
     * get month of person
     * 
     * @return month
     */
    public int getMonth()
    {
        return this.month;
    }

    /**
     * get day of person
     * 
     * @return day
     */
    public int getDay()
    {
        return this.day;
    }

    /**
     * set the month of the person to a new month
     * 
     * @param m month
     */
    public void setMonth(int m)
    {
        this.month = m;
    }

    /**
     * sets the day of the person to a new day
     * 
     * @param d day
     */
    public void setDay(int d)
    {
        this.day = d;
    }
    
}
