import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeapPriorityQueueEx
{
	public static void main(String[] args) {

		Queue<Integer> minHeap = new PriorityQueue<>();

		int[] input = {4,5,3,1,2};
		for(int i = 0 ; i < input.length ; i++)
		{
			minHeap.add(input[i]);
		System.out.println(" \nAfter add("+input[i]+") => "+minHeap);
		}

		minHeap.remove(1);
		System.out.println("\n After delete(1) => "+minHeap);
		

		minHeap.remove(4);
		System.out.println(" \nAfter delete(4) => "+minHeap);
		
	}
}

/*
	[4] -> add(4)
	[4,5] -> add(5)
	[3,5,4] -> add(3)
	[1,3,4,5] -> add(1)
	[1,2,4,5,3]->add(2)


	delete(1) -> [2,3,4,5]
	delete(4) -> [2,3,5]


*/
