import java.util.Deque;
import java.util.LinkedList;

/*
class Data
{
	int index;
	int value;
}
*/

class TicketCounter
{

	/*
		Time Complexity : 
				O(n * Math.min(k,ticketNo))
		Space Timecomplexity: O(n)
	*/
	public int getTime(int[] tickets, int k)
	{
		  Deque<int[]> deque = new LinkedList<>();

			int timeCounter = 0;
		for(int i = 0 ; i < tickets.length ; i++)
		{
			int[] arr = new int[]{i,tickets[i]};
			deque.addLast(arr);
		}

		while(!deque.isEmpty())
		{
				int[] arr = deque.removeFirst();
				++timeCounter;
				arr[1] = arr[1] - 1; // decrementing value


				if(arr[0] == k && arr[1] == 0)
				{
					break;
				}

				if(arr[1] > 0)
				{

					deque.addLast(arr);
				}

		}

		return timeCounter;
	}


	/*
		Time Complexity : 
				O(n * k)
		Space Timecomplexity: O(1)
	*/
	public int getTime2(int[] tickets, int k)
	{
		 
		int  timeCounter = 0;
		int index = 0;
		int n = tickets.length;
	
		while(tickets[k] > 0)
		{
				if(tickets[index] >  0)
				{
					tickets[index] = tickets[index] - 1; 
					++timeCounter; 
				}
				
				if(index == k && tickets[index] == 0 )
				{
					break;
				}
				index = (index+1)%n; 

		}

		return timeCounter;
	}
}


public class TicketCounterApp
{
	public static void main(String args[])
	{
		TicketCounter ticketCounter = new TicketCounter();
		int[] tickets = {2,3,2};


		System.out.println(" position[0] => "+ticketCounter.getTime(tickets,0)); // 4Secs
		System.out.println(" position[1] => "+ticketCounter.getTime(tickets,1)); // 7Secs
		System.out.println(" position[2] => "+ticketCounter.getTime(tickets,2)); // 6Secs


		System.out.println(" \n\n position[0] => "+ticketCounter.getTime2(tickets,0)); // 4Secs
		
		tickets = new int[]{2,3,2};
		System.out.println(" position[1] => "+ticketCounter.getTime2(tickets,1)); // 7Secs

		tickets = new int[]{2,3,2};
		System.out.println(" position[2] => "+ticketCounter.getTime2(tickets,2)); // 6Secs


	}
}



