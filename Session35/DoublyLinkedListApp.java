class Node
{
	 int data;
	 Node next;
	 Node prev;

	public Node()
	{

	}

	public Node(int data)
	{
		this.data  = data;
		next = null;
		prev = null;
	}
}

class DoublyLinkedList
{
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public Node getHead()
	{
		return head;

	}

	public Node getTail()
	{
		return tail;

	}


	public void addHead(int data)
	{
		Node newNode  = new Node(data);
		newNode.next = head;
		if(head != null)
		{
			head.prev = newNode;
			head = newNode;

		}
		else
		{
			head = newNode;
			tail = head;
		}
		
		size++;
	}

	// adding to tail
	public void add(int data)
	{
			if(tail == null)
			{
				addHead(data);
			}else
			{
			Node newNode  = new Node(data);
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			}
		size++;
	}

	public void addAtIndex(int index, int data)
	{
		if( index == 0)
		{
			addHead(data);
		}
		else if(index == size-1)
		{
			add(data);
		}
		else
		{
				// 10 -> 20 -> 30 
			Node current = head;
			int i = 1;
			while( i <= index)
			{
				current = current.next;
				i++;
			}

			Node previous = current.prev;
			Node next  = current.next;
			Node newNode = new Node(data);

			previous.next = newNode;
			newNode.prev = previous;

			newNode.next = current;
			current.prev = newNode;
			size++;
		}
	}


// removing at tail
	public void removeHead()
	{
		if(head == null)
		{
			return;
		}

		Node newHead = head.next;
		 head.next = null;

		 head = newHead;
		 head.prev = null;
		size--;
		
	}
	// removing at tail
	public void remove()
	{
		if(tail == null)
		{
			return;
		}

		Node previous = tail.prev;
		previous.next = null;
		tail.prev = null;

		tail = previous;
		size--;
		
	}



	public void removeAtIndex(int index)
	{
			if( index == 0)
		{
			removeHead();
		}
		else if(index == size-1)
		{
			remove();
		}
		else
		{
				// 10 -> 20 -> 30 
			Node current = head;
			int i = 1;
			while( i <= index)
			{
				current = current.next;
				i++;
			}

			Node previous = current.prev;
			Node next  = current.next;
		
			previous.next = next;
			next.prev = previous;

			current.prev = null;
			current.next = null;
			size--;
		}
	}

	public void print()
	{
		Node current = head;
		System.out.print("Forward :: ");
		while(current != null)
		{
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println();
		Node previous = tail;
		System.out.print("Backward ::  ");
		while(previous != null)
		{
			System.out.print(previous.data+" -> ");
			previous = previous.prev;
		}
	System.out.println();
	}
}


public class DoublyLinkedListApp
{
	
	public static void main(String[] args) {
			DoublyLinkedList list = new DoublyLinkedList();
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(40);
			list.print();

			list.addHead(5);

			System.out.println(" Add Head =>");
			list.print();

			System.out.println(" Add Tail =>");
			list.add(45);
			list.print();

			System.out.println(" Add at Index 2 =>");
			list.addAtIndex(2,15);
			list.print();




			System.out.println(" Delete at Index 2 =>");
			list.removeAtIndex(2);
			list.print();

			list.removeHead();
			System.out.println(" delete Head =>");
			list.print();

			System.out.println(" delete Tail =>");
			list.remove();
			list.print();



			list.addHead(3);
			System.out.println(" After Delete Add Head =>");
			list.print();

			System.out.println(" After Delete Add Tail =>");
			list.add(55);
			list.print();

			System.out.println(" After Delete Add in at Index 2 =>");
			list.addAtIndex(2,15);
			list.print();

	}
}








