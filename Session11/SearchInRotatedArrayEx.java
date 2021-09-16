class Sample
{

	
	public int findRotationIndex(int[] arr)
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


	public int search(int[] arr, int start , int end , int target)
	{
		 while(start <= end)
		 {
		 	int mid = start + (end-start)/2;

		 	if( arr[mid] == target){

		 		return mid;
		 	}
		 	else if(arr[mid] < target)
		 	{
		 		start  = mid + 1;
		 	}else
		 	{
		 		end = mid - 1;
		 	}
		 }
		 return -1;
	}


	/*
			Binary Search With Iteration 
			TimeComplexity : O(logn)
			SpaceComplexity : O(1)
	*/

	public int iterationApproch(int[] arr, int target)
	{
		//Covering base case
		if(arr.length == 1)
		{
			return arr[0] == target ? 0 : -1;
		}

		int start = 0;
		int end = arr.length-1;
		int rotationIndex = findRotationIndex(arr);

		// If the search is minimum element base case
			if(arr[rotationIndex] == target)
			{
				return rotationIndex;
			}

		if(rotationIndex == 0)
		{
				return search(arr, start, end, target);
		}else if(target >= arr[0])
		{
				return search(arr, start, rotationIndex, target);
		}else //  it means taret < arr[0]
		{
				return search(arr, rotationIndex, end, target);
		}

	}
}

public class SearchInRotatedArrayEx
{
	public static void main(String args[])
	{

		Sample s = new Sample();
		int[] arr = {2,1};

		int iterationApproch = s.iterationApproch(arr,2);
		System.out.println("[iterationApproch] Index of 2 => "+iterationApproch);
	}
}









