import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


class SetLoadFactor
{
	int maxLength = 5;
	float loadFactor = 0.75f;
	int countOfKeys = 0;
	List<Integer> buckets[] = new LinkedList[maxLength];


	public void add(int value)
	{
			int currentLoad = Math.round(maxLength * loadFactor); // 5 * 0.75 = 3.75
			if(countOfKeys >= currentLoad)
			{
				System.out.println( ".... Rehashing at load "+currentLoad);
				rehashing();
			}

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

			countOfKeys++;

	}

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

		countOfKeys--;
	}

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

	private void rehashing()
	{
		List<Integer> oldBuckets[] = buckets;
		maxLength = maxLength*2;
		buckets = new LinkedList[maxLength];
		countOfKeys = 0;

		for(int i = 0 ; i < oldBuckets.length ; i++)
		{
			List<Integer> listOfValues =  oldBuckets[i];
			for(int j = 0 ; listOfValues != null && j < listOfValues.size() 
				; j++)
			{
				add(listOfValues.get(j));
				
			}
			
		}

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

public class SetLoadFactorApp
{
	public static void main(String args[])
	{
		SetLoadFactor set = new SetLoadFactor();
		set.add(6);
		
		set.add(7);

		set.add(8);

		set.print();

		set.add(9); // 

		set.add(16);

		set.add(17);

		set.add(11);

		set.print();

		set.add(21); //

		set.add(22);

		set.print();
	}
}






