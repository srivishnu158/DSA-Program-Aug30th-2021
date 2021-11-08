import java.util.List;
import java.util.ArrayList;

// Overal Space Complexity for this design is O(n)
class TwoSum
{
	List<Integer> list = new ArrayList<>();
	/*
		Time Complexity : O(1) 
	*/
	public void add(int element)
	{
		list.add(element);

	}

	/*
		Time Complexity : O(n^2) 
	*/

	public boolean find(int val)
	{
		for(int i = 0 ; i < list.size() ; i++)
		{
			int diff = val - list.get(i);

			for(int j = i+1; j < list.size() ; j++)
					{
						if(i != j &&  diff == list.get(j))
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

public class BruteForceEx
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






