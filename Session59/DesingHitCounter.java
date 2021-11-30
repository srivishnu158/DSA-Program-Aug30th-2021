import java.util.Queue;
import java.util.LinkedList;



class HitCounter
{
	Queue<Integer> queue = new LinkedList<>();
	/*
		Time Complexity : O(1)	
	*/
	public void hit(int timeStamp)
	{
			queue.add(timeStamp);

	}

	// return request count of past 5 minutes : timeStamp in secs 
	// Time Complexity 	: O(n) 
	// Space Complexity : O(n)
 	public int getHits(int timeStamp)
	{
		while(!queue.isEmpty() && timeStamp-queue.peek() >= 300)
		{
			queue.remove();
		}

		return queue.size();
	}
}

public class DesingHitCounter
{
	public static void main(String args[])
	{
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(1);
		counter.hit(1);
		counter.hit(1);

		counter.hit(2);


		counter.hit(3);

		counter.hit(4);

		counter.hit(5);

		System.out.println(" Last 300  => "+counter.getHits(300));

	} 	

}

/*
	In Worst case Queue should have only 300 timeStamp Requests :
	Problem when we concurrent request you queue size is increasing.
	Which effects both time & space complexity.

*/

	





