import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

class Sample
{
	Map<Integer,Integer> minHeap = null;
	Map<Integer,Set<Integer>> elementsLookUpMap = null;
	int elementSize = 0;

	public Sample()
	{
		minHeap = new TreeMap<>();
		elementsLookUpMap = new LinkedHashMap<>();
	}

		/*
			Time Complexity : O(logn)
			Space Complexity : O(1)
		*/
	public boolean add(int element)
	{
		
			elementsLookUpMap.putIfAbsent(element, new TreeSet<>());
			elementSize++;

			elementsLookUpMap.get(element).add(elementSize);
			minHeap.put(elementSize , element);

			int currentIndex = elementSize;
			int parentIndex = currentIndex/2;

			while(currentIndex > 1 && minHeap.get(currentIndex)
					< minHeap.get(parentIndex))
			{
				int parentValue = minHeap.get(parentIndex);
				int currentValue = minHeap.get(currentIndex);

				minHeap.put(parentIndex,currentValue);
				minHeap.put(currentIndex, parentValue);

				elementsLookUpMap.get(parentValue).remove(parentIndex);
				elementsLookUpMap.get(currentValue).remove(currentIndex);

				elementsLookUpMap.get(parentValue).add(currentIndex);
				elementsLookUpMap.get(currentValue).add(parentIndex);

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


		if(elementsLookUpMap.get(element) == null 
			|| elementsLookUpMap.get(element).size() == 0)
		{
			System.out.println(" Heap is Empty !!!");
			return false;
		}

		int rightMostIndex = elementSize;
		elementSize--;
		int rightMostElement = minHeap.get(rightMostIndex);

	    int currentIndex = elementsLookUpMap.get(element).iterator().next();
		elementsLookUpMap.get(element).remove(currentIndex);

		elementsLookUpMap.get(rightMostElement).add(currentIndex);
		elementsLookUpMap.get(rightMostElement).remove(rightMostIndex);

		minHeap.remove(rightMostIndex);
		minHeap.put(currentIndex,rightMostElement);


		while(currentIndex <= elementSize/2)
		{
			int leftIndex = 2 * currentIndex;
			int rightIndex = 2 * currentIndex + 1;

			int minValueIndex = currentIndex;

				if(minHeap.get(leftIndex) !=  null && 
					minHeap.get(minValueIndex) > minHeap.get(leftIndex))
				{
					minValueIndex = leftIndex;
				}

				if(minHeap.get(rightIndex) != null &&
					minHeap.get(minValueIndex) > minHeap.get(rightIndex))
				{
					minValueIndex = rightIndex;
				}

				if(minValueIndex == currentIndex)
				{
					break;
				}

				Integer minChildValue = minHeap.get(minValueIndex);
				Integer parentValue = minHeap.get(currentIndex);


				minHeap.put(currentIndex,minChildValue);
				minHeap.put(minValueIndex, parentValue);

				
				elementsLookUpMap.get(minChildValue).remove(minValueIndex);
				elementsLookUpMap.get(parentValue).remove(currentIndex);


				elementsLookUpMap.get(minChildValue).add(currentIndex);
				elementsLookUpMap.get(parentValue).add(minValueIndex);

				currentIndex = minValueIndex;
		}



		return true;
	}

	public int peek()
	{
		return elementSize == 0 ? -1 : minHeap.get(1);
	}

	public void print()
	{
		//minHeap.keySet().stream().forEach(key -> System.out.print(key+"->" +minHeap.get(key)+"\n"));		
		
		System.out.println(minHeap.values());
	}

}

public class MinHeapLognDeletion
{
	public static void main(String[] args) {
		
		int[] input = {4,5,3,1,2};
		Sample s = new Sample();

		/*
			Construction Of Heap
			
			Time Complexity  : O(nlogn)
			Space Complexity : O(n)
		*/
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







