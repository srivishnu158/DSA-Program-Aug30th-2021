class Sample
{
	public void selectionSort(int[] arr)
	{

		for(int i = 0 ; i < arr.length ; i++)
		{

			int minIndex = i;

				// The inner loop finds the minIndex for a currentElement
			 for(int  j = i + 1; j < arr.length ; j++)
			 {
			 	if(arr[j] < arr[minIndex])
			 	{
			 		minIndex = j;
			 	}
			 }

			 //Swapping
			 if(minIndex != i)
			 {
			 	int temp = arr[i];
			 	arr[i] = arr[minIndex];
			 	arr[minIndex] = temp;
			 }
		}
	}
}

public class SelectionSortEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr= {5, 11, 3, 2, 10, 1};
		s.selectionSort(arr);

		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}










