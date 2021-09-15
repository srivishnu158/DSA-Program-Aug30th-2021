class Sample
{
	
	/*
		Time Complexity =>  O(logn) 
		Space Complexity => O(1)
	*/

	public int findCountOfElement(int[] arr, int element)
	{
		int leftIndex = leftOccurrence(arr,element);
		int rightIndex = rightOccurrence(arr, element);

		if(leftIndex == -1 & rightIndex == -1)
		{
			return -1;
		}

		return rightIndex - leftIndex + 1;
	}


	private int rightOccurrence(int[] arr, int element)
	{
		int start  = 0;
		int end = arr.length-1; 
		int result = -1;
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			if( arr[mid] == element)
			{
					result = mid;
					start = mid+1;
			}else if(arr[mid] < element)
			{
				start = mid+1;
			}
			else // It means arr[mid] > element
			{
				end = mid-1;
			}
		}

		return result;
	}


	private int leftOccurrence(int[] arr, int element)
	{
		int start  = 0;
		int end = arr.length-1; 
		int result = -1;
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			if( arr[mid] == element)
			{
					result = mid;
					end = mid-1;
			}else if(arr[mid] < element)
			{
				start = mid+1;
			}
			else // It means arr[mid] > element
			{
				end = mid-1;
			}
		}

		return result;
	}

}


public class CountOfElementApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {3,5,7,8,8,8,9,10,11,12};
		int count = s.findCountOfElement(arr, 8);

		System.out.println(" [count] Element 8 => "+count);
	}
}








