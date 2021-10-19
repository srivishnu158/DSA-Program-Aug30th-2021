class Sample
{
	public int getIntFromBinary(Node head)
	{
		// 1 -> 1 -> 0 -> 1 -> null

		int size = 0;
		Node current = head;

		while(current != null)
		{
			current = current.next;
			size++;
		}

		current = head;
		int value = 0;

		while(current != null)
		{
			size = size-1;
			value = value + current.data * (int)Math.pow(2,size);
			current = current.next;
		}

		return value;
	}

}

public class BinaryToIntApp
{
	public static void main(String args[])
	{
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(1);
		list.add(0);
		list.add(1);

		Node head = list.getHead();

		Sample s = new Sample();
		int value = s.getIntFromBinary(head);
		System.out.println(value);
	}
}




