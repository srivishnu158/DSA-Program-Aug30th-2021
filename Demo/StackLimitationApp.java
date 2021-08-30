
class Sample
{
	public void print(int n)
	{
		


		if( n == 10000)
		{
				Thread t = new Thread( () -> {
					print(n);
					
				});
				t.start();
				return;
		}

		print(n-1);
		
		System.out.println(n);

	}
}

public class StackLimitationApp
{

public static void main(String args[])
{
	Sample s = new Sample();

	s.print(20000);
}

}








