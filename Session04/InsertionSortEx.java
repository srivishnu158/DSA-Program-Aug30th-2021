class Sample
{
	public void insertionSort(int[] arr)
	{
		for(int i =1 ; i < arr.length ; i++)
		{
			int currentElement = arr[i]; 
			int j = i-1;

			while( j >= 0 && arr[j] > currentElement)
			{
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = currentElement;
		}
	}
}

public class InsertionSortEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = { 4,5,7,2};
		s.insertionSort(arr);

		for(int  i = 0 ; i < arr.length ; i++)
		{
			System.out.print(arr[i]+ "  ");
		}
		System.out.println();



	}
}

/*
i= 3 ;{ 4,5,7,2}

inner loop :: currentElement = 2, j = 2

			while(2 >= 0 && arr[2] > 2 )
					{
						arr[j+1] = arr[j];
						arr[3] = 7;  {4,5,7,7}
						j--;
					}
				........

				currentElement = 2, j = 1

			while(1 >= 0 && arr[1] > 2 )
					{
						arr[j+1] = arr[j];
						arr[2] = 5;  {4,5,5,7}
						j--;
					}
				........

					currentElement = 2, j = 0

			while(0 >= 0 && arr[0] > 2 )
					{
						arr[j+1] = arr[j];
						arr[1] = 4;  {4,4,5,7}
						j--;
					}

					currentElement = 2, j = -1
		

			while(-1 >= 0 && arr[0] > 2 ) innner loop terminates
			...........

			j = -1;
			{4,4,5,7}

			arr[j+1] = currentElement;
			arr[0] = 2; => {2,4,5,7}

*/







