
class Sample
{
	
	//10 -> 20 -> 30 -> 40 -> null
		/* reverse(10)
				reverse(20)
					reverse(30)
						reverse(40)
							reverse(null)

	Time Complexity : O(n)
	Space Complexity : O(n)
				*/

	public void reverse(Node current)
	{
		if(current == null)
			return;
		reverse(current.next);
		System.out.println(current.data);
	}

	
}

public class ReverseImmutableList
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
		s.reverse(head);
		
	}
}




