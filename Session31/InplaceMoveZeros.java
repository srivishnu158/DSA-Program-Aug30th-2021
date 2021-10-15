class Sample
{
		/*
			Time Complexity :  O(n)
			Space Complexity : O(1)
		*/

	public void moveZeros(int[] arr)
	{
		int i = 0;
		int j = 0;
			
			while( j < arr.length)
			{
				if(arr[j] != 0)
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					i++;
				}

				j++;
			}

	}
}

public class InplaceMoveZeros
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {0,1,0,3,12};
		s.moveZeros(nums);

		for(int i = 0 ; i < nums.length ; i++)
		{
			System.out.print(nums[i]+" ~ ");
		}
	}
}








