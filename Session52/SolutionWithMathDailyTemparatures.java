
class Sample
{
		/*
			Time Complexity : 
			O(2n) => O(n) backTracking + O(n) forward = O(n)
			
			Space Complexity: O(n) => outputArray

		*/
	public int[] nextHotTemparatures(int[] temparatures)
	{
		
		int n = temparatures.length;
		int[] k = new int[n];

		if( n == 1)
		{
			return k;
		}
		int currentDayIndex = n-1;
		int hotestTemp = 0;

		while(currentDayIndex >= 0)
		{
			int currentDayTemp = temparatures[currentDayIndex];
			if( currentDayTemp >= hotestTemp)
			{
				hotestTemp  = currentDayTemp;
				currentDayIndex--;
				continue;
			}

			int days = 1;
			while( temparatures[currentDayIndex + days] <= currentDayTemp  )
			{
				days = days + k[currentDayIndex + days];
			}

			k[currentDayIndex] = days;
			currentDayIndex--;
		}
		return k;
	}
}

public class SolutionWithMathDailyTemparatures
{
	public static void main(String args[])
	{
		Sample  s = new Sample();
		int[] temparatures = {29,20,19,21,30,29,30};

		int[] output = s.nextHotTemparatures(temparatures);

		for(int i = 0; i < output.length; i++)
		{
			System.out.print(output[i]+ " ,");
		}

	}
}






