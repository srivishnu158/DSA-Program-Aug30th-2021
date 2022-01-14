class Sample
{
	
	/*
		Time Complexity : O(n)
		Space Complexity : O(1)
	*/
	public void heapify(int[] elements)
	{
		int size = elements.length;
		int currentIndex = (size/2)-1;

		while(currentIndex >= 0) // Repeats till => n - leafNodes
		{

			int leftIndex = 2 * currentIndex + 1;
			int rightIndex = 2 * currentIndex + 2;
			int minIndex = currentIndex;

			if(elements[leftIndex] < elements[minIndex])
			{
				minIndex = leftIndex;
			}

			if(elements[rightIndex] < elements[minIndex])
			{
				minIndex = rightIndex;
			}

			if(minIndex == currentIndex)
			{
				currentIndex--;
				continue;
			}

			int temp = elements[currentIndex];
			elements[currentIndex] = elements[minIndex];
			elements[minIndex] = temp;

			currentIndex--;
		}
	}
}

public class HeapifyEx
{

	public static void main(String[] args) {
		int[] elements = {10,15,5,11,1,5,2};

		Sample s = new Sample();
		s.heapify(elements);
		System.out.println();
		for(int i = 0 ; i < elements.length ; i++)
		{
			System.out.print(elements[i]+" -> ");
		}

	}
}

/*
	1, 10, 2 , 11, 15, 5 , 5
	1 -> 10 -> 2 -> 11 -> 15 -> 5 -> 5 ->

*/






