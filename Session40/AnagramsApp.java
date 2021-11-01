import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;

class Sample
{
		/*
			Time Complexity :  O(nklogk)
			Space Complexity: O(n)
		*/
	public List<List<String>> anagrams(String[] arr)
	{
		Map<String, List<String>> map = new LinkedHashMap<>();

		for(int i = 0 ; i < arr.length ; i++)
		{
			String word = arr[i]; // "eat"
			char[] chArr = word.toCharArray(); // { 'e' , 'a' , 't'}
			Arrays.sort(chArr); // {'a','e',t}
			String key = String.valueOf(chArr); //aet

			map.putIfAbsent(key, new ArrayList<>());
			
			/* putIfAbsent exactly equals to below logic

			if(map.get(key) == null)
			{
				map.put(key, new ArrayList<>());
			}
			*/
			map.get(key).add(word);

		}

		return new ArrayList<>(map.values());
	}


	/*
		Time Complexity  : O(nk)
		Space Complexity : O(n)
	*/
	public List<List<String>> anagrams2(String[] arr)
	{
				Map<String, List<String>> map = new LinkedHashMap<>();

		Character[] chArr = new Character[26];

		for(int i = 0 ; i < arr.length ; i++)
		{
			
				Arrays.fill(chArr,null);
				String value = arr[i];

				for(int j = 0 ; j < value.length() ; j++)
				{
					int index = value.charAt(j) - 'a';
					chArr[index] = value.charAt(j);
				}

				String key = "";

				for(int k = 0 ; k < 26 ; k++)
				{
						if(chArr[k] != null)
						{
							key = key+ chArr[k];
						}
				}

				map.putIfAbsent(key, new ArrayList<>());
				map.get(key).add(value);

		}

		return new ArrayList<>(map.values());
	}
}

public class AnagramsApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		// String[] arr = {"eat","tea","tan","ate","nat","bat"};

		String[] arr = {"abc","bca","cab","bac","dad","add","dda","hi","a","b","c"};

		List<List<String>> results  = s.anagrams2(arr);
		System.out.println(results);
	}
}







