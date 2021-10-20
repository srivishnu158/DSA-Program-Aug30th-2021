
class Sample
{

public boolean isLoopExist(Node head)
	{
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null)
		{
		
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
			{
				return true;
			}
		}

		return false;
	}


}

public class CycleEx
{
	public static void main(String arg[])
	{
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
	

		Node node20 = list.get(1);
		Node head = list.getHead();
		list.getTail().next = list.get(0);

		Sample s = new Sample();
		System.out.println("  Is Loop Exists => "+s.isLoopExist(head));
	}
}







