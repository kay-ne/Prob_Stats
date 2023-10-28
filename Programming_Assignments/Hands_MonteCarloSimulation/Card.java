package Programming_Assignments.Hands_MonteCarloSimulation;

public class Card
{
    String suite, faceValue;
    int value;

    /**
     * Constructor for Card with number value
     * 
     * @param suite
     * @param value
     */
    public Card(String suite, int value)
    {
        this.suite = suite;
        this.value = value;
    }

    /**
     * Constructor for Card with face value
     * @param suite
     * @param faceValue
     */
    public Card(String suite, String faceValue, int value)
    {
        this.suite = suite;
        this.faceValue = faceValue;
        this.value = value;
    }

    /**
     * Method to get suite of card
     * 
     * @return String suite
     */
    public String getSuite()
    {
        return suite;
    }

    /**
     * Method to get face value of card
     * 
     * @return String face value
     */
    public String getFaceValue()
    {
        return faceValue;
    }

    /**
     * Method to get number value of card
     * @return int value
     */
    public int getValue()
    {
        return this.value;
    }
}
