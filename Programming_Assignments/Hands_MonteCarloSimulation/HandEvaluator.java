package Programming_Assignments.Hands_MonteCarloSimulation;

import java.util.ArrayList;
import java.util.Collections;

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
            for(int j = 0; j < 14; j++)
            {
                if(j == 13) // Ace face
                {
                    Card card = new Card(suite.get(i), faces.get(0), j+1);
                    Deck.add(card);
                }
                if(j > 10)
                {
                    Card card = new Card(suite.get(i), faces.get(facesIndex++), j);
                    Deck.add(card);
                }
                else
                if(j != 0 && j < 10)
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
        if(Deck.get(0).getValue() < 11)
        {
            int value = Deck.get(0).getValue();
            Card card = new Card(Deck.get(0).getSuite(), value);
            Hand.add(card);
        }
        else
        {
            String face = Deck.get(0).getFaceValue();
            int value = Deck.get(0).getValue();
            Card card = new Card(Deck.get(0).getSuite(), face, value);
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
     * Method to run Monte Carlo Simulation of poker hands.
     * 
     * @param n number of trials
     * @param c number of cards wanted in hand
     */
    public void runMonteCarlo(int n, int c)
    {
        shuffleDeck();

        int pairs = 0, threes = 0, straights = 0, flushes = 0, fullhouses = 0, fours = 0, straightFlushes = 0, royalFlushes = 0;
        for(int i = 0; i < n; i++)
        {
            drawHand(c);

            if(pair(Hand))
            {
                pairs++;
            }
            else
            if(three(Hand))
            {
                threes++;
            }
            else
            if(straight(Hand))
            {
                straights++;
            }
            else
            if(flush(Hand))
            {
                flushes++;
            }
            else
            if(fullHouse(Hand))
            {
                fullhouses++;
            }
            else
            if(four(Hand))
            {
                fours++;
            }
            if(straightFlush(Hand))
            {
                straightFlushes++;
            }
            if(royalFlush(Hand))
            {
                royalFlushes++;
            }

            populateDeck(Deck);
            shuffleDeck();
        }

        System.out.println("\nProbability of Success for **Pair**: " + (double) pairs/n*100 + "%");
        System.out.println("\nProbability of Success for **Three of a Kind**: " + (double) threes/n*100 + "%");
        System.out.println("\nProbability of Success for **Straight**: " + (double) straights/n*100 + "%");
        System.out.println("\nProbability of Success for **Flush**: " + (double) flushes/n*100 + "%");
        System.out.println("\nProbability of Success for **Full House**: " + (double) fullhouses/n*100 + "%");
        System.out.println("\nProbability of Success for **Four of a Kind**: " + (double) fours/n*100 + "%");
        System.out.println("\nProbability of Success for **Straight Flush**: " + (double) straightFlushes/n*100 + "%");
        System.out.println("\nProbability of Success for **Royal Flush**: " + (double) royalFlushes/n*100 + "%");
    }

    /**
     * Method to check if hand contains Pair.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean pair(ArrayList<Card> h)
    {
        if(checkMatches(h, 1))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Three of a Kind.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean three(ArrayList<Card> h)
    {
        if(checkMatches(h, 3))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Straight.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean straight(ArrayList<Card> h)
    {
        if(!checkSameSuites(h))
        {
            if(checkStraight(h))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if a hand contains Flush.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean flush(ArrayList<Card> h)
    {
        if(checkSameSuites(h))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Full House.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean fullHouse(ArrayList<Card> h)
    {
        if(checkMatches(h, 4))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Four of a Kind..
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean four(ArrayList<Card> h)
    {
        int match = 0;
        for(int j = 0; j < h.size(); j++)
        {
            for(int k = j+1; k < h.size(); k++)
            {
                if(h.get(j).getValue() == h.get(k).getValue())
                {
                    match++;
                }
            }

            if(match == 3)
            {
                return true;
            }
            match = 0;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Straight Flush.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean straightFlush(ArrayList<Card> h)
    {
        if(checkSameSuites(h) && checkStraight(h))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if a hand contains Royal Flush.
     * 
     * @param h ArrayList hand
     * @return boolean
     */
    public boolean royalFlush(ArrayList<Card> h)
    {
        if(checkSameSuites(h) && checkRoyalFlush(h))
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if cards in a deck are a number of matches.
     * 
     * @param h ArrayList of hand
     * @param num number of cards to match in a hand
     * @return boolean true if matches equal num
     */
    public boolean checkMatches(ArrayList<Card> h, int num)
    {
        int match = 0;
        for(int j = 0; j < Hand.size(); j++)
        {
            for(int k = j+1; k < Hand.size(); k++)
            {
                if(Hand.get(j).getValue() == Hand.get(k).getValue())
                {
                    match++;
                }
            }
        }

        if(match == num)
        {
            return true;
        }
        return false;
    }

    /**
     * Method to check if cards in a hand are a Straight.
     * 
     * @param h ArrayList hand
     * @return boolean true if cards are a straight
     */
    public boolean checkStraight(ArrayList<Card> h)
    {
        int inHand = 0;

        // find the max value in a hand
        int max = h.get(0).getValue();
        for(int i = 1; i < h.size(); i++)
        {
            if(h.get(i).getValue() > max)
            {
                max = h.get(i).getValue();
            }
        }

        // get range of values - max - 5 and insert into values array
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = max; i > max-5; i--)
        {
            values.add(i);
        }

        // check if hand contains values and remove values
        for(int i = 0; i < h.size(); i++)
        {
            for(int j = 0; j < values.size(); j++)
            {
                if(h.get(i).getValue() == values.get(j))
                {
                    inHand++;
                    values.remove(j);
                }
            }
        }

        if(inHand == 5)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Method to check if cards in a hand have the same suite.
     * 
     * @param h ArrayList hand
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
     * Method to check if a hand is a Royal Flush.
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
            if(h.get(i).getValue() > 10)
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

    /**
     * Method to print out cards in Deck
     */
    public void printDeck()
    {
        for(int i = 0; i < Deck.size(); i++)
        {
            if(Deck.get(i).getValue() < 11)
            {
                System.out.print("[" + Deck.get(i).getSuite() + " " + Deck.get(i).getValue() + "] ");
            }
            else
            {
                System.out.print("[" + Deck.get(i).getSuite() + " " + Deck.get(i).getFaceValue() + "] ");
            }
        }
        System.out.println();
    }
    
    /**
     * Method to print out cards in hand.
     */
    public void printHand()
    {
        for(int i = 0; i < Hand.size(); i++)
        {
            if(Hand.get(i).getValue() < 11)
            {
                System.out.print("[" + Hand.get(i).getSuite() + " " + Hand.get(i).getValue() + "] ");
            }
            else
            {
                System.out.print("[" + Hand.get(i).getSuite() + " " + Hand.get(i).getFaceValue() + "] ");
            }
        }
        System.out.println();
    }
}
