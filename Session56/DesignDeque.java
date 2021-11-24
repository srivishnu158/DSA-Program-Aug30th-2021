class  DLLNode
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

class Deque
{
		DLLNode dummyHead = null;
		DLLNode dummyTail = null;

		public Deque()
		{
			dummyHead = new DLLNode();
			dummyTail = new DLLNode();

			dummyTail.next = dummyHead;
			dummyHead.prev = dummyTail;

		}

			/*
			  			-> 
			 	front		dummyHead
						<-

						 
			 	front	->  current ->	dummyHead
			 			 <-		    <-

				*/
		public void addFirst(int element)
		{
				DLLNode front = dummyHead.prev;

				DLLNode current = new DLLNode(element);
				current.next = dummyHead;
				dummyHead.prev = current;

				front.next = current;
				current.prev = front;

		}

		/*
			  				-> 
			 	dummyTail		rear
							<-

						 
			 	dummyTail	->  current ->	rear
			 			   <-		    <-

				*/
		public void addLast(int element)
		{
				DLLNode rear = dummyTail.next;
				DLLNode current = new DLLNode(element);
				current.next = rear;
				rear.prev = current;

				dummyTail.next = current;
				current.prev = dummyTail;

		}

		/*
			  			 
			front.prev  ->  front	->	dummyHead
						<-			<-

				
				Make sure front.prev is going be new front for removeFirst 
			 	front.prev	->  dummyHead ->	
			 			   <-		      <-

				*/
		public int removeFirst()
		{
				if(isEmpty())
				{
					return -1;
				}

				DLLNode front = dummyHead.prev;

				dummyHead.prev = front.prev;
				front.prev.next = dummyHead;

				front.next = null;    
				front.prev = null; // This helps GC 

				return front.value;

		}

		/*
			  			 
			dummyTail   ->  rear	->	rear.next
						<-			<-

				
				Make sure dummyTail.next is going be new rear for removeLast
			 	dummyTail	->  rear.next 	
			 			    <-		      

				*/

		public int removeLast()
		{
			if(isEmpty())
				{
					return -1;
				}

			DLLNode rear = dummyTail.next;

			dummyTail.next = rear.next;
			rear.next.prev = dummyTail;

			rear.next = null;
			rear.prev = null; // This helps GC 

			return rear.value;
		}

		public int front()
		{
				if(isEmpty())
				{
					return -1;
				}
			return dummyHead.prev.value;
		}

		public int rear()
		{
			if(isEmpty())
				{
					return -1;
				}

			return dummyTail.next.value;
		}

		public boolean isEmpty()
		{
				return dummyTail.next == dummyHead;
		}

		public void printDeque()
		{
			DLLNode rear = dummyTail.next;
			System.out.print("[ dummyHead  ");
			while(rear != dummyHead)
			{
				System.out.print("->"+rear.value);
				rear = rear.next;
			}

			System.out.print("-> dummyTail ] \n");

		}
}

public class DesignDeque
{
	public static void main(String args[])
	{
		Deque queue = new Deque();

		queue.addFirst(1); 
		
		queue.addFirst(2); 

		queue.addFirst(3); 

		System.out.println(" \n After 3 addFirsts ");
		queue.printDeque();  //dummyTail->1->2->3->dummyHead

		System.out.println("Front "+queue.front()); // 3
		System.out.println("Rear "+queue.rear()); // 1

		queue.addLast(4); 
		
		queue.addLast(5); 

		queue.addLast(6); 

		System.out.println(" \n After 3 addLast ");
		queue.printDeque();  //dummyTail->6->5->4->1->2->3->dummyHead

		System.out.println("Front "+queue.front()); // 3
		System.out.println("Rear "+queue.rear()); // 6

		queue.removeFirst();
		queue.removeLast();

		System.out.println(" \n After 1 time removeFirst & removeLast ");
		queue.printDeque();  //dummyTail->5->4->1->2->dummyHead

		System.out.println("Front "+queue.front()); // 2
		System.out.println("Rear "+queue.rear()); // 5


		System.out.println(" \n After n time's removeFirst & removeLast ");

		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();
		queue.removeFirst();
		queue.removeLast();

		System.out.println(" \n isQueue Emty "+queue.isEmpty());// true
	}
}




