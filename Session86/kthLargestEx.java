import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Sample 
{
	/*
	Time Complexity : O(nlogk)
	Space Complexity : O(k)
	*/
	public int kthLargest(int[] nums, int k)
	{
		Queue<Integer> minHeap = new PriorityQueue<>((n1,n2)-> n1-n2); // minHeap
	
		for(int i = 0 ; i < nums.length ; i++)
		{

			if(minHeap.size() < k )
			{
                minHeap.add(nums[i]);
				
			}else if(nums[i] > minHeap.peek())
			{
				
                 minHeap.poll();
				minHeap.add(nums[i]);
			}
    
		}


		return minHeap.peek();
	}

}

public class kthLargestEx
{
	public static void main(String[] args) {
		Sample s = new Sample();

		System.out.println(s.kthLargest(new int[]{10,2,15,7,0},2));


	}

}








