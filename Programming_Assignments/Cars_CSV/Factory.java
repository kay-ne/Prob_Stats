package Programming_Assignments.Cars_CSV;

import java.util.ArrayList;
import java.util.Random;

public class Factory 
{
    ArrayList<Car> carData = new ArrayList<>();
    Random rand = new Random();

    /**
     * Contructs a car with type, year, color, and miles then saves into ArrayList of carData
     * 
     * @param n number of trials or rounds
     */
    public void constructCar(int n)
    {
        for(int i = 0; i < n; i++)
        {
            String type = getRandCarType();
            int year = rand.nextInt(2020-1970)+1970;
            String color = getRandColor();
            int miles = rand.nextInt(250000);

            Car cars = new Car(type, year, color, miles);
            carData.add(cars);
        }
    }

    /**
     * Get a random car type from ArrayList
     * 
     * @return car type
     */
    public String getRandCarType()
    {
        ArrayList<String> carTypes = new ArrayList<>();

        carTypes.add("Sedan");
        carTypes.add("Toyota");
        carTypes.add("Honda");
        carTypes.add("Lexus");
        carTypes.add("Prius");
        carTypes.add("Sedan"); // rigging data

        return carTypes.get(rand.nextInt(carTypes.size()));
    }

    /**
     * Get a random car color from ArrayList
     * 
     * @return car color
     */
    public String getRandColor()
    {
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("White");
        colors.add("Silver");
        colors.add("Black");
        colors.add("Blue");
        colors.add("Red"); // rigging data

        return colors.get(rand.nextInt(colors.size()));
    }
}
