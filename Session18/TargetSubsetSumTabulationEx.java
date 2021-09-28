class Sample
{

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

public class TargetSubsetSumTabulationEx
{
	public static void main(String[] args)
	{
			Sample s = new Sample();
			int[] arr = {1,3,5};

			int sum = 8;

			Boolean result = s.tabulation(arr,sum);

		System.out.println("With sum = "+sum+" is Subset Possible ? "+result);


	}
}











