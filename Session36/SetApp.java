import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

//int[] = {10,20,30,40}
// 0 -> 10
// 1 -> 20

//List<Integer> buckets[] = {...}
// 0 -> List1
// 1 -> List2

class Set
{
	int maxLength = 5;
	List<Integer> buckets[] = new LinkedList[maxLength];



	/*
	Time Complexity : 
		Average Case: O(1)
		Worst Case : O(logn)
	*/
	public void add(int value)
	{
			int index = getBucketIndex(value);
			if( isExists(value) == false )
			{
				List<Integer> listOfValues = buckets[index];
				if(listOfValues == null)
				{
					buckets[index] = new LinkedList<Integer>();
				}

				buckets[index].add(value);
			}

	}

/*
	Time Complexity : 
		Average Case: O(1)
		Worst Case : O(logn)
	*/
	public void remove(int value)
	{
		int index = getBucketIndex(value);
		if(isExists(value) == true)
		{
			List<Integer> listOfValues = buckets[index];
			for(int i = 0 ; i < listOfValues.size() ; i++)
			{
				if(listOfValues.get(i) == value)
				{
					listOfValues.remove(i);
					return;
				}
			}
		}
	}

	/*
	Time Complexity : 
		Average Case: O(1)
		Worst Case : O(logn)
	*/

	public boolean contains(int value)
	{
		return isExists(value);
	}

	public int getBucketIndex(int value) // Its representation of hascode(..) method
	{

		return value%maxLength;
	}

	public boolean isExists(int value) // Its representatio of equals(...) method
	{
		int index = getBucketIndex(value);
		List<Integer> listOfValues =  buckets[index];
		if(listOfValues == null)
		{
			return false;
		}

		for(int i = 0 ; i < listOfValues.size() ; i++)
		{
			if(value == listOfValues.get(i))
				return true;
		}

		return false;
	}

	public void print()
	{

		for(int i = 0 ; i < buckets.length ; i++)
		{
			System.out.print(" bucket [ "+i+" ] => ");
			List<Integer> listOfValues =  buckets[i];
			for(int j = 0 ; listOfValues != null && j < listOfValues.size() ; j++)
			{
				System.out.print(listOfValues.get(j) +" ->");
			}
			System.out.print("null");
			System.out.println();
		}
	}
}

public class SetApp
{
	public static void main(String args[])
	{
		Set set = new Set();
		set.add(10);
		
		set.add(14);

		set.add(15);

		set.add(10);

		set.add(12);

		set.add(20);

		set.print();

		System.out.println(" \n\n Before Remove  contains(10) !!!!" + set.contains(10));

		set.remove(10);

		System.out.println(" \n\n After Remove of 10 !!!!");
			set.print();


System.out.println(" \n\n After Remove  contains(10) !!!!" + set.contains(10));

	}
}






