class Sample
{
	/*
		TimeComplexity : O(n*s)
		Space Complexity: O(n*s)
	*/
	public int count(int[] arr, int sum)
	{
		int[][] dp = new int[arr.length][sum+1];

		for(int i = 0 ; i < arr.length ; i++)
		{
			dp[i][0] = 1;
		}

		for(int s = 1 ; s <= sum ; s++)
		{
			if(arr[0] == s)
			{
				dp[0][s] = 1;
			}else
			{
				dp[0][s] = 0;
			}
		}

		for(int i = 1; i < arr.length ; i++)
		{
			for(int s = 1 ; s <= sum ; s++)
			{
				if(arr[i] <= s)
						{
							dp[i][s] = dp[i-1][s-arr[i]] + dp[i-1][s];
						}
				else
				{
					dp[i][s]= dp[i-1][s];
				}
			}
		}

		return dp[arr.length-1][sum];
	}
}

public class TotalSubSetCountTabulationEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {2,3,5};
		int result1 = s.count(arr,5);

		System.out.println(" Tabulation SubSet Count :: "+result1);

	}
}








