class Sample
{
	int[] maxHeap;
	int actualSize ;
	int realSize = 0;

	public Sample(int size)
	{
		this.actualSize = size;
		maxHeap = new int[size+1];
	}

		/*
			Time Complexity : O(logn)
			Space Complexity : O(1)
		*/
	public boolean add(int element)
	{
		realSize++; 
		if(realSize > actualSize)
		{
		System.out.println(" Heap is filled !!!!");
		realSize--;
		return false;
		}

		maxHeap[realSize] = element;
		int currentIndex = realSize;
		int parent = currentIndex/2;
		while(currentIndex > 1 && maxHeap[currentIndex] > maxHeap[parent] )
		{
			int temp = maxHeap[parent];
			maxHeap[parent]= maxHeap[currentIndex];
			maxHeap[currentIndex] = temp;
			currentIndex = parent;
			parent = currentIndex/2;
		}
			return true;
	}

		/*
			Time Complexity : O(n)(Identify element index) + Olog(n)(buildHeap) = O(n)
			Space Complexity : O(1)
		*/
	public boolean delete(int element)
	{
		if(realSize == 0)
		{
			System.out.println(" Heap is Empty !!!");
			return false;
		}

		int elementIndex  = -1;
		for(int i = 1 ; i <= realSize; i++ )
		{
			if(element == maxHeap[i])
			{
				elementIndex = i;
				break;
			}
		}

		if(elementIndex == -1)
		{
			return false;
		}

		maxHeap[elementIndex] = maxHeap[realSize]; // Replace with Right Most Element
		realSize--; // Eleminating the Right Most Element

		//When the elementIndex is not a leaf node 
		while(elementIndex <= realSize/2)
		{
				int leftIndex  = 2*elementIndex;
				int rightIndex  = 2 * elementIndex + 1;

				int maxIndex = elementIndex;

				if(arr[maxIndex] < arr[leftIndex])
				{
					maxIndex = leftIndex;
				}

				if(arr[maxIndex] < arr[rightIndex])
				{
					maxIndex = rightIndex;
				}

				if(maxIndex == elementIndex)
				{
					break;
				}

				
					int maxValue = minHeap[maxIndex];
					minHeap[maxIndex]= minHeap[elementIndex];
					minHeap[elementIndex] = maxValue;
					elementIndex = maxIndex;
		}

		
		return true;
	}

	public int peek()
	{
		return realSize == 0 ? -1 : maxHeap[1];
	}

	public void print()
	{
		StringBuilder sb = new StringBuilder("[ ");
		for(int i = 1 ; i <= realSize ; i++)
		{
			sb.append(maxHeap[i]+" , ");
		}
		int lastIndex = sb.lastIndexOf(",");
		sb.insert(lastIndex," ] ");
		System.out.println(sb.toString());

	}

}

public class MaxHeap
{
	public static void main(String[] args) {
		
		int[] input = {4,5,3,11,7};
		Sample s = new Sample(5);

		for(int i = 0 ; i < input.length ; i++)
		{
			s.add(input[i]);
		System.out.println(" \nAfter add("+input[i]+")");
			s.print();
		}

		s.delete(7);
		System.out.println("\n After delete(7)");
		s.print();

		s.delete(11);
		System.out.println(" \nAfter delete(11)");
		s.print();

		System.out.println(" peek() "+s.peek());

	}
}

/*
	Expected Ouput : 
		[4] -> add(4)
		[5,4] -> add(5)
		[5,4,3] -> add(3)
		[11,5,3,4] -> add(11)
		[11,7,3,4,5] -> add(7)

	After delete(7)
			[11,5,3,4]

	After delete(11)
			[5,4,3]
*/







