import java.util.Set;
import java.util.LinkedHashSet;

public class RandomisationEx
{
	public static void main(String args[])
	{
		int a = 1; 
		int c = 997; 
		int modular = 10007; 
		/*
		Closest PrimeNumbers to the SampleSize 10000 are  9973, 10007
		
		case1 : 
			If we take modular as 9973, we would be missing 27 Sample Values.

		case2 : 
		If we take 10007 
		in worst case we would be getting  7 values out of SampleSize,
		we can be handle programatically. Lets take 10007 as modular.
		*/

		int xseed = 9;
		Set<Integer> set  = new LinkedHashSet<>();
		int samplesize = 10000;


		int count  = 1;

		while(count <= samplesize)
		{
			int current = (a * xseed + c)%modular;
		// System.out.print(current + "-> "  ); Uncomment if you would like to check periodic for lower inputs

			if(current <= (samplesize+7)) // +7 as we take 10007 as modular
			{
					set.add(current);
			}
			xseed = current;
			
			count++;
		}

		System.out.println(" \n Elements"+set);
		System.out.println(" \n *** Total RandomElements = "+set.size());

	}

} 
