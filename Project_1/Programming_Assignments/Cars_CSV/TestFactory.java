package Project_1.Programming_Assignments.Cars_CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFactory
{
    public static void main(String[]args)
    {
        Factory car = new Factory();

        car.constructCar(1000);

        File file = new File("Project_1\\Programming_Assignments\\Cars_CSV\\CarData.csv");
        
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

        try
        {
            BufferedReader readCarData = new BufferedReader(new FileReader(file));

            String line;
            // skips the heading -- Car Type,Year,Color,Miles
            if((line = readCarData.readLine()) != null)
            {
                readCarData.mark(line.length());
            }

            while((line = readCarData.readLine()) != null)
            {
                String[] c = line.split("[,]");
                System.out.println(c[0] + "," + c[1] + "," + c[2] + "," + c[3]);
            }

            readCarData.close();

        }
        catch (IOException e)
        {
            System.out.println("An error has occurred: " + e);
        }
    }
}
