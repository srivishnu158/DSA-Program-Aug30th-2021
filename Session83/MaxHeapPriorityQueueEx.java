import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

public class MaxHeapPriorityQueueEx
{
	public static void main(String[] args) {

		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		int[] input = {4,5,3,11,7};
		for(int i = 0 ; i < input.length ; i++)
		{
			maxHeap.add(input[i]);
		System.out.println(" \nAfter add("+input[i]+") => "+maxHeap);
		}

		maxHeap.remove(7);
		System.out.println("\n After delete(7) => "+maxHeap);
		

		maxHeap.remove(11);
		System.out.println(" \nAfter delete(11) => "+maxHeap);
		
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
