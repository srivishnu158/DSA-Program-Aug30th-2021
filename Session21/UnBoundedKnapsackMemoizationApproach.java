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
      //With Including Element
      int profit1 = profits[currentIndex] + 
            memoizationApproach(weights,profits,
              currentIndex,capacity-weights[currentIndex],dp);

          //Without Including Element
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

    return  dp[currentIndex][capacity];
  }
}


public class UnBoundedKnapsackMemoizationApproach
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









