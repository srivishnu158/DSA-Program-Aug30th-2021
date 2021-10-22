
public class LinkedList
{
	 Node head = null;
	 Node tail = null;
	 int size = 0;

	public Node getHead()
	{
		return head;
	}

	public Node getTail()
	{
		return tail;
	}

	 // Adding to tail
	 public void add(int data)
	 {

	 	Node  newNode = new Node(data);
	 	if(tail == null)
	 	{
	 		tail = newNode;
	 		head = newNode;
	 	}else{
	 	tail.next = newNode;
	 	tail = newNode;
	 	}
	 
	 	size++;
	 }

	 public Node get(int index)
	 {
	 	if(index == 0)
	 	{
	 			return head;
	 	}

	 	if(index == size-1)
	 	{
	 		return tail;
	 	}

	 	// 10->20->30
	 	Node current = head;
	 	int i = 0;
	 	while( i < index)
	 	{
	 		current = current.next;
	 		i++;
	 	}
	 
	 	return current;
	 }


	public void print()
	{
		if(head == null)
			return;

		Node current = head;
		while(current != null)
		{
			System.out.print(current.data+" -> ");
			current = current.next;
		}

		System.out.println();
	}


	public int getSize()
	{
		return size;
	}
}








