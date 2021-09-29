class Sample
{

	public boolean equalSubSetPartition(int[] arr)
	{
		int sum = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			sum = sum+arr[i];
		}

		// Base check for odd sum we can not have equals subset partition
		if(sum % 2 != 0)
		{
			return false;
		}

		return tabulation(arr, sum/2);
	}

	public boolean tabulation(int[] arr, int sum)
	{

		int n = arr.length;
		Boolean[][] dp = new Boolean[n][sum+1];

		// With target 0 we can always have emptySet 

		for(int i = 0 ;  i < n ; i++ )
		{
			dp[i][0] = true;
		}

		// Considering 1st element , when the weight[1st] == target then its true

		for(int s = 1 ; s <= sum ; s++)
		{
			if (arr[0] == s)
			{
				dp[0][s] = true;
			}else
			{
				dp[0][s] = false;
			}
		}

		

		for(int i = 1 ; i < n ; i++)
		{
			for(int s = 1 ; s <= sum ; s++)
			{
					if(arr[i] <= s)
					{
						dp[i][s] = dp[i-1][s-arr[i]] || dp[i-1][s];
					}else
					{
						dp[i][s] = dp[i-1][s];
					}
			}
		}
		
		return dp[n-1][sum];
	}

}

public class EqualSubSetSumPartitionEx
{
	public static void main(String[] args)
	{
			Sample s = new Sample();
			int[] arr = {1,2,3,4};

		
			Boolean result = s.equalSubSetPartition(arr);

		System.out.println(" Can Partition Possible ?" + result);


	}
}











