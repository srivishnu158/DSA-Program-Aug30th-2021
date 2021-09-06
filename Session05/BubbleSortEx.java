class Sample
{
	/*
		Time Complexity O(n^2)
		Space Complexity O(1)
		Swap n^2
	*/
	public void sortBubble(int[] arr)
	{
		for(int i = 0 ; i < arr.length - 1 ; i++)
		{
			for(int j = 0; j <arr.length - 1 - i ; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

	}
}

public class BubbleSortEx
{
	public static void main(String[] args)
	{
		int[] arr = {7,4,5,2};
		Sample s = new Sample();
		s.sortBubble(arr);

		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}

	}
}









