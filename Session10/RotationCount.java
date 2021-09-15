class Sample
{
	
	/*
		Time Complexity =>  O(n)
		Space Complexity => O(1)
	*/

	public int linearApproach(int[] arr)
	{

// If the first lement less than last element means there is no rotation.
		if(arr[0] < arr[arr.length-1])
		{
			return 0;
		} 
		int minValueIndex = 0; 
		int minValue = arr[0]; 

		int i = 1;

		while( i < arr.length)  
		{
			if(minValue > arr[i])
			{
				minValueIndex = i; 
				minValue = arr[i]; 
				break;
			}
			i++;
		}

		return minValueIndex;
	}

}


public class RotationCount
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {8,9,10,2,5,7};
		int linearApproach = s.linearApproach(arr);

		System.out.println(" [linearApproach] RotationCount => "+linearApproach);
	}
}








