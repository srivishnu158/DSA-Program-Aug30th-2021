class Sample
{

	public int recursiveApproch(int[] weights , int[] profits , 
		int capacity,int currentIndex)
	{
		if( capacity == 0 || currentIndex >= weights.length)
		{
			return 0;
		}

		if(weights[currentIndex] <= capacity) // currentItem weight <= capacity
		{
			// Incuding current Item
			int profit1 = profits[currentIndex] 
							+ recursiveApproch(weights,profits,
								capacity-weights[currentIndex],currentIndex+1);

			// Excluding Current Item
			int profit2 = 	recursiveApproch(weights,profits,
											capacity,currentIndex+1);

			return profit1 > profit2 ? profit1 : profit2;		
		} else // currentItem weight > capacity
		{
			return recursiveApproch(weights,profits,
											capacity,currentIndex+1);
		}

	}
}

public class KnapsackProblem
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] weights = {1,2,3};
		int[] profits = {5,2,4};
		int currentIndex = 0;
		int capacity = 5;

		int maxProfit = s.recursiveApproch(weights,profits,capacity,currentIndex);

		System.out.println(" MaxProfit => "+maxProfit);
	}
}








