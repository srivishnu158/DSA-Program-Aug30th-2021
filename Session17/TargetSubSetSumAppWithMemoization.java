class Sample
{


/*
	Here the subProblem can be derived based on index & targetSum 
	so that design a matrix by choosing these two fields.

		Time Complexity => O(n*c)
		Space Complexity => O(n*c)
*/

	public boolean isSubsetFound(int[] arr, int targetSum)
	{

			int currentIndex = 0;
			Boolean[][] dp = new Boolean[arr.length][targetSum+1];
			// Take wrapper type Boolean so that default value would be null

			return memoizationApproch(arr,currentIndex,targetSum,dp);
	}


	
	public boolean memoizationApproch(int[] arr, 
		int currentIndex, int targetSum,Boolean[][] dp)
	{

			int n = arr.length;


			if(targetSum == 0)
			{
				return true;
			}

			if(currentIndex >= n)
			{
				return false;
			}

			if(dp[currentIndex][targetSum] != null)
			{
				return dp[currentIndex][targetSum];
			}

			//System.out.println("subProblem( i:"+currentIndex+" , s: "+targetSum+")");

			if(arr[currentIndex] <= targetSum)
			{
					//Including Element
				boolean  includeFlag = memoizationApproch(arr,currentIndex+1, 
					targetSum-arr[currentIndex],dp);

				//without Including Element
				boolean excludeFlag = memoizationApproch(arr,currentIndex+1,
					targetSum,dp);

				dp[currentIndex][targetSum] = includeFlag || excludeFlag;
			}else // arr[currentIndex] > targetSum
			{
				dp[currentIndex][targetSum] =
				 memoizationApproch(arr, currentIndex+1 , targetSum,dp);
			}

			return dp[currentIndex][targetSum];
	}
}



public class TargetSubSetSumAppWithMemoization
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {1,3,5};
		int currentIndex = 0;
		int  targetSum= 8;
	boolean result =	s.isSubsetFound(arr,targetSum);
	System.out.println("Is Subset Found "+targetSum+"? " +result); 
		

	}
}











