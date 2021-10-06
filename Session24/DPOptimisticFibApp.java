class Sample
{

	/*
		Time Complexity = O(n)
		Space Complexity = O(1)
	*/
	public int tabulation(int n)
	{

		int n1 = 0;  
		int n2 = 1;
		int result = n2; 

		for(int i = 2 ; i <= n ; i++) 
		{
			  result = n1+n2;
			  int temp = n2;
			  n2 = result;
			  n1 = temp;

		}

		return result;
	}
}

public class DPOptimisticFibApp // 1,1,2,3,5,8,13,21
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" Memoization 8 fib = "+s.tabulation(8));
	}
}