import java.util.Map;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

class Sample {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length)
        {
            return nums;
        }
        
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(Integer e : nums)
        {
            map.putIfAbsent(e,0);
            map.put(e, map.get(e)+1);
        }
        
        Queue<int[]> minHeap = new PriorityQueue<>((p1,p2) -> p1[1] - p2[1]);
        
        for(Integer element : map.keySet())
        {
            int counter = map.get(element);
            
                if(minHeap.size() < k )
                {
                    minHeap.add(new int[]{element,counter});
                }else if(counter > minHeap.peek()[1])
                {
                    minHeap.poll();
                    minHeap.add(new int[]{element,counter});
                }
            
        }
        
        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty())
        {
            result[index] = minHeap.poll()[0];
            index++;
        }
        return result;
    }
}

public class TopMostKRepeatedElements
{
	public static void main(String[] args) {
		
		int[] input = {11,10,15,13,22,15,22,35,33,22,35};
						// 11=1 , 10=1 , 15=2 , 13=1 , 22=3, 35=2,33=1 
		int k = 3; 
		Sample s = new Sample();

		int[] result = s.topKFrequent(input,k); // [22,15,35]

		System.out.println(Arrays.toString(result));

	}
}




