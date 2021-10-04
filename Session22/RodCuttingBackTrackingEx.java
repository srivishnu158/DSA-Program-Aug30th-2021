class Sample
{
		/*
			Time Complexity : dp[n][c] =>  O(n*c) 
			Space Complexity :  O(n*c)
		*/

	public int tabulationApproach(int[] lengths, int[] prices,int capacity)
	{

		if(lengths.length != prices.length)
				{
					return -1;
				}

		int n = prices.length;

		int[][] dp = new int[n][capacity+1];

		// for length 0 for an given element profit would be 0
		for(int  i = 0 ; i < n ; i++)
		{
			dp[i][0] = 0;
		}

		// Solving problem for 1st element its in 0th index
		for(int c = 1 ; c <= capacity ; c++)
		{
			if(lengths[0] <= c)
			{
					dp[0][c] = prices[0] + dp[0][c-lengths[0]];
			}
			else
			{
				dp[0][c] = 0;
			}
		}

		for(int i = 1 ; i < n ; i++)
		{
			for(int c = 1 ; c <= capacity ; c++)
			{
				if(lengths[i] <= c)
				{
					int exludeProfit = dp[i-1][c];
					int includeProfit = prices[i] + dp[i][c-lengths[i]];
					dp[i][c] = Math.max(exludeProfit,includeProfit);
				}else
				{
					dp[i][c] = dp[i-1][c];
				}
			}
		}

		printSelectedItems(dp,capacity,lengths,prices);
		return dp[n-1][capacity];
	}

	public void printSelectedItems(int[][]dp , int capacity, 
		int[] lengths, int[] prices )
	{
		int i = prices.length-1;
		int totalProfit = dp[i][capacity];

		while( i > 0  && totalProfit > 0)
		{
			if(dp[i][capacity]  != dp[i-1][capacity])
			{
				System.out.print(lengths[i]+ "  ~ ");
				totalProfit = totalProfit - prices[i];
				capacity = capacity - lengths[i]; 
			}else
			{
				i--;
			}
		}

		while(totalProfit > 0 )
		{
			System.out.print(lengths[0] + " ~ ");
			totalProfit = totalProfit - prices[0];
		}


	}
}

public class RodCuttingBackTrackingEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] lengths = {1, 2, 3, 4, 5};
		int[] prices = {2, 6, 7, 10, 13};
		int capacity = 5;

		int maxProfit = s.tabulationApproach(lengths,prices,capacity);
		System.out.println(" \n MaxProfit => "+ maxProfit);
		
	}
}










