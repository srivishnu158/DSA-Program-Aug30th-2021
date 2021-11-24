import java.util.Deque;
import java.util.LinkedList;


class WindowStream
{
	int windowSum = 0;
	int size  = 0;
	int capacity =0;

	//  java.util.LinkedList is the implementation of java.util.Deque : 
	Deque<Integer> queue = new LinkedList<>();

	public WindowStream(int capacity)
	{
		this.capacity = capacity;
	}

	/* stream (3) :  1 => 1/1 : 2->1 => 2+1/2 :  3->2->1 : 3+2+1/3
				  :  4+3+2+1 : size > capacity :  4+3+2+1-1 = 4+3+2 / 3

				  TimeComplexity  : O(1)
				  SpaceComplexity : O(Math.min(queueSize,streamSize)) 
	 */

	public double nextAvg(int element)
	{
		size++;
		windowSum = windowSum+element;
		queue.addLast(element);
		if(size > capacity)
		{
			int front = queue.removeFirst();
			windowSum = windowSum-front;
			size--;
		}

		return (windowSum * 1.0 )/size;

	}

}


public class WindowStreamAvgEx
{
	public static void main(String args[])
	{
		WindowStream stream = new WindowStream(3);

		System.out.println(" 1 -> Avg = "+stream.nextAvg(1)); //1
		System.out.println(" 2 -> 1 -> Avg = "+stream.nextAvg(2)); //1.5
		System.out.println(" 3 -> 2 -> 1 -> Avg = "+stream.nextAvg(3)); // 2

		System.out.println("4 -> 3 -> 2 -> Avg = "+stream.nextAvg(4)); //3
		System.out.println("5 -> 4 -> 3 -> Avg = "+stream.nextAvg(5));//4
		System.out.println("6 -> 5 -> 4 -> Avg = "+stream.nextAvg(6));//5

	}
}



/*
	
  Stream Size : 3  
  		int[] stream = new int[capacity]

  1000 

  1cr to streams : 

  	stream contains latest 3 elements

  	what about remaining 99L99T997 elements to be GC

  	So the above logic is not recommended !!!!
*/





