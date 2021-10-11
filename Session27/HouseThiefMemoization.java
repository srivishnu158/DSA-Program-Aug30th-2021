class Sample
{

	/*
		TimeComplexity : O(n)
		SpaceComplexity: O(n)
	*/
	public int maxProfit(int[] profits)
	{

		int[] dp = new int[profits.length];
		for(int i = 0 ; i < profits.length; i++)
		{
			dp[i] = -1;
		}

		return memoization(profits,0,dp);
	}
	public int memoization(int[] profits, int currentIndex,int[] dp)
	{

		if(currentIndex >= profits.length)
		{
			return 0;
		}

		//include Profit

			if(dp[currentIndex] != -1)
			{
				return dp[currentIndex];
			}

		int includeProfit = profits[currentIndex] + memoization(profits,currentIndex+2,dp);
		int exludeProfit = memoization(profits,currentIndex+1,dp);

		dp[currentIndex] = Math.max(includeProfit,exludeProfit);
		return dp[currentIndex];


	}
}

public class HouseThiefMemoization
{
	public static void main(String args[])
	{
			Sample s = new Sample();
			int[] profits = {1,5,3};
			int maxProfit = s.maxProfit(profits);
			System.out.println(" Max Profit is "+maxProfit);
	}
}








