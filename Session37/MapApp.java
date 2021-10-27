import java.util.List;
import java.util.LinkedList;

class PairNode
{
	Integer key;
	String value;

	public PairNode(){
	}

	public PairNode(Integer key , String value)
	{
		this.key = key;
		this.value = value;
	}
}
/*
int arr[] = {1,2,3}

arr[0] = 1;

List<Pair> arr[] = {List<Pair> (list1) , List<Pair> (list2)}
arr[0] = list1
*/

class Map
{

	private int maxLength = 4;

	List<PairNode> buckets[] = new LinkedList[maxLength];


	/*
	Time Complexity : 
	Average Case : O(1)
	Worst Case : O(logn)
	*/
	public void put(Integer key, String value)
	{
		int index = getBucketIndex(key);
		PairNode p = isPairExists(key);
		if(p != null)
		{
			p.value = value;
		}else
		{
			if(buckets[index] == null)
			{
				buckets[index] = new LinkedList<PairNode>();
			}
			p = new PairNode(key,value);
			buckets[index].add(p);
		}

	}

	/*
	Time Complexity : 
	Average Case : O(1)
	Worst Case : O(logn)
	*/
	public String get(Integer key)
	{
		
		PairNode p = isPairExists(key);
		return p != null ? p.value : null;
	}

	/*
	Time Complexity : 
	Average Case : O(1)
	Worst Case : O(logn)
	*/
	public boolean contains(Integer key)
	{
		PairNode p = isPairExists(key);
		return p != null ? true : false;
	}

	/*
	Time Complexity : 
	Average Case : O(1)
	Worst Case : O(logn)
	*/
	public void remove(Integer key)
	{
		int index = getBucketIndex(key);
		List<PairNode> pairNodes = buckets[index];

		if(pairNodes == null)
			{
				return ;
			}

		for(int i = 0 ; i < pairNodes.size() ; i++)
		{
			PairNode pair = pairNodes.get(i);
			if(key.equals(pair.key))
			{
				pairNodes.remove(i);
				break;
			}
		}

	}

	public int getBucketIndex(Integer key)
	{
		return key % maxLength;
	}

	public PairNode isPairExists(Integer key)
	{
		int index = getBucketIndex(key);

		List<PairNode> pairs = buckets[index];
		if(pairs == null)
		{
			return null;
		}

		for(int i = 0 ; i < pairs.size() ; i++)
		{
			PairNode p = pairs.get(i);
			if(key.equals(p.key)) // 
			{
				return p;
			}
		}

		return null;
	}


	public void print()
	{
		for(int i = 0 ; i < buckets.length ; i++)
		{
			System.out.print(" Bucket [ "+i+" ] => ");

			List<PairNode> pairNodes = buckets[i];

			for(int  j = 0 ; pairNodes != null && 
				j < pairNodes.size() ; j++)
			{
				PairNode pair = pairNodes.get(j);
				System.out.print("[ "+pair.key+" , "+pair.value+"] -> ");
			}
			System.out.print("null");
			System.out.println();
		}
	}
 }


 public class MapApp
 {
 	public static void main(String args[])
 	{
 		Map m = new Map();

 		m.put(12,"Srinu");
 		
 		m.put(14,"Kiran");

 		m.put(16,"Aakash");

 		m.put(12,"Srinu Nampalli");

 		m.put(15,"Ajay");


	System.out.println(" Before Remove !!! Key => 12 contains "+m.contains(12));

 		m.print();

 		m.remove(12);

	System.out.println(" \n\n After Remove !!! Key => 12 contains "+m.contains(12));
 		m.print();

 	System.out.println(" Value of Key : 15 => "+m.get(15));

 	}
 }










