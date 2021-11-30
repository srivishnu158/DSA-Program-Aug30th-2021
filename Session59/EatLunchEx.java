import java.util.Queue;
import java.util.LinkedList;


class EatLunch
{
	Queue<Integer> studentsQueue = new LinkedList<>();
	Queue<Integer> sandwichesQueue = new LinkedList<>();



//students [1,1,0,0], sandwiches = [0,1,0,1]
	//  Time Complexity : O(n)
	// Space Complexity : O(n)
	public int unEatenCount(int[] students, int[] sandwiches) 
	{
			int n = students.length;
			for(int i = 0 ; i < n ; i++)
			{
				studentsQueue.add(students[i]);  // [1(front) <- 1 <- 0 <- 0]
				sandwichesQueue.add(sandwiches[i]);//[0(front) <- 1 <- 0 <- 1]
			}

			int counter = 0;

			 while(!studentsQueue.isEmpty())
			 {
			 	 if(studentsQueue.peek() == sandwichesQueue.peek())
			 	 {
			 	 	studentsQueue.remove();
			 	 	sandwichesQueue.remove();
			 	 	counter  = 0; 
			 	 }
			 	 else 
			 	 {
			 	 	int s = studentsQueue.remove();
			 	 	studentsQueue.add(s);
			 	 	counter++;
			 	 }
			 	 

			 	 if(counter == sandwichesQueue.size())
			 	 {
			 	 	break;
			 	 }
			 }

			 return studentsQueue.size();

	}
}


public class EatLunchEx
{
	public static void main(String args[])
	{
		EatLunch lunch = new EatLunch();
		int[] students  = new int[]{1,1,0,0};
		int[] sandwiches = new int[]{0,1,0,1};
		System.out.println( " s[1100], sand[0101] => " +lunch.unEatenCount(students, sandwiches));
		
		 students  = new int[]{1,1,1,0,0,1};
		sandwiches = new int[]{1,0,0,0,1,1};
		System.out.println( " s[111001], sand[100011]=> " +lunch.unEatenCount(students, sandwiches));
	

	}
}





