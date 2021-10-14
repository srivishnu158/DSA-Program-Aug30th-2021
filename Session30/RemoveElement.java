class Sample
{
		/*
			Time Complexity :  O(n) 
			Space Complexity: O(1)
			[3,3,2,2]  val : 3   return 2
		*/
	public int inPlaceAlgorithm(int[] nums , int val)
	{
		if(nums.length == 0)
		{
			return 0;
		}

		int count = 0;
		int start = 0;
		
		for(int end = 0 ; end < nums.length ; end++)
		{
			if(nums[end] != val)
			{
				nums[start] = nums[end];
				start++;
				count++;
			}
		}

		return count;
	}

}


public class RemoveElement
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {1,3,2,2,3,5,6,7,3,1};

		int k = s.inPlaceAlgorithm(nums,3);
		for(int i = 0 ; i < k ; i++)
		{
			System.out.println(nums[i]);
		}
	}


}





