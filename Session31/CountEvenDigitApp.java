// {12,123,456,1245,1055}

class Sample
{

	/*
		Time Complexity : O(n)
		Space Complexity : O(1)
	*/
	public int CountEvenDigits(int[] arr)
	{
		int count  = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			int length = String.valueOf(arr[i]).length();
			if(length%2 == 0)
			{
				count++;
			}

		}
		return count;
	}

	/*
		Time Complexity : O(n*d)
		Space Complexity : O(1)
		
	*/
	public int CountEvenDigitsWithSimpleMath(int[] arr)
	{
		int count  = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			int length  = 0;

			int n = arr[i];
				while( n > 0)
				{
					length++;
					n = n/10;
				}

			if(length%2 == 0)
			{
				count++;
			}

		}
		return count;
	}


	/*
		Time Complexity : O(n)
		Space Complexity : O(1)
		
	*/
	public int eventDigitsWithLogirithm(int[] arr)
	{
		/* 
		When digit is odd the logValue with base10 would be even Integer, 
		(Don't consider decimal)
		log10(100) to log10(999) = 2 to... 2.99999 
		*/

		/*
		When digit is even the logValue with base10 would be odd Integer,
		(Don't consider decimal)
		log10(1000) to log10(9999) = 3 to... 3.99999
		*/
		int count  = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			int logValue =	(int) Math.log10(arr[i]);
			int digit = logValue+1;
			if(digit % 2 == 0)
			{
				count++;
			}

		}
		return count;
	}


}

public class CountEvenDigitApp
{
	public static void main(String[] args) {

		Sample s = new Sample();
		int[] arr = {12,123,456,1245,1055};
		int count = s.eventDigitsWithLogirithm(arr);
		System.out.println(count);
		
	}
}



