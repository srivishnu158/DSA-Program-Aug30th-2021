import java.util.Stack;

class Sample
{
	public int[] nextHotTemparatures(int[] temparatures)
	{
		Stack<Integer> stack = new Stack<>();
		int currentDayIndex = 0;
		int n = temparatures.length;
		int[] k = new int[n];

		if( n == 1)
		{
			return k;
		}

		while(currentDayIndex < n)
		{
			int currentDayTemp = temparatures[currentDayIndex];

					while( !stack.isEmpty() && 
						currentDayTemp > temparatures[stack.peek()])
					{
						int prevDayIndex = stack.pop();
						k[prevDayIndex] = currentDayIndex - prevDayIndex;
					}
			stack.push(currentDayIndex);
			currentDayIndex++;
		}
		return k;
	}
}

public class MonotonicStackExOnDailyTemparatures
{
	public static void main(String args[])
	{
		Sample  s = new Sample();
		int[] temparatures = {29,20,19,21,30,29,30};

		int[] output = s.nextHotTemparatures(temparatures);

		for(int i = 0; i < output.length; i++)
		{
			System.out.print(output[i]+ " ,");
		}

	}
}






