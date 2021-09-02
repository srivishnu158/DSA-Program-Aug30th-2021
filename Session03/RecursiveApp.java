
class Sample
{
	/*
	Time Complexity = O(n) 
	Space Complexity = O(n)
	*/
	public void reverse(int[] arr, int start , int end)
	{
			if( start >= end)
			{

				return;
			}
			
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			reverse(arr,start+1, end-1);

		}
}


public class RecursiveApp
{
public static void main(String args[])
{
	int[] arr = {1,2,3,4,5};
	Sample s = new Sample();
	
	s.reverse(arr,0, arr.length-1);
	int i = 0;
	while(i < arr.length)
	{
		System.out.println(arr[i]);
		i++;
	}
}
}






