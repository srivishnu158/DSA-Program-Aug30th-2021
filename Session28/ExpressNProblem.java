class Sample
{

	/*
		Time Complexity = O(3^n)
		Space Complexity = O(n)
	*/
	public int recursive(int n)
	{
		if(n == 0)
			{
				return 1;
			}

		if( n == 1)  // {1}
			{
				return 1;
			}

		if(n == 2) //{1,1}
			{
				return 1;
			}

		if( n == 3) //{1,1,1} {3}
			{
				return 2;
			}

		return recursive(n-1) + recursive(n-3) + recursive(n-4);
	}

	/*
		Time Complexity = O(n)
		Space Complexity = O(n)
	*/
		public int memoization(int n)
		{
			int[] dp = new int[n+1];
			for(int  i = 0 ; i <= n ; i++)
			{
				dp[i] = -1;
			}

			dp[0] = 1; 
			dp[1] = 1; // {1}
			dp[2] = 1; // {1,1}
			dp[3] = 2; // {1,1,1} {3}

			return memoization(n,dp);
		}

		public int memoization(int n , int[] dp)
		{
			if( dp[n] != -1)
			{
				return dp[n];
			}

			dp[n] = memoization(n-1,dp) + 
					memoization(n-3,dp)
					+memoization(n-4,dp);

			return dp[n];
		}

	/*
		Time Complexity = O(n)
		Space Complexity = O(n)
	*/
	public int tabulation(int n)
	{
		int[] dp = new int[n+1];
		
			dp[0] = 1; 
			dp[1] = 1; // {1}
			dp[2] = 1; // {1,1}
			dp[3] = 2; // {1,1,1} {3}

			for(int i = 4 ; i <= n ; i++)
			{
				dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
			}

			return dp[n];
	}
}

public class ExpressNProblem
{
	public static void main(String args[])
	{
		Sample  s = new Sample();

			int n = 6;
		System.out.println(" Recursive = "+s.recursive(n));
		
		System.out.println(" Memoization = "+s.memoization(n));

		System.out.println(" Tabulation = "+s.tabulation(n));

	}
}























