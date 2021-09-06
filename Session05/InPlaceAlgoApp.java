// int[] arr = { 10,-5,12,-9,13,14,-1} => {-5,-9,-1,.....}


class Sample
{
	/*
		Time Complexity => O(n)
		Space Complexity => O(1) 
	*/
	public void useInplace(int[] arr)
	{
		int startIndex = 0;
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i] < 0 )
			{
				int temp = arr[startIndex];
				arr[startIndex] = arr[i];
				arr[i] = temp;
				startIndex++;
			}
		}
	}
}

public class InPlaceAlgoApp
{
public static void main(String args[])
		{
Sample s = new Sample();
int[] arr = { 10,-5,12,-9,13,14,-1};
s.useInplace(arr);

for(int  i = 0 ; i < arr.length ;i++)
{
	System.out.print(arr[i]+ " ");
}

		}



}
