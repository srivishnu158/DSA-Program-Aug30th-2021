class Sample
{
	/*
	  Time Complexity O(n)
	  Space Complexity O(1)
	*/
	public int fact(int n)
	{
		int result = 1;

		while( n > 1)
		{
			result = result * n;
			n--;
		}

		return result;
	}
/*
fact(3)=>  result  = 1
		while( 3 > 1)
			{
				result = 1 * 3 = 3;
				n--; // n = 2
			}
		
while( 2 > 1)
			{
				result =  3 * 2 = 6;
				n--; // n = 1
			}

while( 1 > 1) // loop terminates 

returns result = 6, n = 1;


*/

}

public class InterativeApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int value = s.fact(3);
		System.out.println(" Fact is :: "+value);
	}
}








