import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;



class Sample
{
		/*
		
			Time Complexity  : O(n)
			Space Complexity : O(n)
		*/
	public boolean isIsomorphic(String source , String target)
	{
			if(source.length() != target.length())
			{
				return false;
			}
		Map<Character,Character> sourceMap = new LinkedHashMap<>();
		Set<Character> targetSet = new HashSet<>();

		for(int i = 0 ; i < source.length(); i++)
		{
			
				Character key = source.charAt(i);
				Character value = target.charAt(i);
			Character earlierValue = sourceMap.get(key);
			if( earlierValue == null)
			{
					// Check  Target before adding new Soruce
				if(targetSet.contains(value))
				{
					return false;
				}
				sourceMap.put(key, value);
				targetSet.add(value);
			}else
			{
				// Check  EarlierTarget is current Target of the Soruce

				if(earlierValue != value)
				{
					return false;
				}
			}
		}

		return true;
	}
}

public class IsomorphicApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		String source = "egg";
		String target = "add";
		System.out.println(s.isIsomorphic(source,target));
	}
}
