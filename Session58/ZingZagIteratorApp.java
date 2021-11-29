
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;


class ZingZagIterator
{

	Queue<Integer> queue = new LinkedList<>();


	/*
				v1 : [1,2,3]
				v2: [4,5,6,7,8]
	*/
	public ZingZagIterator(List<Integer> v1, List<Integer> v2)
	{
			int size = v1.size() > v2.size() ? v1.size() : v2.size();
			for(int i = 0 ; i<size ; i++)
			{
				if( i < v1.size())
				{
					queue.add(v1.get(i));
				}

				if(i < v2.size())
				{
					queue.add(v2.get(i));
				}
			}
	}

	// output: 1 <- 4 <- 2 <- 5 <- 3 <- 6 <- 7 <- 8
	/*
		Time Complexity : O(1)
	*/
	public int next()
	{
		return queue.remove();
	}


	/*
		Time Complexity : O(1)
	*/
	public boolean hasNext()
	{
		return !queue.isEmpty();
	}
}

public class ZingZagIteratorApp
{
	public static void main(String args[])
	{
		List<Integer> v1 = List.of(1,2,3);
		List<Integer> v2= List.of(4,5);

	ZingZagIterator iterator = new ZingZagIterator(v1,v2);

		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " -> ");
		}
	}
}









