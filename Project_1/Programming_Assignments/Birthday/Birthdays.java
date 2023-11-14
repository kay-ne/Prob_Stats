import java.util.ArrayList;
import java.util.Random;

public class Birthdays 
{
    Random rand = new Random();

    /**
     * Run the experiment to find a matching birthday between two people in a class
     * 
     * @param s the number of students in a class
     * @param n number of classes or trials
     * @return the probability of finding a match in classes over the total number of classes
     */
    public double run(int s, int n)
    {
        int matches = 0;

        for(int i = 0; i < n; i++)
        {
            ArrayList<Person> person = new ArrayList<>();

            generateBirthdays(person, s);

            if(findMatch(person) == true)
            {
                matches++;
            }
        }

        return (double) matches/n;
    }

    /**
     * Generates random birthdays based on class size
     * 
     * @param person ArrayList to contain person birthday month and day
     * @param s class size
     */
    public void generateBirthdays(ArrayList<Person> person, int s)
    {
        for(int j = 0; j < s; j++)
        {
            int m = getRandomMonth();
            int d = getRandomDay(m);
    
            Person p = new Person(m, d);
            person.add(p);
        }
    }

    /**
     * Returns a random number for month
     * 
     * @return random int number from 1-12
     */
    public int getRandomMonth()
    {
        return rand.nextInt(12)+1;
    }

    /**
     * Returns a random number for day based on the month that was given
     * 
     * @param m month that was randomly generated
     * @return random day based on month
     */
    public int getRandomDay(int m)
    {
        if(m == 2)
        {
            return rand.nextInt(28)+1;
        }
        else
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            return rand.nextInt(31)+1;
        }
        else
        {
            return rand.nextInt(30)+1;
        }
    }

    /**
     * Finds a matching birthday in a class. True if a match, false if no match
     * 
     * @param person ArrayList of person
     * @return Boolean
     */
    public boolean findMatch(ArrayList<Person> person)
    {
        for(int i = 0; i < person.size(); i++)
        {
            for(int j = i+1; j < person.size(); j++)
            {
                if(person.get(i).getMonth() == person.get(j).getMonth())
                {
                    if(person.get(i).getDay() == person.get(j).getDay())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
