
class Sample
{


public Node intersectionPoint(Node head)
	{
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null)
		{
		
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
			{
				break;
			}
		}

		slow = head;

		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}


		return slow;
	}


}

public class IntersectionPointEx
{
	public static void main(String arg[])
	{
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
	


		Node node40 = list.get(3);
		Node head = list.getHead();
		list.getTail().next = node40;

		Sample s = new Sample();
		Node inode = s.intersectionPoint(head);
		System.out.println("  IntersectionNode => "+inode.data);
	}
}







