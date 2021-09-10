

class Sample
{
	public void sort(int[] arr)
	{
		if(arr.length <= 1)
				return;

		quickSort(arr, 0, arr.length-1);	
	}

		/*
		Time Complexity O(nlogn)
		Space Complexity O(1).
	    If you Consider stack frame count then Space Compexity O(logn)
		*/

	private void quickSort(int[] arr, int leftIndex, int rightIndex)
	{
			if(leftIndex <= rightIndex)
			{
				int pivotIndex = partition(arr,leftIndex,rightIndex);

				if(leftIndex < pivotIndex-1)
				{
					quickSort(arr,leftIndex,pivotIndex-1);
				}

				if(pivotIndex < rightIndex)
				{
					quickSort(arr,pivotIndex,rightIndex);
				}
			}
	}


	private int partition(int[] arr , int leftIndex , int rightIndex)
	{
		int pivotValue = arr[(leftIndex+rightIndex)/2];

		while(leftIndex <= rightIndex)
		{

				while(arr[leftIndex] < pivotValue)
				{
					leftIndex++;
				}

				while(arr[rightIndex] > pivotValue)
				{
					rightIndex--;
				}

				if(leftIndex <= rightIndex)
				{
					int temp = arr[leftIndex];
					arr[leftIndex] = arr[rightIndex];
					arr[rightIndex] = temp;
					leftIndex++;
					rightIndex--;
				}
		}



		return leftIndex;
		// This way we could make pivot as Random.
		// It achieves nlogn time complexity.
	}
}


public class QuickSortApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {11,1,9,4,2,9,5};

		s.sort(arr);

		for(int i = 0 ; i< arr.length ; i++)
		{
			System.out.print( arr[i] + " ");
		}
	}
}












