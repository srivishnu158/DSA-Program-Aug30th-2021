import java.util.Stack;


class Queue
{
	Stack<Integer> pushStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();
	int rear = -1;

	public void enQueue(int element)
	{
		rear = element;
		pushStack.push(element); // pushStack : 3 <- 2 <- 1
	}

	public int deQueue() 
	{
			if(isEmpty())
			{
				return -1;
			}

			if(popStack.isEmpty())
			{
				while( ! pushStack.isEmpty())
				{
						popStack.push(pushStack.pop());
				}
			}

			return popStack.pop();

	} // popStack :  1 <- 2 <- 3

	public int rear()
	{
		if(isEmpty())
		{
			return -1;
		}

		return rear;
	}


	public int front()
	{
		if(isEmpty())
		{
			return -1;
		}

	 if(popStack.isEmpty())
			{
				while( ! pushStack.isEmpty())
				{
						popStack.push(pushStack.pop());
				}
			}

		return popStack.peek();
	}

	public boolean isEmpty()
	{
		return pushStack.isEmpty() && popStack.isEmpty();
	}
}


public class DesingQueueUsingStack
{
	public static void main(String args[])
	{
		Queue q = new Queue();
		q.enQueue(1);
		
		q.enQueue(2);

		q.enQueue(3);

		System.out.println(" Front : "+q.front()); // 1
		System.out.println(" Rear : "+q.rear()); // 3

		q.deQueue();

		System.out.println("\n After DeQueue Front : "+q.front()); // 2
		System.out.println(" Rear : "+q.rear()); // 3

		q.enQueue(4);

		System.out.println("\n After DeQueue Front : "+q.front()); // 2
		System.out.println(" Rear : "+q.rear()); // 4

		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();

		System.out.println("\n After DeQueue of ntimes Front : "+q.front()); // -1
		System.out.println(" Rear : "+q.rear()); // -1
	}

}







