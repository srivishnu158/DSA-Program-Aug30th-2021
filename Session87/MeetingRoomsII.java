import java.util.Map;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

class Sample {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        // Arrays.sort does QuickSort its inplace algorithm so the intervals have the sorted elements
        
        Queue<int[]> minHeap = new PriorityQueue<>((m1, m2) -> m1[1] - m2[1]);
        
            
        minHeap.add(new int[] {intervals[0][0], intervals[0][1]});
            
            for(int i = 1 ; i <intervals.length ; i++ )
            {
                int[] meeting = intervals[i];
                
                if(meeting[0] >= minHeap.peek()[1])
                {
                    minHeap.poll();
                    minHeap.add(meeting);
                }else
                {
                    minHeap.add(meeting);
                }
                
                
            }
        
        return minHeap.size();
    }
}

public class MeetingRoomsII
{
	public static void main(String[] args) {

		int[][] intervals = { {7,10},{45,60}, {2,4},{3,7},{41,44},{9,15},{15,30} };

		Sample s = new Sample();
		System.out.println(s.minMeetingRooms(intervals));// 2
		
	}
}





