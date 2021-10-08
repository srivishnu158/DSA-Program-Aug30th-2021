class Sample
{
	public int maxProfit(int[] profits, int currentIndex)
	{

		if(currentIndex >= profits.length)
		{
			return 0;
		}

		//include Profit

		int includeProfit = profits[currentIndex] + maxProfit(profits,currentIndex+2);
		int exludeProfit = maxProfit(profits,currentIndex+1);

		return Math.max(includeProfit,exludeProfit);


	}
}

public class HouseThief
{
	public static void main(String args[])
	{
			Sample s = new Sample();
			int[] profits = {1, 10, 3, 8,12};
			int maxProfit = s.maxProfit(profits,0);
			System.out.println(" Max Profit is "+maxProfit);
	}
}








