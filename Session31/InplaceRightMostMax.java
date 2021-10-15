class Sample
{
		/*
			Time Complexity :  O(n)
			Space Complexity : O(1)
		*/

	public void rightMostMax(int[] arr)
	{
		int rightMax = arr[arr.length-1];
		int prevIndex = arr.length-2;
			
			while( prevIndex >= 0)
			{
				int currentElement = arr[prevIndex];
				arr[prevIndex] = rightMax;

				if(currentElement > rightMax)
				{
					rightMax = currentElement;
				}

				prevIndex--;
			}

			arr[arr.length-1] = -1;
	}
}

public class InplaceRightMostMax
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {17,18,5,4,6,1};
		s.rightMostMax(nums);

		for(int i = 0 ; i < nums.length ; i++)
		{
			System.out.print(nums[i]+" ~ ");
		}
	}
}








