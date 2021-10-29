import java.util.Set;
import java.util.HashSet;

class Sample
{
		
  /*
	Time Complexity : O(nk)
	Space Complexity: O(1)

		
	{1,2,3,1,2,3} k = 2
		i=0
		j = 0 
	i=1
	j=0 0 < 1 1== 2  j=1 1<1

	i=2 
	j= 0  0 < 2 ::  1 == 3  , 2 == 3 

	i= 3
	j = 3-2 =1 1 < 3  2 == 1 || 3== 1

	i= 4
	j= 2

*/
	
	public boolean isDuplicateExist(int[] arr, int k) 
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
				for(int j = Math.max(i-k,0) ; j < i ; j++)
				{
						if(arr[i] == arr[j])
								return true;
				}
		}

		return false;
	}

	/*
		Time Complexity : O(n) 
		Space Complexity : O(min(n,k))  
	*/
	public boolean isDuplicateExist2(int[] arr, int k) 
	{ 
		Set<Integer> set = new HashSet<>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(set.contains(arr[i]))
				return true;

			set.add(arr[i]);

			if(set.size() > k)
			{
				int element = arr[i-k];
				set.remove(element);
			}
		}

		return false;
	}

}

public class WindowSizeApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {1,2,3,1,2,3};
		System.out.println("With Set = " +s.isDuplicateExist2(arr,3));
	}
}