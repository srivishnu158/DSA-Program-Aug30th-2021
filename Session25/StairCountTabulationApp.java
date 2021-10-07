
class Sample
{

	public int stairCount(int n)
	{
		int[] dp = new int[n+1];
		for(int i = 0 ; i <= n ; i++)
		{
			dp[i] = -1;
		}

		dp[0] = 1; // reach target 0 , {}
		dp[1] = 1; // reach target 1, {1}
		dp[2] = 2; // reach target 2 , {1,1} {2}

		for( int i = 3 ; i <= n ; i++)
		{
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		return dp[n];
	}

}


public class StairCountTabulationApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" StairCount(4) "+s.stairCount(4));
	}
}









