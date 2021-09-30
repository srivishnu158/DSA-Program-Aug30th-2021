class Sample
{

	public int recursive(int[] arr, int sum)
	{
		int[][] dp = new int[arr.length][sum+1];

		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int s = 0 ; s <= sum ; s++)
			{
				dp[i][s] = -1;
			}
		}

		int currentIndex = 0;

		return memoization(arr,sum,currentIndex,dp);
	}


		/*

		Time Complexity : O(n*s)
		Space Complexity : O(n*s) 
		// Consider we are creating O(n) stack frames, this is riskier
	*/
	public int memoization(int[] arr, int sum , int currentIndex, int[][] dp)
	{

			if(sum == 0)
			{
				return 1;
			}

			if(currentIndex >= arr.length)
			{
				return 0;
			}

			if(dp[currentIndex][sum] != -1)
			{
				return dp[currentIndex][sum];
			}

			if(arr[currentIndex] <= sum)
			{
				int includeCount = 
				memoization(arr,sum-arr[currentIndex],currentIndex+1,dp);

				int excludeCount = 
				memoization(arr,sum,currentIndex+1,dp);

				dp[currentIndex][sum] = includeCount + excludeCount;
			}else
			{
			dp[currentIndex][sum] =	memoization(arr,sum,currentIndex+1,dp);
			}

			return dp[currentIndex][sum];
	}

}

public class TotalSubSetCountMemoizationEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {2,3,5};

		int result2 = s.recursive(arr,5);

		System.out.println(" Memoization SubSet Count :: "+result2);
	}
}








