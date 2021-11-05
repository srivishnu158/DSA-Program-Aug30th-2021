import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Sample
{
		/*
		=>Time Complexity:
			   => O(n) copy + nlog(n) sort +  O(n) lookUpMap + O(n) result
			   => O(3n) + nlog(n) = nlog(n)

			   Space Complexity:
			   =>O(n) copy + O(n) map = O(2n) = O(n)
		*/
	public int[] getSmallerNumbers(int[] inputArr)
	{
		Map<Integer,Integer> map = new HashMap<>();
		int[] outputArr = new int[inputArr.length];

		for(int i = 0 ; i < inputArr.length ; i++)
		{
			outputArr[i] = inputArr[i];
		}

		Arrays.sort(inputArr);

		for(int i = 0 ; i < inputArr.length ; i++)
		{
				map.putIfAbsent(inputArr[i],i);
		}

		for(int i = 0 ; i < outputArr.length ; i++)
		{
			outputArr[i] = map.get(outputArr[i]);
		}

		return outputArr;
	}
}

public class SmallerNumbersEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {8,1,2,2,3,8,8};
		int[] outputArr = s.getSmallerNumbers(arr);
		for(int i = 0 ; i < outputArr.length ; i++)
		{
			System.out.print(outputArr[i]+" , ") ;
		}
	}
}




