class Sample

{
		/*
		Time Complexity : O(2^n)
		Space Complexity : O(n) //
	*/
	public int fib(int n)
	{
		if( n == 0)
		{
			return 0;
		}

		if(n == 1)
		{
			return 1;
		}

		return fib(n-1) + fib(n-2);
	}
}

public class FibApp // 1,1,2,3,5,8,13,21
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" 8 fib = "+s.fib(8));
	}
}