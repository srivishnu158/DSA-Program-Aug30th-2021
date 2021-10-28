import java.util.Set;
import java.util.LinkedHashSet;

class Sample
{

    /* 
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public int[] removeDuplicates(int[] arr)
    {
        Set<Integer> set = new LinkedHashSet<>();

        for(int i = 0 ; i < arr.length; i++)
        {
            set.add(arr[i]);
        }

        int[] result  = new int[set.size()];
        int i = 0;
        for(Integer element:set)
        {
            result[i] = element;
            i++;

        }
        return result;
    }
}

public class RemoveDuplicatesApp
{
    public static void main(String args[])
    {
        Sample s = new Sample();
        int[] arr = {15,1,12,12,15};
       int[] result =  s.removeDuplicates(arr);

        for(int i = 0 ; i < result.length; i++)
        {
            System.out.print(result[i]+ " -> ");
        }
    }
}