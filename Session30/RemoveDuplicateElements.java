class Sample
{
		/*
			Time Complexity :  O(n) 
			Space Complexity: O(1)

			{1,2,3,3,3,4,4}

			
		*/
	public int inPlaceAlgorithm(int[] nums )
	{
		if(nums.length == 0)
		{
			return 0;
		}

		int start = 0;
		int end = start+1;

		while(end < nums.length)
		{
			if(nums[start] != nums[end])
			{
				nums[start+1] = nums[end];
				start++;
 			}

 			end++;
		}

		return start+1;
	}

}


public class RemoveDuplicateElements
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {1,2,3,3,3,4,4};

		int k = s.inPlaceAlgorithm(nums);
		for(int i = 0 ; i < k ; i++)
		{
			System.out.println(nums[i]);
		}
	}


}





