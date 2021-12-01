import java.util.Arrays;

class Sample
{
		// [1,3,-1,-3,5,3,6,7] k = 3
		/*
			Time Complexity 	: O(nk)
			Space Complexity 	: O(n-k+1) ~ O(n)

		*/
	public int[] maxOfSlidingWindow(int[] nums, int k)
	{
		if( k == 1)
		{
			return nums;
		}

		int n = nums.length;
		int[] output = new int[n-k+1];
		int max = Integer.MIN_VALUE;
		for(int left = 0 ; left < n-k+1 ; left++)
		{
			 max = Integer.MIN_VALUE;

			for(int right = left ; right < left+k ; right++)
			{
				max = Math.max(max,nums[right]);
			}

			output[left] = max;

		}
		return output;
	}
}


public class MaxOfSlidingWindowEx

{
	public static void main(String[] args) {
		Sample s = new Sample();

		int[] output1 = s.maxOfSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		int[] output2 = s.maxOfSlidingWindow(new int[]{1,0,-1,-3,-5}, 3);//1,0,-1

		System.out.println(" output1 :: "+Arrays.toString(output1));
		System.out.println(" output2 :: "+Arrays.toString(output2));


	}
}













