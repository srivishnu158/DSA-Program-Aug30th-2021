import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;

class Sample
{
public int abstractSolution1WithSet(String s)
	{
		Set<Character> set = new LinkedHashSet<>();

		int i = 0;
		int max = 0;

		while( i < s.length())
		{
				if(!set.add(s.charAt(i)))
				{
					max = Math.max(max,set.size());
					set.clear();
				}
				set.add(s.charAt(i));
				i++;
		} 
		return max;
	}

public int abstractSolution2WithTwoPointers(String s)
	{
			int max = 0;
			int left = 0;
			int right = 0;

			while(right < s.length())
			{
					int slidingWindowLeft  = left;
					while( slidingWindowLeft < right )
					{
						if(s.charAt(slidingWindowLeft) 
							== s.charAt(right))
						{

							max = Math.max(max, right-left);
							left++;
							break;
						}
						slidingWindowLeft++;
					}

				right++;
			}

			return max;
	}

	/*
		TimeComplexity :  
			right ---- 1 --- n
				left in worst case everchar >= twise
				O(2n) = O(n)

		SpaceComplexity: O(1) / O(k) / Math.min(O(n,k))

	*/
public int solution1(String s)
	{
		int max = 0;
		int left = 0; 
		int right = 0;
		int[] arr = new int[128]; 
		while(right < s.length())
		{
			char rch = s.charAt(right);
			arr[rch]++;
				while(arr[rch] > 1)
				{
					char lch = s.charAt(left);
					arr[lch]--;
					left++;
				}
			max = Math.max(max, right-left+1);
			right++;

		}
		return max;

	}

/*
		Time Complexity : O(n)
		Space Complexity: O(Math.min(stringSize, mapSize)) 
		String size = 128
		unique char = 6
*/
	public int solution2(String s)
	{
		int max = 0;
		int left = 0; 
		int right = 0;
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		while(right < s.length())
		{
			char rch = s.charAt(right);
			
			if(map.containsKey(rch))
				{
					left = Math.max(left,map.get(rch)); 
				}

			max = Math.max(max, right-left+1);

			map.putIfAbsent(rch,0);
			map.put(rch,right+1);
			right++;

		}
		return max;

	}
}


public class LongestSubStringEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		String value = "pa!nwakprs12!";
		//int count1 = s.abstractSolution1WithSet(value);
		//int count2 = s.abstractSolution2WithTwoPointers(value);

		int count = s.solution2(value);
		System.out.println("solution2 = "+count);

	}
}













