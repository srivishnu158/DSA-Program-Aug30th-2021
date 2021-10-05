class Sample
{

	public int minmalCoins(int[] coins, int capacity)
	{

		int n = coins.length;
		int[][] dp = new int[n][capacity+1];

		// For 0 capacity for any given elements minimal note is zero

		for(int i = 0 ; i < n ; i++)
		{
			dp[i][0] = 0;
		}

		// For element 1 (i.e index 0), we can't compare so the value would be 1+dp[0][c-w[o]]

		for(int c = 1 ; c <= capacity ; c++)
		{
			if(coins[0] <= c)
			{
				dp[0][c] = 1+dp[0][c-coins[0]];
			}else
			{
				dp[0][c] = 0;
			}

		}

		for(int i = 1 ; i < n ; i++)
		{
			for(int c = 1 ; c <= capacity ; c++)
			{
				if(coins[i] <= c)
				{
						int includeCount  = 1 + dp[i][c-coins[i]];
						int exlcudeCount = dp[i-1][c];

						dp[i][c] = Math.min(includeCount,exlcudeCount);
				}else
				{
					dp[i][c] = dp[i-1][c];
				}
			}
		}

		return dp[n-1][capacity];

	}


}


	public class MinimalCoinsApp
	{
		public static void main(String args[])
		{

			int[] coins = {1,2,5,20};
			int capacity = 5;

			Sample s = new Sample();
			int result = s.minmalCoins(coins,capacity);

			System.out.println(" Minimum coins Needed !!! "+result);
		}
	}













