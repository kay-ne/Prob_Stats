package StatsLibrary.Chapter2.SetOperations;

import java.util.ArrayList;

public class SetOperations {

    /**
     * Method for a union of two ArrayLists
     * 
     * @param a first ArrayList containing Strings
     * @param b second ArrayList containing Strings
     * @return ArrayList result of a union of ArrayLists a and b
     */
    public ArrayList<String> union(ArrayList<String> a, ArrayList<String> b)
    {
        ArrayList<String> result = new ArrayList<>();

        for(String e : a)
        {
            result.add(e);
        }

        for(int i = 0; i < result.size();)
        {
            for(int j = 0; j < b.size(); j++)
            {
                if(!(result.get(i).equals(b.get(j))))
                {
                    result.add(b.get(j));
                }
            }
            break;
        }

        return result;
    }

    /**
     * Method for an intersection of two ArrayLists
     * 
     * @param a first ArrayList containing Strings
     * @param b second ArrayList containing Strings
     * @return ArrayList result of intersecting ArrayLists a and b
     */
    public ArrayList<String> intersect(ArrayList<String> a, ArrayList<String> b)
    {
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < a.size();)
        {
            for(int j = 0; j < b.size(); j++)
            {
                if(a.get(i).equals(b.get(j)))
                {
                    result.add(a.get(i));
                }
            }
            break;
        }

        return result;
    }
    
    /**
     * Method for a complement of subset A of full set S
     * 
     * @param S full set
     * @param a subset of S
     * @return ArrayList result of A complement
     */
    public ArrayList<String> complement(ArrayList<String> S, ArrayList<String> a)
    {
        ArrayList<String> result = new ArrayList<>();
        int complementSize = S.size() - a.size();

        for(String e : S)
        {
            result.add(e);
        }

        for(int i = 0; i < S.size(); i++)
        {
            for(int j = 0; j < a.size(); j++)
            {
                if(S.get(i).equals(a.get(j)))
                {
                    result.remove(result.indexOf(S.get(i)));
                }
            }
            if(result.size() == complementSize)
            {
                break;
            }
        }

        return result;
    }
}
