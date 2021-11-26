class JumpGame
{

	/*
		This will not work for all  possibilities. 
		Let me know if you could find best logic. 
		Failed TestCases :
			
			int[] arr1 = {0,-1,-2,-3,1};  // Expected Output 0-2+1 = -1
			int k1 = 2;

			int[] arr2 = {100,-1,-100,-1,100}; // Expected Output 100-1-1+100 = 198
			int k2 = 2;

			
			int[] arr3 = {5,7,-3,-9,-2,7,8,-1}; 
			// Expected Output 5+7+-2+7+8-1= 24
			int k3 = 3;


	   Can be by taking help of Other Data Structures. (Queue)

	*/
	public int maxScore(int[] nums, int k)
	{
		 int n = nums.length;
        int max = nums[0];
        for(int i = 0 ; i < n ; )
        {
            int windowMax = Integer.MIN_VALUE;
            for(int j = i+1 ; j <= Math.min(i+k,n-1) ; j++)
            {
                windowMax = Math.max(windowMax, max+nums[j]);
            }
           if(windowMax != Integer.MIN_VALUE)
            max = windowMax;
            i= i+k;
        }
        
        
        return max;
	}


	
}


public class JumpGameBruteForce
{
	public static void main(String args[])
	{
			JumpGame game = new JumpGame();
			int[] arr = {10,-5,-2,4,0,3}; // 10-2+4+3 = 15
			int k = 2;

			System.out.println(" Max Score ~~ :: "+game.maxScore(arr,k));


	}
}








