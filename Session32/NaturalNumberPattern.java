
// {4,2,1,5} n-1 , Identify missing element : 3
// totalSumOfArray = 12
// n = {1,2,3,4,5} = totalSumOfn = 15
// Missing Element  = totalSumOfn - totalSumOfArray = 15 - 12 = 3


class Sample
{

	/*
		Time Complexity O(n)

		Space Complexity O(1)
	*/
	public int missingNumber(int[] arr, int n)
	{
		int totalSumn = 0;

		/*
		for(int i = 1 ; i <=n ; i++)
		{
			totalSumn = totalSumn+i;
		}
		*/

		totalSumn = n*(n+1) / 2;

		int totalSumArray = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			totalSumArray = totalSumArray+arr[i];
		}

		return totalSumn - totalSumArray;
	}
}

public class NaturalNumberPattern
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {3,2,1,5};

		int result = s.missingNumber(arr,5);
		System.out.println(" Missing Number :: "+result);
	}
}







