import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Sample
{
	/*
	 	Time Complexity = O(n)  ===> 2 Passes
	 	Space Complexity = O(n)
	*/

	public int getUniqueElement(int[] arr)
	{
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < arr.length ; i++)
		{
			Integer currentCount = map.get(arr[i]);
			if( currentCount == null)
			{
				map.put(arr[i] , 1);
			}else
			{
				map.put(arr[i],currentCount+1);
			}
		}
	
		int minValue = arr[0];
		for(int i = 1; i < arr.length ; i++)
		{
			int count  = map.get(arr[i]);
			if(count == 1)
			{
				minValue = arr[i];
				break;
			}
		}

		return minValue;
	}


	/*
	 	Time Complexit = O(n)  ===> 1 Pass {2,3,1,2,3} ** Single Pass
	 	Space Complexity = O(n)

	 	(a+b+c) - (a+b) = c

	*/
	public int getUniqueElement2(int[] arr)
	{
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;

		for(int i = 0 ; i < arr.length ; i++)
		{
			if(set.add(arr[i])) // add() method returs true if element is added
								// add() method returs false if element is not added
			{

				sum = sum + arr[i];
			}else
			{
				sum = sum - arr[i];
			}
		}

		return sum;
	}


	/*
	 	Time Complexit = O(n)  ===> 1 Pass {2,3,1,2,3} ** Single Pass
	 	Space Complexity = O(1)

	 	(a+b+c) - (a+b)  = c
	 	a-a + b-b + c = 0 + 0 + c = c
	 	a X-OR a + b X-OR b + c =  0 + 0 + c = c


	*/
	public int getUniqueElement3(int[] arr)
	{
		
		int result = 0;

		for(int i = 0 ; i < arr.length ; i++)
		{
			result = result ^= arr[i];
		}

		return result;
	}
}

public class FindUniqueElement
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {10,12,7,5,12,4,4,10,13,7,13};

		System.out.println(s.getUniqueElement3(arr));

	}
}










