
class Sample
{
	/*
	Time Complexity = O(n)
	Space Complexity = O(n)
	*/
	public int[] reverse(int[] arr)
	{
		int[] resultArr = new int[arr.length];
		int endIndex = arr.length-1;
		int startIndex = 0;
		while(endIndex >= 0)
		{
			resultArr[startIndex] = arr[endIndex];
			endIndex--;
			startIndex++;
		}
		return resultArr;
	}
}


public class OutPlaceAlgorithmApp
{
public static void main(String args[])
{
	int[] arr = {1,2,3,4,5};
	Sample s = new Sample();
	int[] resultArr = s.reverse(arr);
	int i = 0;
	while(i < resultArr.length)
	{
		System.out.println(resultArr[i]);
		i++;
	}
}
}






