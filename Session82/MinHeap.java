class Sample
{
	int[] minHeap;
	int actualSize ;
	int realSize = 0;

	public Sample(int size)
	{
		this.actualSize = size;
		minHeap = new int[size+1];
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

		minHeap[realSize] = element;
		int currentIndex = realSize;
		int parent = currentIndex/2;
		while(currentIndex > 1 && minHeap[currentIndex] < minHeap[parent] )
		{
			int temp = minHeap[parent];
			minHeap[parent]= minHeap[currentIndex];
			minHeap[currentIndex] = temp;
			currentIndex = parent;
			parent = currentIndex/2;
		}
			return true;
	}

		/*
			Time Complexity : O(n)
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
			if(element == minHeap[i])
			{
				elementIndex = i;
				break;
			}
		}

		if(elementIndex == -1)
		{
			return false;
		}

		minHeap[elementIndex] = minHeap[realSize]; // Replace with Right Most Element
		realSize--; // Eleminating the Right Most Element

		//When the elementIndex is not a leaf node 
		while(elementIndex <= realSize/2)
		{
				int leftIndex  = 2*elementIndex;
				int rightIndex  = 2 * elementIndex + 1;

				if(
					minHeap[elementIndex] > minHeap[leftIndex]
						||
					minHeap[elementIndex] > minHeap[rightIndex]
					)
				{
					if(minHeap[elementIndex] > minHeap[leftIndex])
					{
							int temp = minHeap[leftIndex];
							minHeap[leftIndex]= minHeap[elementIndex];
							minHeap[elementIndex] = temp;
							elementIndex = leftIndex;
					}else if(minHeap[elementIndex] > minHeap[rightIndex])
					{
							int temp = minHeap[rightIndex];
							minHeap[rightIndex]= minHeap[elementIndex];
							minHeap[elementIndex] = temp;
							elementIndex = rightIndex;
					}
				}else
				{
					break;
				}

		}
		return true;
	}

	public int peek()
	{
		return realSize == 0 ? -1 : minHeap[1];
	}

	public void print()
	{
		StringBuilder sb = new StringBuilder("[ ");
		for(int i = 1 ; i <= realSize ; i++)
		{
			sb.append(minHeap[i]+" , ");
		}
		int lastIndex = sb.lastIndexOf(",");
		sb.insert(lastIndex," ] ");
		System.out.println(sb.toString());

	}

}

public class MinHeap
{
	public static void main(String[] args) {
		
		int[] input = {4,5,3,1,2};
		Sample s = new Sample(5);

		for(int i = 0 ; i < input.length ; i++)
		{
			s.add(input[i]);
		System.out.println(" \nAfter add("+input[i]+")");
			s.print();
		}

		s.delete(1);
		System.out.println("\n After delete(1)");
		s.print();

		s.delete(4);
		System.out.println(" \nAfter delete(4)");
		s.print();

		System.out.println(" peek() "+s.peek());

	}
}

/*
		[4]
		[4,5]
		[3,5,4]
		[1,3,4,5]
		[1,2,4,5,3]

	After delete(1)
			[2,3,4,5]

	After delete(2)
			[2,3,5]
*/







