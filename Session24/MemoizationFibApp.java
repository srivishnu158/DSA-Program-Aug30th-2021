class Sample
{

	public int fib(int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++)
		{
			dp[i] = -1;
		}

		
		return memoization(n,dp);
	}

	public int memoization(int n, int[] dp)
	{

			if(dp[n] != -1)
			{
				return dp[n];
			}


		dp[n] = memoization(n-1,dp) + memoization(n-2,dp);

		return dp[n];
	}
}

public class MemoizationFibApp // 1,1,2,3,5,8,13,21
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" Memoization 7 fib = "+s.fib(7));
	}
}