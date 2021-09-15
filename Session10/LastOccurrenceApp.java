class Sample
{
	/*
	BruteForce Aproch
	Time Complexity O(n)
	Space Complexity O(1)
	*/
	public int linearApproach(int[] arr, int element)
	{
		int i = arr.length - 1;

		while( i >= 0)
		{
			if(arr[i] == element)
			{
				return i;
			}
			i--;
		}

		return -1;
	}


		/*
			BinarySearch With Recursion

			Time Complexity O(logn)
			Space Complexity O(logn)
					
		*/

	public int recursiveApproach(int[] arr, int element , int start ,
	 int end,int result)
	{
		if(start > end)
		{
			return result;
		}

		int mid = start + (end-start)/2;

		if(arr[mid] == element)
		{
			result = mid;
			start = mid+1;
			return recursiveApproach(arr,element,start,end,result);
		}else if(arr[mid] < element)
		{
			start = mid+1;
			return recursiveApproach(arr,element,start,end,result);
		}else // It means arr[mid] > element
		{
				end = mid-1;
			return recursiveApproach(arr,element,start,end,result);	
		}


	}

/*
			BinarySearch With Iteration

			Time Complexity O(logn)
			Space Complexity O(1)
					
	*/

	public int iterativeApproach(int[] arr, int element)
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



}


public class LastOccurrenceApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {3,5,7,8,8,8,9,10,11,12};


		int linearApproach = s.linearApproach(arr,8);
				

		int start = 0;
		int end = arr.length-1;
		int result = -1;
		int recursiveApproach = s.recursiveApproach(arr,8,start,end,result);

		int iterativeApproach = s.iterativeApproach(arr,8);

		System.out.println(" [LinearApproch] Element 8 => "+linearApproach);
		
		System.out.println(" [recursiveApproch] Element 8 => "+recursiveApproach);

		System.out.println(" [iterativeApproch] Element 8 => "+iterativeApproach);



	}
}








