class Sample
{

	public void subSets(String input, String output)
	{
			if(input.isEmpty())
			{
				System.out.println(output);
				return;
			}

			

			//Exclude
			subSets(input.substring(1),output);

			//Include
			subSets(input.substring(1),output+input.charAt(0));

			
	}
}

public class SubSetsApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		s.subSets("abc","");
	}
}







