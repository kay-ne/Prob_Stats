package Programming_Assignments.Cars_CSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFactory
{
    public static void main(String[]args)
    {
        Factory car = new Factory();

        car.constructCar(1000);

        File file = new File("Programming_Assignments\\Cars_CSV\\CarData.csv");
        
        FileWriter w;
        try 
        {
            w = new FileWriter(file);
            w.write("Car Type,Year,Color,Miles\n");
            for(int i = 0; i < car.carData.size(); i++)
            {
                w.write(car.carData.get(i).getCarType() + "," + String.valueOf(car.carData.get(i).getYear()) + ","  + car.carData.get(i).getColor() + "," + String.valueOf(car.carData.get(i).getMiles()) + "\n");
            }
            w.close();
            System.out.println("Writing to CSV is complete!");
        } 
        catch (IOException e) 
        {
            System.out.println("An error has occurred: " + e);
        }
    }
}
