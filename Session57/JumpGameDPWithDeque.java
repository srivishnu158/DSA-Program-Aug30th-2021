import java.util.Deque;
import java.util.LinkedList;
/*
	Algorithm :

=> Always add new elements at the rear.

=> When the current element score is greater than rear, remove the rear.
   Such that we can always make sure that firstElement of deque 
   represents maxScore of currentWindow. 

=> When the firstElement of the Deque is out the window then 
   remove it from the DeQue.

*/

class JumpGame
{
		/*
			Time Complexity : 
						Traversing from 0 ...n + n  = 2n = O(n)
			Space Complexity : O(n)
		*/
	public int maxScore(int[] nums, int k)
	{
		int n = nums.length;
		int[] output = new int[n];
		Deque<Integer> deque = new LinkedList<>();

		output[0] = nums[0];
		deque.addLast(0);

		for(int i = 1 ; i<n ; i++) // k = 2
			{
				// Check does the Deque First Element is out of the window If so remove it
				if(!deque.isEmpty() && deque.getFirst() < i-k)
				{
						deque.removeFirst();
				}

				int score  = output[deque.getFirst()] + nums[i];

				// When the currentScore is greater than the previous Score
				// remove the  from DeQue.
				while(!deque.isEmpty() &&  score >= output[deque.getLast()] )
				{
					deque.removeLast();
				}

					deque.addLast(i);
					output[i] = score;
			}

			return output[n-1];
	}
}



public class JumpGameDPWithDeque
{
	public static void main(String args[])
	{
			JumpGame game = new JumpGame();
			
			int[] arr1 = {0,-1,-2,-3,1};  // Expected Output 0-2+1 = -1
			int k1 = 2;

			System.out.println(" \n{0,-1,-2,-3,1} K= 2 \n MaxScore = "+game.maxScore(arr1,k1));


			int[] arr2 = {100,-1,-100,-1,100}; // Expected Output 100-1-1+100 = 198
			int k2 = 2;

			System.out.println(" \n{100,-1,-100,-1,100} K= 2 \n MaxScore = "+game.maxScore(arr2,k2));


			int[] arr3 = {5,7,-3,-9,-2,7,8,-1}; // Expected Output 5+7+-2+7+8-1= 24
			int k3 = 3;

			System.out.println(" \n{5,7,-3,-2,-9,7,8,-1} K= 3 \n MaxScore = "+game.maxScore(arr3,k3));


	}
}











