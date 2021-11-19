class DLLNode
{
	int value;
	DLLNode prev;
	DLLNode next;
	public DLLNode()
	{
	}

	public DLLNode(int value)
	{
		this.value = value;
		prev = null;
		next = null;
	}


} 

// null<- dummyHead ---> dummyTail --> null

//null<- dummyHead ---> head ----> ........-> tail <---- dummyTail --> null


class Queue
{
  DLLNode dummyHead;
  DLLNode dummyTail;
  int size ;

  public Queue()
  	{
  		size = 0;
dummyHead = new DLLNode(-1);
dummyTail = new DLLNode(-1);
dummyTail.next = dummyHead; // Rear
dummyHead.prev = dummyTail; // Front

/*  		next
			----> 
dummyTail				dummyHead
			<----
			prev
*/

  	}
  		/*
  			Time Complexity : O(1)
  			Adds to rear : adds to dummyTail.next
  		*/
  	public void enQueue(int element)
  	{
  			DLLNode currentNode = new DLLNode(element);

  			DLLNode tailNext = dummyTail.next;

  			tailNext.prev = currentNode;
  			currentNode.next = tailNext;
  			currentNode.prev = dummyTail;
  			dummyTail.next = currentNode;

  			size++;

  	}

  		/*
  			Time Complexity : O(1)
  			Removes From front : dummyHead.prev
  		*/
  	public void deQueue()
  	{
  			
  			if(isEmpty())
  			{
  				return;
  			}

  			DLLNode headPrev = dummyHead.prev;

  			dummyHead.prev = headPrev.prev;
  			headPrev.prev.next = dummyHead;

  			headPrev.next = null;
  			headPrev.prev = null; // Helps GC
  			size--;

  	}

  		/*
  			Time Complexity : O(1)
  		*/

  	public boolean isEmpty()
  	{
  		return size == 0;
  	}

  		/*
  			Time Complexity : O(1)
  		*/
  	public int getFront()
  	{
  		if(isEmpty())
  		{
  			return -1;
  		}

  		return dummyHead.prev.value;
  	}

  		/*
  			Time Complexity : O(1)
  		*/
  	public int getRear()
  	{
  		if(isEmpty())
  		{
  			return -1;
  		}

  		return dummyTail.next.value;
  	}

  	// Printing From Rear --to--> Front
  	public void printQueue()
	{
		String data = "[ dummyTail -> ";
		DLLNode current = dummyTail.next;
		while(current != dummyHead)
		{
			data = data +current.value+ " -> " ;
			current = current.next;
		}
		data = data+"  dummyHead ]";
		System.out.println(data);
	}
}

public class QueueDesign
{
	public static void main(String args[])
	{
			Queue q = new Queue();

			q.enQueue(10);
			q.enQueue(20);
			q.enQueue(30);
			System.out.println(" After 3 enqueue's ");
			q.printQueue();// 30 -> 20 -> 10 
		
		System.out.println(" Rear => "+q.getRear()); // 30
	    System.out.println(" Fornt => "+q.getFront()); //10



	    	q.deQueue();
	    	q.deQueue();
	   
	   System.out.println(" \n\n After twice of deQueue()  "); 

	   	q.printQueue();// 30 

	    q.enQueue(40);
	    q.enQueue(50);

	  System.out.println(" \n\n After twice of enQueue() "); 

	    q.printQueue();// 50 -> 40 -> 30 


	    System.out.println(" Rear => "+q.getRear()); // 50
	    System.out.println(" Fornt => "+q.getFront()); //30

	    q.deQueue();
	    System.out.println("\n\nAfter one time of deQueue()  ");

	    q.printQueue();// 50 -> 40

	    	q.deQueue();
	    	q.deQueue();
	    	q.deQueue();
	    	q.deQueue();
	   System.out.println("\n\nAfter n time's of deQueue()  ");
	       q.printQueue();// Should be empty Queue
	}
}












