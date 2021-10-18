class Node
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data = data;
		next = null;
	}

}

class LinkedList
{
	 Node head = null;
	 Node tail = null;
	 int size = 0;

	 public void addHead(int data)
	 {
	 	Node  newNode = new Node(data);
	 	newNode.next = head;
	 	head = newNode;
	 	size++;
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

	 public void addAtIndex(int index, int data)
	 {
	 	if(index == 0)
	 	{
	 			addHead(data);
	 			return;
	 	}

	 	if(index == size)
	 	{
	 		add(data);
	 		return;
	 	}

	 	Node prev = head;
	 	Node current = head.next;
	 	int i = 1;
	 	while( i < index)
	 	{
	 		prev = current;
	 		current = current.next;
	 		i++;
	 	}
	 
	 	Node newNode = new Node(data);
	 	prev.next = newNode;
	 	newNode.next = current;
	 	size++;
	 }

	 public void deleteHead()
	 {
	 	if(head == null)
	 		return;

	 	head = head.next;
	 	size--;
	 }

	 public void deleteTail()
	 {
	 	if(head == null)
	 		return;



	 	// 10 -> 20 -> 30 -> 40 -> 45 -> 
	 	// 
	 	Node prev = head;
	 	for(int i = 1; i < size-1 ; i++)
	 	{
	 		prev = prev.next;
	 	}

	 	prev.next = null;
	 	tail = prev;
	 	size--;
	 }

	 public void deleteAtIndex(int index)
	 {
	 	if(index == 0)
	 	{
	 			deleteHead();
	 			return;
	 	}

	 	if(index == size-1)
	 	{
	 		deleteTail();
	 		return;
	 	}

	 		// 10-> 20 -> 30 -> 40 -> null
	 		// delete(2)
	 			// prev = 10, current = 20 i = 1 :: 1 < 2  prev = 20 current=30
	 			// 2 < 2
	 	Node prev = head;
	 	Node current = head.next;
	 	for(int i = 1; i < index ; i++)
	 	{
	 		prev = current;
	 		current = current.next;
	 	}

	 	prev.next = current.next;
	 	current.next = null;
	 	size--;
	 }


	 public void deleteByData(int data)
	 {
	 		if(head == null)
	 			return;

	 		Node current = head;
	 		// 10->20->30->20->50  delete(20)
	 		// current = 20 
	 		// current = 30
	 		for(int i = 0 ; i < size ; i++)
	 		{
	 			Node next = current.next;
	 			if(current.data == data)
	 			{
	 				deleteAtIndex(i);
	 			}
	 			current = next;
	 		}
	 }

	public int getSize()
	{
		return size;
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
}

public class LinkedListApp
{
	public static void main(String[] args) {
			LinkedList list = new LinkedList();
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(40);
			list.print();

			list.addHead(5);

			System.out.print(" Add Head =>");
			list.print();

			System.out.print(" Add Tail =>");
			list.add(45);
			list.print();

			System.out.print(" Add at Index 2 =>");
			list.addAtIndex(2,15);
			list.print();




			System.out.print(" Delete at Index 2 =>");
			list.deleteAtIndex(2);
			list.print();

			list.deleteHead();
			System.out.print(" delete Head =>");
			list.print();

			System.out.print(" delete Tail =>");
			list.deleteTail();
			list.print();



			list.addHead(3);
			System.out.print(" After Delete Add Head =>");
			list.print();

			System.out.print(" After Delete Add Tail =>");
			list.add(55);
			list.print();

	}
}








