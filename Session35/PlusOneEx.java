class Sample
{

	public Node plusOne(Node head)
	{
		Node sentimalNode  = new Node(0);
		sentimalNode.next = head;
		Node notNinePtr = sentimalNode;

		Node current = head;
		while(current != null)
		{
			if(current.data != 9)
			{
				notNinePtr = current;
			}
			current = current.next;
		}

		notNinePtr.data = notNinePtr.data + 1;
		notNinePtr = notNinePtr.next;
		while(notNinePtr != null)
		{
			notNinePtr.data = 0;
			notNinePtr = notNinePtr.next;
		}

		return sentimalNode.data != 0 ? sentimalNode : sentimalNode.next;
	}

}


public class PlusOneEx
{

	public static void main(String args[])
	{
		Sample s = new Sample();
		LinkedList  list = new LinkedList();
		list.add(9);
		list.add(9);
		list.add(9);

		Node head = list.getHead();

		Node plusOneNode = s.plusOne(head);

		while(plusOneNode != null)
		{
			System.out.print(plusOneNode.data+" -> ");
			plusOneNode = plusOneNode.next;
		}
	}

}






