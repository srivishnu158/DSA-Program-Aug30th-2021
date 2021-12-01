import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

class Sample
{

	/*
			Time Complexity : O(n) 
			Space Complexity : O(n)
			Without considering output Array then Space Complexity : O(k)
	*/

	public int[] getMaxWindowElements(int[] nums , int k)
	{
		int n = nums.length;
		Deque<Integer> deque = new LinkedList<>();
		int[] output = new int[n-k+1];

		int max = 0;
		for(int i = 0 ; i < k ; i++)
		{
			clearDeque(i,k,deque, nums);
			deque.addLast(i);
			if(nums[i] > nums[max])
			{
				max = i;
			}
		}

		output[0] = nums[max];
		// output size  : n-k+1
		for(int left = k ; left < n; left++)
		{
			clearDeque(left,k,deque,nums);
			deque.addLast(left);

			output[left-k+1] = nums[deque.getFirst()];
		}

		return output;
	}


	public void clearDeque(int right , int k ,
							 Deque<Integer> deque, int[] nums )
	{

		// Remove the Front if the window is reaching out of capacity

		if(!deque.isEmpty() && deque.getFirst() == right-k)
		{
			deque.removeFirst();
		}

		
		// Remove rear elements if the current right is greater 
		while(!deque.isEmpty() && nums[right] >= nums[deque.getLast()] )
		{
			deque.removeLast();
		}


	}
}	


public class MaxOfSlidingWindowExWithDeque

{
	public static void main(String[] args) {
		Sample s = new Sample();

		int[] output1 = s.getMaxWindowElements(new int[]{1,3,-1,-3,5,3,6,7}, 3); // 3,3,5,5,6,7
		int[] output2 = s.getMaxWindowElements(new int[]{1,0,-1,-3,-5}, 3);//1,0,-1 

		System.out.println(" output1 :: "+Arrays.toString(output1));
		System.out.println(" output2 :: "+Arrays.toString(output2));


		int[] output3 = s.getMaxWindowElements(new int[]{1,3,-1,-3,5,3,6,7}, 2); 
									// 3,3,-1,5,5,6,7
		int[] output4 = s.getMaxWindowElements(new int[]{1,0,-1,-3,-5}, 2);
									//1,0,-1,-3 

		System.out.println(" output3 :: "+Arrays.toString(output3));
		System.out.println(" output4 :: "+Arrays.toString(output4));


	}
}

