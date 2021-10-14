class Sample
{

	public boolean mountainArray(int[] nums)
	{
		int n = nums.length;

		if( n < 3)
				return false;

			int i = 0;
			//walk up
			while( i+1 < n && nums[i] < nums[i+1])
			{
				i++;
			}

			if( i == 0 || i == n-1)
			{
				return false;
			}

			//walk down
			while( i+1 < n && nums[i] > nums[i+1])
			{
				i++;
			}


			return i == n-1;

	}
}



public class MountainArrayEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] nums = {1,3,5,6,7,8,2};
		System.out.println(" Is MountainArray ~ ? = "+s.mountainArray(nums));
	}
}










