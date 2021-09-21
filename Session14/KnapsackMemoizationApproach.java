class Sample
{

	/*
		Time Complexity : O(n*capacity) , 
		As we derive max possible subproblems dp[n][capacity] => n*capacity

		Space Complexity : O(n*capacity)
	*/

	public int knapsackProblem(int[] weights, int[] profits, 
		int currentIndex , int capacity)
	{

		// Base checks
		if(weights.length != profits.length) 
		{
			return -1;
		}
		int n = weights.length;

		int[][] dp = new int[n][capacity+1];

		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j <= capacity ; j++)
			{
				dp[i][j] = -1;
			}
		}

		return memoizationApproach(weights,profits, currentIndex,capacity,dp);
	}

	public int  memoizationApproach(int[] weights, int[] profits, 
		int currentIndex , int capacity, int[][] dp)
	{

		if( capacity == 0 || currentIndex >= weights.length)
		{
			return  0;
		}

		if(dp[currentIndex][capacity] != -1)
		{
				return dp[currentIndex][capacity];
		}

		if(weights[currentIndex] <= capacity)
		{
			int profit1 = profits[currentIndex] + 
						memoizationApproach(weights,profits,
							currentIndex+1,capacity-weights[currentIndex],dp);

			int profit2 = memoizationApproach(weights,profits,
				currentIndex+1,capacity,dp);

			dp[currentIndex][capacity] =
			 profit1 > profit2 ? profit1 : profit2;
		}
		else
		{
		dp[currentIndex][capacity] = memoizationApproach(weights,profits,
				currentIndex+1,capacity,dp);
		}

		return	dp[currentIndex][capacity];
	}
}


public class KnapsackMemoizationApproach
{
	public static void main(String args[])
	{
			Sample s = new Sample();
		int[] weights = {1,2,3};
		int[] profits = {5,2,4};
		int currentIndex = 0;
		int capacity = 5;

		int maxProfit = s.knapsackProblem(weights,profits,currentIndex,capacity);

		System.out.println(" MaxProfit => "+maxProfit);
	}
}





/*
Logic to test timetaken on higher inputs

public static void main(String args[])
	{
		Sample s = new Sample();
		int[] weights = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		int[] profits = {1,3,5,7,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,1,3,5,7,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45};
		int currentIndex = 0;
		int capacity = 110;

		long startTime = System.currentTimeMillis();

		int maxProfit = s.knapsackProblem(weights,profits,currentIndex,capacity);

		long endTime = System.currentTimeMillis();

		System.out.println(" MaxProfit => "+maxProfit);

		System.out.println(" Time Taken => "+(endTime - startTime));

	}

*/







