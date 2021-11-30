import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

class TimeCounter
{
	int timeStamp;
	int counter;

	public TimeCounter(int timeStamp , int counter)
	{
		this.timeStamp = timeStamp;
		this.counter = counter;
	}
}

class HitCounter
{
	Deque<TimeCounter> deque = new LinkedList<>();
	int size = 0;
	/*
		Time Complexity : O(1)	
			1<-1<-1<-2<-3<-3 
	*/
	public void hit(int timeStamp)
	{
		if(!deque.isEmpty() && deque.getLast().timeStamp == timeStamp)
		{
			TimeCounter timeCounterObj = deque.removeLast();
			timeCounterObj.counter = timeCounterObj.counter+1;
			deque.addLast(timeCounterObj);
		}else
		{
			TimeCounter timeCounterObj = new TimeCounter(timeStamp,1);
			deque.addLast(timeCounterObj);
		}

		size++;
			
	}

	// return request count of past 5 minutes : timeStamp in secs 
	// Time Complexity 	: O(300) ~ O(1) 
	// Space Complexity : O(300) ~ O(1) ~ O(Math.min(queue.size(),300))  Queue : 300*8 = 2400bytes
 	public int getHits(int timeStamp)
	{
		while(!deque.isEmpty() && timeStamp-deque.getFirst().timeStamp >= 300)
		{
			TimeCounter timeCounterRef =  deque.removeFirst();
			size = size - timeCounterRef.counter;
		}

		System.out.println(" Size Of deque :: "+deque.size());
		return size;
	}
}

public class DesingHitCounterWithDeque
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

		System.out.println(" Last 300 => "+counter.getHits(300));

	} 	

}