import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Overal Space Complexity for this design is O(n)
class TwoSum
{
	List<Integer> list = new ArrayList<>();
	boolean isSorted = false;
	/*
		Time Complexity : O(1) 
	*/
	public void add(int element)
	{
		list.add(element);
		isSorted = false;

	}

	/*
		Time Complexity : nlog(n) 
	*/

	public boolean find(int val) //14
	{
		if(isSorted == false)
		{
			Collections.sort(list);
			isSorted = true;
		}
		int low = 0;
		int high = list.size()-1;
		while(low < high) // [4,5,6,7,9] 
		{
			int twoSum = list.get(low) + list.get(high);
			if( val > twoSum)
			{
				low = low+1;

			}else if(val < twoSum)
			{
				high = high - 1;
			}else // it means val == twoSum
			{
				return true;
			}

		}
		return false;
	}


public List<Integer> getStream()
		{
			return list;
		}
}

public class TwoSumSortingEx
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






