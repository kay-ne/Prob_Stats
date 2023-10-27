package Programming_Assignments.Hands_MonteCarloSimulation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * for a straight flush and a royal flush does the order matter? like does it specifically have to be:
 * 
 * straight flush: 10 9 8 7 6  or 5 4 3 2 A
 * can two cards with the same suit be next to each other?
 * 
 * royal flush (is it always): A K Q J 10 in that order
 */

public class HandEvaluator
{
    ArrayList<Card> Hand = new ArrayList<>();
    ArrayList<Card> Deck = new ArrayList<>(52);

    /**
     * Constructor of HandEvaluator. Calls populateDeck method.
     */
    public HandEvaluator()
    {
        populateDeck(Deck);
    }

    /**
     * Method to populate ArrayList Deck with Card objects.
     * 
     * @param Deck
     */
    public void populateDeck(ArrayList<Card> Deck)
    {
        // checks if Deck is not empty, clears the deck
        if(!Deck.isEmpty())
        {
            Deck.clear();
        }

        ArrayList<String> suite = new ArrayList<>();
        suite.add("Heart");
        suite.add("Club");
        suite.add("Diamond");
        suite.add("Spade");

        ArrayList<String> faces = new ArrayList<>();  
        faces.add("A");
        faces.add("J");
        faces.add("Q");
        faces.add("K");

        int facesIndex = 1;
        // number of suites = 4
        for(int i = 0; i < suite.size(); i++)
        {
            // each suite has 13 cards
            for(int j = 0; j < 13; j++)
            {
                if(j == 0) // Ace face
                {
                    Card card = new Card(suite.get(i), faces.get(0));
                    Deck.add(card);
                }
                if(j > 9)
                {
                    Card card = new Card(suite.get(i), faces.get(facesIndex++));
                    Deck.add(card);
                }
                else
                if(j != 0 && j < 11)
                {
                    j++;
                    Card card = new Card(suite.get(i), j);
                    Deck.add(card);
                    j--;
                }
            }
            facesIndex = 1;
        }
    }

    /**
     * Method to shuffle deck.
     */
    public void shuffleDeck()
    {
        Collections.shuffle(Deck);
    }

    /**
     * Method to draw a card from top of deck.
     */
    public void drawCard()
    {
        if(Deck.get(0).getValue() > 0)
        {
            int value = Deck.get(0).getValue();
            Card card = new Card(Deck.get(0).getSuite(), value);
            Hand.add(card);
        }
        else
        {
            String face = Deck.get(0).getFaceValue();
            Card card = new Card(Deck.get(0).getSuite(), face);
            Hand.add(card);
        }
        Deck.remove(0);
    }

    /**
     * Method to draw a number of cards 'n' into a hand.
     * 
     * @param n number of cards wanted
     */
    public void drawHand(int n)
    {
        if(!Hand.isEmpty())
        {
            Hand.clear();
        }

        for(int i = 0; i < n; i++)
        {
            drawCard();
        }
    }

    /**
     * Method to calculate probability of getting one Pair in a hand.
     * 
     * @param n number of trials
     * @param c number of cards in a hand
     * @return double probability
     */
    public double pair(int n, int c)
    {
        int successes = 0;
        int match = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);
            for(int j = 0; j < Hand.size(); j++)
            {
                for(int k = j+1; k < Hand.size(); k++)
                {
                    if((Hand.get(j).getValue() == 0 && Hand.get(k).getValue() == 0) && Hand.get(j).getFaceValue().equals(Hand.get(k).getFaceValue()))
                    {
                        match++;
                    }
                    else
                    if((Hand.get(j).getValue() != 0 && Hand.get(k).getValue() != 0) && (Hand.get(j).getValue() == Hand.get(k).getValue()))
                    {
                        match++;
                    }
                }
            }

            if(match == 1)
            {
                successes++;
            }
            match = 0;
            populateDeck(Deck);
            shuffleDeck();
        }
        
        return (double) successes/n*100;
    }

    /**
     * Method to calculate probability of getting Three of a Kind in a hand.
     * 
     * @param n number of trials
     * @param c number of cards in a hand
     * @return double probability
     */
    public double three(int n, int c)
    {   
        int successes = 0;
        int match = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);
            for(int j = 0; j < Hand.size(); j++)
            {
                for(int k = j+1; k < Hand.size(); k++)
                {
                    if((Hand.get(j).getValue() == 0 && Hand.get(k).getValue() == 0) && Hand.get(j).getFaceValue().equals(Hand.get(k).getFaceValue()))
                    {
                        match++;
                    }
                    else
                    if((Hand.get(j).getValue() != 0 && Hand.get(k).getValue() != 0) && (Hand.get(j).getValue() == Hand.get(k).getValue()))
                    {
                        match++;
                    }
                }
            }
            if(match == 3)
            {
                successes++;
            }
            match = 0;
            populateDeck(Deck);
            shuffleDeck();
        }
        return (double) successes/n*100;
    }

    // TODO: Straight

    /**
     * Method to calculate probability of getting Flush in a hand.
     * 
     * @param n number of trials
     * @param c number of cards in a hand
     * @return double probability
     */
    public double flush(int n, int c)
    {
        int successes = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);

            if(checkSameSuites(Hand))
            {
                successes++;
            }

            populateDeck(Deck);
            shuffleDeck();
        }
        
        return (double) successes/n*100;
    }
    
    /**
     * Method to calculate probability of getting Full House in a hand.
     * @param n number of trials
     * @param c number of cards
     * @return double probability
     */
    public double fullHouse(int n, int c)
    {
        int successes = 0;
        int match = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);
            for(int j = 0; j < Hand.size()-1; j++)
            {
                for(int k = j+1; k < Hand.size(); k++)
                {
                    if((Hand.get(j).getValue() == 0 && Hand.get(k).getValue() == 0) && Hand.get(j).getFaceValue().equals(Hand.get(k).getFaceValue()))
                    {
                        match++;
                    }
                    else
                    if((Hand.get(j).getValue() != 0 && Hand.get(k).getValue() != 0) && (Hand.get(j).getValue() == Hand.get(k).getValue()))
                    {
                        match++;
                    }
                }
            }

            if(match == 4)
            {
                successes++;
            }
            match = 0;
            populateDeck(Deck);
            shuffleDeck();
        }
        return (double) successes/n*100;
    }

    /**
     * Method to calculate probability of Four of a Kind in a hand.
     * 
     * @param n number of trials
     * @param c number of cards wanted in a hand
     * @return double probability
     */
    public double four(int n, int c)
    {
        int successes = 0;
        int match = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);
            for(int j = 0; j < Hand.size(); j++)
            {
                for(int k = j+1; k < Hand.size(); k++)
                {
                    if((Hand.get(j).getValue() == 0 && Hand.get(k).getValue() == 0) && Hand.get(j).getFaceValue().equals(Hand.get(k).getFaceValue()))
                    {
                        match++;
                    }
                    else
                    if((Hand.get(j).getValue() != 0 && Hand.get(k).getValue() != 0) && (Hand.get(j).getValue() == Hand.get(k).getValue()))
                    {
                        match++;
                    }
                }

                if(match == 3)
                {
                    successes++;
                }
                match = 0;
            }

            populateDeck(Deck);
            shuffleDeck();
        }

        return (double) successes/n * 100;
    }

    // TODO: Straight flush

    // TODO: Royal flush -- ask does order matter -- can it be J K 10 A Q
    // royal flush ONLY has A K Q J 10 with all in the SAME suit
    /**
     * Method to calculate probability of Royal Flush in a hand
     * 
     * @param n number of trials
     * @param c number of cards wanted in a hand
     * @return double probabilty
     */
    public double royalFlush(int n, int c)
    {
        int successes = 0;

        shuffleDeck();

        for(int i = 0; i < n; i++)
        {
            drawHand(c);

            if(checkSameSuites(Hand))
            {
                if(checkRoyalFlush(Hand))
                {
                    successes++;
                }
            }

            populateDeck(Deck);
            shuffleDeck();
        }

        return (double) successes/n * 100;
    }
    
    /**
     * Method to check if cards in a hand have the same suite.
     * 
     * @param h ArrayList of hand
     * @return boolean true if all suites match
     */
    public boolean checkSameSuites(ArrayList<Card> h)
    {
        int match = 0;
        for(int i = 1; i < h.size(); i++)
        {
            if(h.get(0).getSuite().equals(h.get(i).getSuite()))
            {
                match++;
            }
        }

        if(match == h.size()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method to check if a hand is a royal flush
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean checkRoyalFlush(ArrayList<Card> h)
    {
        ArrayList<String> faces = new ArrayList<>();  
        faces.add("A");
        faces.add("J");
        faces.add("Q");
        faces.add("K");

        int match = 0;

        for(int i = 0; i < h.size(); i++)
        {
            if(h.get(i).getValue() == 0)
            {
                for(int j = 0; j < faces.size(); j++)
                {
                    if(h.get(i).getFaceValue().contains(faces.get(j)))
                    {
                        match++;
                        break;
                    }
                }
            }
            else
            {
                if(h.get(i).getValue() == 10)
                {
                    match++;
                }
            }
        }

        if(match == 5)
        {
            return true;
        }
        return false;
    }
    
    public void printHand()
    {
        for(int i = 0; i < Hand.size(); i++)
        {
            if(Hand.get(i).getValue() > 0)
            {
                System.out.print("[" + Hand.get(i).getSuite() + " " + Hand.get(i).getValue() + "] ");
            }
            else
            {
                System.out.print("[" + Hand.get(i).getSuite() + " " + Hand.get(i).getFaceValue() + "] ");
            }
        }
    }
}
