import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

class Sample
{
	Map<Integer,Integer> lookUpMap = null;
	Map<Integer,Set<Integer>> minHeap = null;
	int elementSize = 0;

	public Sample()
	{
		lookUpMap = new TreeMap<>();
		minHeap = new LinkedHashMap<>();
	}

		/*
			Time Complexity : O(logn)
			Space Complexity : O(1)
		*/
	public boolean add(int element)
	{
		
			minHeap.putIfAbsent(element, new TreeSet<>());
			elementSize++;

			minHeap.get(element).add(elementSize);
			lookUpMap.put(elementSize , element);

			int currentIndex = elementSize;
			int parentIndex = currentIndex/2;

			while(currentIndex > 1 && lookUpMap.get(currentIndex)
					< lookUpMap.get(parentIndex))
			{
				int parentValue = lookUpMap.get(parentIndex);
				int currentValue = lookUpMap.get(currentIndex);

				lookUpMap.put(parentIndex,currentValue);
				lookUpMap.put(currentIndex, parentValue);

				minHeap.get(parentValue).remove(parentIndex);
				minHeap.get(currentValue).remove(currentIndex);

				minHeap.get(parentValue).add(currentIndex);
				minHeap.get(currentValue).add(parentIndex);

				currentIndex = parentIndex;
				parentIndex = currentIndex/2;

			}


			return true;
	}

		/*
			Time Complexity : O(logn)
			Space Complexity : O(1)
		*/
	public boolean delete(int element)
	{


		if(minHeap.get(element) == null 
			|| minHeap.get(element).size() == 0)
		{
			System.out.println(" Heap is Empty !!!");
			return false;
		}

		int rightMostIndex = elementSize;
		elementSize--;
		int rightMostElement = lookUpMap.get(rightMostIndex);

	    int currentIndex = minHeap.get(element).iterator().next();
		minHeap.get(element).remove(currentIndex);

		minHeap.get(rightMostElement).add(currentIndex);
		minHeap.get(rightMostElement).remove(rightMostIndex);

		lookUpMap.remove(rightMostIndex);
		lookUpMap.put(currentIndex,rightMostElement);


		while(currentIndex <= elementSize/2)
		{
			int leftIndex = 2 * currentIndex;
			int rightIndex = 2 * currentIndex + 1;

			int minValueIndex = currentIndex;

				if(lookUpMap.get(leftIndex) !=  null && 
					lookUpMap.get(minValueIndex) > lookUpMap.get(leftIndex))
				{
					minValueIndex = leftIndex;
				}

				if(lookUpMap.get(rightIndex) != null &&
					lookUpMap.get(minValueIndex) > lookUpMap.get(rightIndex))
				{
					minValueIndex = rightIndex;
				}

				if(minValueIndex == currentIndex)
				{
					break;
				}

				Integer minChildValue = lookUpMap.get(minValueIndex);
				Integer parentValue = lookUpMap.get(currentIndex);


				lookUpMap.put(currentIndex,minChildValue);
				lookUpMap.put(minValueIndex, parentValue);

				
				minHeap.get(minChildValue).remove(minValueIndex);
				minHeap.get(parentValue).remove(currentIndex);


				minHeap.get(minChildValue).add(currentIndex);
				minHeap.get(parentValue).add(minValueIndex);

				currentIndex = minValueIndex;
		}



		return true;
	}

	public int peek()
	{
		return elementSize == 0 ? -1 : lookUpMap.get(1);
	}

	public void print()
	{
		//lookUpMap.keySet().stream().forEach(key -> System.out.print(key+"->" +lookUpMap.get(key)+"\n"));		
		
		System.out.println(lookUpMap.values());
	}

}

public class MinHeapLognDeletion
{
	public static void main(String[] args) {
		
		int[] input = {4,5,3,1,2};
		Sample s = new Sample();

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

	After delete(4)
			[2,3,5]

*/







