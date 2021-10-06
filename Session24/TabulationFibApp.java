class Sample
{

	public int tabulation(int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];  
		}

		return dp[n];
	}
}

public class TabulationFibApp // 1,1,2,3,5,8,13,21
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" Memoization 7 fib = "+s.tabulation(7));
	}
}