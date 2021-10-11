class Sample
{

    /*
        TimeComplexity : O(n)
        SpaceComplexity: O(n)
        int[] profits = {1,3,5} => 0,1,2
        int[] dp = new int[4];
    */
    public int tabulation(int[] profits)
    {

        int[] dp = new int[profits.length+1];
        dp[0] = 0;
        dp[1] = profits[0];// When there is single House , we just take profit[0].

        // Current 'i' element profit would be stored in dp[i+1]
        for(int i = 1 ; i < profits.length;i++)
        {
            dp[i+1] = Math.max(profits[i]+dp[i-1],dp[i]);
        }
	
	    printSelectedItems(dp,profits);
        return	dp[profits.length];
    }

    public void printSelectedItems(int[] dp,int[] profits)
    {
        int n = profits.length;
        int i = n;
        int totalProfit = dp[n];

         System.out.println("  Current Element & its DP Profit");
        for(int k = 1 ; k <= n ; k++)
        {

            System.out.println(profits[k-1]+" = "+"dp["+ k +"]="+dp[k] );
        }

		System.out.println(" \nBack Tracking, Selected profits....");
        while( i > 1  && totalProfit > 0)
        {
            if(dp[i] != dp[i-1])
            {
                System.out.print(profits[i-1] + " :: ");
                totalProfit = dp[i-2]; 
                // As you included current element move on to Left Profit 
                // i.e dp[i-2] (or) totalProfit-profits[i-1]
                i = i-2;
            }else
            {
                i--;
            }

        }

        if(totalProfit != 0) //It means included first element
        {
            System.out.print(profits[0]);
        }

    }

}

public class HouseThiefTabulation
{
    public static void main(String args[])
    {
        Sample s = new Sample();
        int[] profits = {1,5,7,8,11,10,3,22};
        int maxProfit = s.tabulation(profits);
        System.out.println(" \n\n Max Profit is = "+maxProfit);
    }
}