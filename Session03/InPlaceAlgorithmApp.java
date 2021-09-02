
class Sample
{
	/*
	Time Complexity = O(n) 
	Space Complexity = O(1)
	*/
	public void reverse(int[] arr)
	{
		int startIndex = 0;
		int endIndex = arr.length - 1;
		while(startIndex < endIndex)
		{
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
}


public class InPlaceAlgorithmApp
{
public static void main(String args[])
{
	int[] arr = {1,2,3,4,5};
	Sample s = new Sample();
	
	s.reverse(arr);
	int i = 0;
	while(i < arr.length)
	{
		System.out.println(arr[i]);
		i++;
	}
}
}






