import java.util.Queue;
import java.util.PriorityQueue;
public class MinHeapTest
{
	public static void main(String args[])
	{
		Queue<Integer> queue = new PriorityQueue<>();

		queue.add(10);
		queue.add(5);
		queue.add(13);
		queue.add(2);
		queue.add(8);
		queue.add(2);
		queue.add(1);
		queue.add(2); 


		System.out.println("Before Remove "+queue);  //[1,2,2,5,8,13,2,10]
		System.out.println(" peek() => "+queue.peek());

		queue.remove(2);

		System.out.println("After Remove"+queue); // [1,5,2,10,8,13,2]



	}
}