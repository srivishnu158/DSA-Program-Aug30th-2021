import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Sample 
{
	public List<Integer> heapSort(int[] elements)
	{

		Queue<Integer> minHeap = new PriorityQueue<>((n1,n2)-> n1-n2); // minHeap
			
		List<Integer> elementsList  = new ArrayList<>();
		/*
	 	Queue<Integer> maxHeap = 
	 	new PriorityQueue<>((n1,n2)-> n2-n1);
	 	Max Heap
		
		// Heapify O(Nlog(n))
		for(int i = 0 ; i < elements.length ; i++)
		{
			minHeap.add(elements[i]);
		}
		*/

		for(int i = 0 ; i < elements.length ; i++)
		{
			elementsList.add(elements[i]);
		}

		minHeap.addAll(elementsList); // Heapify O(N)

		elementsList.clear();

		// O(nlogn)
		while(!minHeap.isEmpty())
		{
			elementsList.add(minHeap.poll());
		}

		return elementsList;
	}

}

public class HeapSortEx
{
	public static void main(String[] args) {
		Sample s = new Sample();

		System.out.println(s.heapSort(new int[]{10,2,15,7,0}));
	}

}








