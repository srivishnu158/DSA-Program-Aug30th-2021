class Sample
{

	/*
			Binary Search With Recursion 
			TimeComplexity : O(logn)
			SpaceComplexity : O(logn)

		{2,1} start = 0 end = 1 mid = 0
	*/
	public int recursionApproch(int[] arr,int start , int end)
	{
			// the below two ifs are checking base use cases.
			if(arr.length == 1)
			{
				return 0;
			}

			if(arr[start] < arr[end])
			{
				return start;
			}

				// Algorithm start from here.
			if(start > end)
			{
				return 0;
			}// The smallest possible valid value of start is , < end

			int mid = start + (end-start)/2;

			if(arr[mid] > arr[mid+1])
			{
					return mid+1;
			}

			if(arr[mid-1] > arr[mid])
			{
				return mid;
			}

			if(arr[mid] > arr[0])
			{
				start = mid+1;
				return recursionApproch(arr, start, end);

			}else // it means arr[mid] < arr[end]
			{
				end = mid-1;
				return recursionApproch(arr, start, end);

			}

	}


	/*
			Binary Search With Iteration 
			TimeComplexity : O(logn)
			SpaceComplexity : O(1)
	*/
	public int iterationApproch(int[] arr)
	{
			int start = 0;
			int end = arr.length - 1;

		// the below two ifs are checking base use cases.
			if(arr.length == 1)
			{
				return 0;
			}

			if(arr[start] < arr[end])
			{
				return start;
			}

			// Aglorithm starts here 
			 while(start <= end)
			 {
			 	int mid = start + (end-start)/2;

			 	if(arr[mid] > arr[mid+1])
			 	{
			 		return mid+1;
			 	}

			 	if(arr[mid-1] > arr[mid])
			 	{
			 		return mid;
			 	}

			 	if(arr[mid] > arr[0]) // Left part is sorted move to right
			 	{
			 			start = mid+1;
			 	}else // arr[mid] < arr[end] Right part is sorted move to left
			 	{
			 			end = mid-1;
			 	}

			 }

			 return 0;

	}
}

public class RotationCountApp
{
	public static void main(String args[])
	{

		Sample s = new Sample();
		int[] arr = {3,4,5,1,2};

		int start = 0;
		int end = arr.length-1;

		int recursionApproch = s.recursionApproch(arr,start,end);
		System.out.println("[recursionApproch] "+recursionApproch);

		int iterationApproch = s.iterationApproch(arr);
		System.out.println("[iterationApproch] "+iterationApproch);
	}
}









