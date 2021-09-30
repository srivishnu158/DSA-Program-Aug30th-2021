class Sample
{

/*

		Time Complexity : O(n*s)
		Space Complexity : O(n*s) 
*/
	public int minValue(int[] arr)
	{
		int totalSum = 0;
		for(int i = 0 ; i < arr.length; i++)
		{
			totalSum = totalSum+arr[i];
		}

		int sum = totalSum/2;

		Boolean[][] dp = new Boolean[arr.length][sum+1];

		for(int i = 0 ; i < arr.length ; i++)
		{
			dp[i][0] = true;
		}

		for(int s = 1 ; s <= sum ; s++)
		{
			if(arr[0] == s)
			{
				dp[0][s] = true;
			}else
			{
				dp[0][s] = false;
			}
		}

		for(int i = 1; i < arr.length ; i++)
		{
			for(int s = 1 ; s <= sum ; s++)
			{
				if(arr[i] <= s)
						{
							dp[i][s] = dp[i-1][s-arr[i]] || dp[i-1][s];
						}
				else
				{
					dp[i][s]= dp[i-1][s];
				}
			}
		}

		int leftSubSetSum = 0;
		for(int s = sum ; s >= 0 ; s--)
		{
			if(dp[arr.length-1][s] == true)
			{
				leftSubSetSum = s;
				break;
			}
		}

		int rightSubSetSum = totalSum - leftSubSetSum;

		return Math.abs(leftSubSetSum-rightSubSetSum);

		/*
		Math.abs  logic equals to below....
		if(leftSubSetSum > rightSubSetSum)
		{
			return leftSubSetSum - rightSubSetSum;
		}else
		{
			return  rightSubSetSum - leftSubSetSum;
		}
		*/
	}
}

public class MinimumValueForEqualSubSetSumPartitionTabulationEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {1,2,7};
		int result = s.minValue(arr);

		System.out.println(" Tabulation Result :: "+result);
		

	}
}








