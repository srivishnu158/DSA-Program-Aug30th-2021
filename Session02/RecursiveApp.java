class Sample
{
	/*
		Time Complexity = O(n)
		Space Complexity = O(n)
	*/
	public int fact(int n)
	{
		if( n <= 1)
		{

			return 1;
		}

		return n * fact(n-1);

	}

}

public class RecursiveApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int value = s.fact(3);
		System.out.println(" Fact is :: "+value);
	}
}








