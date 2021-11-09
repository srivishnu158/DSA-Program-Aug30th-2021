import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

// Overal Space Complexity for this design is O(n)
class TwoSum
{
	Map<Integer,Integer> map = new HashMap<>();
	/*
		Time Complexity : O(1) 
	*/
	public void add(int element) // 3,1,5,3 => {map :: 3->2 , 1->1 , 5->1}
	{

		map.putIfAbsent(element,0);
		int count = map.get(element) + 1;
		map.put(element,count);

	}

	/*
		Time Complexity : O(n) 
	*/

	public boolean find(int val) 
	{
		Set<Map.Entry<Integer,Integer>> set = map.entrySet();

		for(Map.Entry<Integer,Integer> me : set)
		{
			int key = me.getKey();
			int keyCount = me.getValue();
			int diff = val - key;

			if(key == diff && keyCount > 1)
			{
				return true;
			}

			if( key  != diff && map.containsKey(diff))
			{
				return true;
			}

		}
		return false;
	}


public Map<Integer,Integer> getStream()
		{
			return map;
		}
}

public class TwoSumHashingEx
{
	public static void main(String args[])
	{

		TwoSum t = new TwoSum();
		t.add(3);
		t.add(2);
		t.add(1);

		System.out.println(" \nStream :: => "+t.getStream());
		System.out.println(" find(3) :: => "+t.find(3)); // true  1+2
		System.out.println(" find(2) :: => "+t.find(2)); // false  
		t.add(0);
		t.add(1);
		t.add(0);


		System.out.println(" \nStream :: => "+t.getStream());
		System.out.println(" find(0) :: => "+t.find(0)); // true : 0+0
		System.out.println(" find(2) :: => "+t.find(2)); // true : 1+1  

		t.add(-1);
		t.add(6);

		System.out.println(" \nStream :: => "+t.getStream());
		System.out.println(" find(5) :: => "+t.find(5)); // true : 6-1
		System.out.println(" find(8) :: => "+t.find(8)); // true : 6+2  
		System.out.println(" find(10) :: => "+t.find(10)); // false : 6+3+1 Not Two element Sum  

	}
}






