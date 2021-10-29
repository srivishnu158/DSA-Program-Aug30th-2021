import java.util.Map;
import java.util.LinkedHashMap;

class Sample
{
		/*
			Time Complexity : O(n)
			Space Complexity : O(n)
		*/
	public int[] targetSum(int[] arr, int targetSum)
	{
		Map<Integer,Integer> map = new LinkedHashMap<>();
		int[] result = new int[2];
		for(int i = 0 ; i < arr.length ; i++)
		{
			Integer leftValue = targetSum - arr[i];
			Integer earlierIndex = map.get(leftValue);

			if(earlierIndex != null)
			{
				 result[0] = earlierIndex;
				 result[1] = i;
					break;
			}else
			{
				map.put(arr[i],i);
			}
		}

		return result;
	}
}

public class TargetSumApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {2,7,11,15};
		int[] result = s.targetSum(arr,22);
		System.out.println(result[0] + " : "+result[1]);
	}
}

