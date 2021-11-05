import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
	Initialise the dictionary Map with the data.
	There is no abbrevation check.
	so that one abbrevation can have multiple values. 
	take Map<String, List<String>> 
	key is the abbrevation & value is List<String> [words]
*/

class Sample
{
	Map<String,List<String>> map = new HashMap<>(); 
	
	public Sample(String[] arr)
	{
		for(int i = 0 ; i < arr.length; i++)
		{
			String currentS= arr[i];
			String abr = currentS;
			
			if(arr[i].length() > 2)
			{
				int size = currentS.length();
				abr = ""+currentS.charAt(0)+(size-2)+currentS.charAt(size-1);
			}
		  map.putIfAbsent(abr,new ArrayList<>());
		  map.get(abr).add(currentS);
		  /* equals to =>
		  		List<String> list = map.get(abr);
		  		if( list == null)
		  		{
					 list = new ArrayList<>();
		  		}
		  		list.add(currentS);
		  		map.put(abr,list);
		  */
		}

		System.out.println(map);
	}
		/*
			Time Complexity  : O(1)
			Space Complexity : O(1)
		*/

	public boolean isUnique(String word)
	{

			String abr = word;
			
			if(word.length() > 2)
			{
				int size = word.length();
				abr = ""+word.charAt(0)+(size-2)+word.charAt(size-1);
			}

		 List<String> valueList = map.get(abr);

		 return valueList == null ||  
		 (valueList.size() == 1 && valueList.contains(word))  ;
	}
}

public class DesignWordAbbreviation
{
	public static void main(String args[])
	{

		String[]  arr = {"deer", "door", "cake", "card"};
				Sample s = new Sample(arr);

		/*
		map :
			deer => d2r
			door => d2r
			cake => c2e
			card => c2d

		{c2d=[card], d2r=[deer, door], c2e=[cake]}

		*/

		System.out.println(" [ dear ] => "+s.isUnique("dear")); 

		System.out.println(" [ cart ] => "+s.isUnique("cart"));

		System.out.println(" [ cane ] => "+s.isUnique("cane"));

		System.out.println(" [ make ] => "+s.isUnique("make"));

		System.out.println(" [ cake ] => "+s.isUnique("cake")); 

		System.out.println(" [ deer ] => "+s.isUnique("deer"));  


	}
}










