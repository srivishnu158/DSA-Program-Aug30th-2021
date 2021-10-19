
class Sample
{


	/*
		After reverse for the CurrentNode -> 
		previous Node is going to be the nextNode.
	*/
	public Node reverseList(Node head)
	{
			Node current = head;
			Node prev = null;

			// 10 -> 20 -> 30 -> 40 -> null
			/*
				current[10]
				prev = null;

				Node nextTemp = current.next; [20]
				current.next = prev;  [10]-> null
				prev = current;
				current = nextTemp ; [20]


				current[20]
				prev = [10]-> null;

				Node nextTemp = current.next; [30]
				current.next = prev;  20->[10]-> null
				prev = current;
				current = nextTemp ; [30]

				current[30]
				prev = 20->[10]-> null;

				Node nextTemp = current.next; [40]
				current.next = prev;  30 -> 20->[10]-> null;
				prev = current;
				current = nextTemp ; [40]


				current[40]
				prev = 30->20->[10]-> null;

				Node nextTemp = current.next; [null]
				current.next = prev;  40 -> 30 -> 20->[10]-> null;
				prev = current;
				current = nextTemp ; [null]

				current[null] 
				prev = 40 -> 30->20->[10]-> null;

			*/

			while( current != null)
			{
					Node nextTemp = current.next;
					current.next = prev;
					prev = current;
					current = nextTemp;
			}
			return prev;
	}

	
}

public class ReverseList
{
	public static void main(String args[])
	{
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		Node head = list.getHead();

		Sample s = new Sample();
		Node current = s.reverseList(head);

		while(current != null)
		{
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		
	}
}




