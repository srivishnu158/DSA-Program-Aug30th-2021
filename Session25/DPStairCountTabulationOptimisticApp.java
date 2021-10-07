
class Sample
{

	/*

		Time Complexity : O(n)
		SpaceComplexity : O(1)

	*/

	public int stairCount(int n)
	{
		
		int n0 = 1; // reach target 0 , {}
		int n1 = 1; // reach target 1, {1}
		int n2 = 2; // reach target 2 , {1,1} {2}
		

		for( int i = 3 ; i <= n ; i++)
		{
			int temp  = n2;
			n2 =  n0+n1+n2;
			n0 = n1;
			n1 = temp;
			
		}

		return n2;
	}

}


public class DPStairCountTabulationOptimisticApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		System.out.println(" StairCount(4) "+s.stairCount(4));
	}
}









