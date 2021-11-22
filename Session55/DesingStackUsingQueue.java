import java.util.Queue;
import java.util.LinkedList;


class Stack
{
	Queue<Integer> pushQueue = new LinkedList<>();
    Queue<Integer> popQueue = new LinkedList<>();
    int top = -1;


	public void push(int element)
	{
		top = element;
		pushQueue.offer(element); //offer(element) is like enQueue(element)
	} 

	// Time Complexity : O(n)
	public int pop()
	{
			if(isEmpty())
			{
				return -1;
			}

			int size = pushQueue.size();

			while(size > 1)
			{
				top = pushQueue.poll();
				popQueue.offer(top);
				size--;
			}

			int value = pushQueue.poll(); // Removes last Elements

			// Swap pushQueue & PopQueue 
			Queue<Integer> temp = pushQueue;

			pushQueue = popQueue;
			popQueue = temp;

			return value;

	}

	public int top()
	{
			if(isEmpty())
			{
				return -1;
			}
		return top; // peek() is like rear()
	}

	public boolean isEmpty()
	{
		return pushQueue.isEmpty();
	}
}

public class DesingStackUsingQueue
{
	public static void main(String args[])
	{
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println(" top() => "+s.top()); // 3

	    System.out.println(" pop() =>  "+s.pop()); // 3

	    System.out.println(" After pop the  top() => "+s.top()); // 2


	    s.push(4);
		s.push(5);

		System.out.println(" top() => "+s.top()); // 5

	    System.out.println(" pop() =>  "+s.pop()); // 5

	    System.out.println(" After pop the  top() => "+s.top()); // 4
	    System.out.println(" pop() =>  "+s.pop()); // 4

	    System.out.println(" top() => "+s.top()); // 2



	}

}







 






