class Sample
{

	public int coinsCount(int[] coins, int capacity)
	{

		int n = coins.length;
		int[][] dp = new int[n][capacity+1];

		// For 0 capacity for any given elements minimal note is zero

		for(int i = 0 ; i < n ; i++)
		{
			dp[i][0] = 1;
		}


		for(int c = 1 ; c <= capacity ; c++)
		{
			
				dp[0][c] = dp[0][c-coins[0]] ;
				

		}

		for(int i = 1 ; i < n ; i++)
		{
			for(int c = 1 ; c <= capacity ; c++)
			{
						if(coins[i] <= c)
						{
						int includeCount  = dp[i][c-coins[i]];
						int exlcudeCount = 	dp[i-1][c];
						dp[i][c] = includeCount + exlcudeCount;
						}else
						{
							dp[i][c] = dp[i-1][c];
						}
						
			
			}
		}

		return dp[n-1][capacity];

	}


}


	public class CoinsChangecount
	{
		public static void main(String args[])
		{

			int[] coins = {1,2,5,20};
			int capacity = 5;

			Sample s = new Sample();
			int result = s.coinsCount(coins,capacity);

			System.out.println(" CoinsCount !!! "+result);
		}
	}













