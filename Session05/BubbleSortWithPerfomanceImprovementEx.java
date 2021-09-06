class Sample
{
	/*
		If we don't make any swap, which means the array is already sorted.	
	
	If array Unsorted 
		Time Complexity O(n^2)
		Space Complexity O(1)
		Swap n^2

	If array sorted 
		Time Complexity O(n)
		Space Complexity O(1)
		Swap n
	
	*/
	public void sortBubble(int[] arr)
	{
		boolean isSorted = false;

		while(!isSorted)
		{
			isSorted = true;
			for(int j = 0 ; j < arr.length-1 ; j++)
			{
				if(arr[j] > arr[j+1])
				{
					isSorted = false;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

	}
}

public class BubbleSortWithPerfomanceImprovementEx
{
	public static void main(String[] args)
	{
		int[] arr = {2 ,3, 1, 4, 5, 6};
		Sample s = new Sample();
		s.sortBubble(arr);

		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}

	}
}


