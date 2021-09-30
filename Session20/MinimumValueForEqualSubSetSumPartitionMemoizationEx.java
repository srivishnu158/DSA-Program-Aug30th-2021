class Sample
{
	public int recursive(int[] arr)
	{
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++)
		{
			sum = sum+arr[i];
		}

		int[][] dp = new int[arr.length][sum+1];
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int s = 0 ; s <= sum ; s++)
			{
				dp[i][s] = -1;
			}
		}
		int currentIndex = 0;
		return memoization(arr,sum,currentIndex,dp,0,0);

	}

	/*

		Time Complexity : O(n*s)
		Space Complexity : O(n*s) 
		// Consider we are creating O(n) stack frames, this is riskier
	*/
	public int memoization(int[] arr, 
		int sum, 
		int currentIndex, 
		int[][] dp,
		int includeSum, 
		int excludeSum)
	{

			// Calculate the Diff when reached to end of the Array
		if(currentIndex == arr.length)
			{
				return Math.abs(includeSum-excludeSum);
			}
			

			if(dp[currentIndex][sum] != -1)
			{
				return dp[currentIndex][sum];
			}

			int includeDiff = memoization(arr,
					sum-arr[currentIndex],
					currentIndex+1,
					dp,
					includeSum+arr[currentIndex], // Weight added to includeSum
					excludeSum);

			int excludeDiff = memoization(arr,
				sum-arr[currentIndex],
				currentIndex+1,
				dp,
				includeSum,
				excludeSum+arr[currentIndex]); // Weight added to excludeSum

			// Get Minimun Diff
			dp[currentIndex][sum] = Math.min(includeDiff,excludeDiff);

			return dp[currentIndex][sum];

	}

}

public class MinimumValueForEqualSubSetSumPartitionMemoizationEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {1,2,7};

		int result = s.recursive(arr);
		System.out.println(" Memoization Result :: "+result);

	}
}















