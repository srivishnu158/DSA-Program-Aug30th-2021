import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;


class Sample
{
	public void behaviourOfHashSet()
	{
		Set<Integer> set = new HashSet<Integer>();
		set.add(1); 
		set.add(2);
		set.add(3);
		set.add(4);
		
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		System.out.println(" \n At size 8");
		for(Integer element:set)
		{
			System.out.println(element);
		}

		set.add(15);
		set.add(16);
		System.out.println(" \n At size 10 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		set.add(17);
		set.add(18);
		set.add(25);
		set.add(26);
		set.add(27);
		set.add(28);
		System.out.println(" \n At size 16 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		set.add(35);
		set.add(36);
		set.add(37);
		set.add(38);

		System.out.println(" \n At size 20 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		
	
	}


	public void behaviourOfLinkedHashSet()
	{
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		System.out.println(" \n At size 8");
		for(Integer element:set)
		{
			System.out.println(element);
		}

		set.add(15);
		set.add(16);
		System.out.println(" \n At size 10 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		set.add(17);
		set.add(18);
		set.add(25);
		set.add(26);
		set.add(27);
		set.add(28);
		System.out.println(" \n At size 16 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		set.add(35);
		set.add(36);
		set.add(37);
		set.add(38);

		System.out.println(" \n At size 20 ");
		for(Integer element:set)
		{
			System.out.println(element);
		}
		
	
	}
}

public class SetBehaviourApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		//s.behaviourOfHashSet();
		s.behaviourOfLinkedHashSet();
	}
}