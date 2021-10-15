class Sample
{
		/*
			Time Complexity :  O(n)
			Space Complexity : O(1)
		*/

	public void missingElements(int[] arr)
	{
		
			for(int i = 0 ; i < arr.length ; i++)
			{
				int value = Math.abs(arr[i]);

				if(arr[value-1] > 0)
				{
					arr[value-1] = - arr[value-1];
				}
			}


			for(int i = 0 ; i < arr.length ; i++)
			{
				
					if(arr[i] >= 0)
					{
						System.out.println(i+1);
					}
			}

	}
}

public class InplaceMissingElements
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {2,1,1,2,3};
		s.missingElements(nums);

	}
}








