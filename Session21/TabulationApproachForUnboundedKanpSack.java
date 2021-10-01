class Sample
{
		/*
			Time Complexity : dp[n][c] =>  O(n*c) 
			Space Complexity :  O(n*c)
		*/

	public int tabulationApproach(int[] weights, int[] profits,int capacity)
	{

			if(weights.length != profits.length)
			{
				return -1;
			}
			int n = weights.length;

			int[][] dp = new int[n][capacity+1];

			// With Capacity '0', all items gives zero profit

			for(int i = 0 ; i < n ; i++)
			{
				dp[i][0] = 0;
			} 

			// Give a optimised Solution to item 1

			for(int c = 1; c <= capacity ; c++)
			{
				if(weights[0] <= c)
				{
					dp[0][c] = profits[0] + dp[0][c - weights[0]];
				}else
				{
					dp[0][c] = 0;
				}
			} 

			for(int i = 1 ; i < n ; i++)
			{
				for(int c = 1 ; c <= capacity ; c++)
				{
					if(weights[i] <= c)
					{
							//find profit Including current Item
						int profit1 =  profits[i] + dp[i][c-weights[i]];

							//find profit Without including currentItem
						int profit2 = dp[i-1][c];

							// Get max out of it
						dp[i][c] = profit1 > profit2 ? profit1 : profit2;
					}else // As weights[i] >c, find profit Without including currentItem
					{
							dp[i][c] =  dp[i-1][c];
					}
				}
			}

			return dp[n-1][capacity];
	}
}

public class TabulationApproachForUnboundedKanpSack
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] weights = {1,2,3};
		int[] profits = {5,2,4};
		int capacity = 5;

		int maxProfit = s.tabulationApproach(weights,profits,capacity);
		System.out.println(" MaxProfit => "+ maxProfit);
		
	}
}










