import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;

class Sample
{
		/*
			Time Complexity :  O(nk)
			Space Complexity: O(n)
		*/
	public List<List<String>> groupShift(String[] arr)
	{
		Map<String, List<String>> map = new LinkedHashMap<>();

		for(int i = 0 ; i < arr.length ; i++)
		{
			String value = arr[i]; 
			char sch = value.charAt(0);
			String key = "";
			for(int j = 0 ;  j < value.length() ; j++)
			{
				key = key + (value.charAt(j) - sch + 26) % 26 + "|"; 
			}
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(value);
		}
		return new ArrayList<>(map.values());
	}
}



public class GroupShiftedApp
{
	public static void main(String args[])
	{
		String[] arr = {"abc","bcd","acef","xyz","az","ba","a","z"};
		//String[] arr = {"za","yzb","yza","pqr","a","e","xyz","zab","am","abc"};
		Sample s = new Sample();

		List<List<String>> results  = s.groupShift(arr);
		System.out.println(results);
	}
}







