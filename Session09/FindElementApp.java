
class Sample
{
	/*
		Time Complexity : O(n)
		Space Complexity : O(1) 
	*/
	public int searchSolution1(int[] arr, int element )
	{
		int index = 0;

		while( index < arr.length )
		{
			if(arr[index] == element)
			{

					return index;
			}
			index++;
		}

		return -1;
	}


/*
		Time Complexity : O(logn)
		Space Complexity : O(logn) 
		Its a Binary Search
	*/
	public int searchSolution2(int[] arr, int element, int start, int end )
	{
		if( start > end)
		{
			return -1;
		}

		int mid  = start + (end-start)/2; 

		if(arr[mid] == element )
		{
				return mid;
		}
		else if( arr[mid] > element)
		{
			end = mid - 1;	
			return searchSolution2(arr,element,start,end);
		}else // obviously arr[mid] < element
		{
			start = mid+1;
			return searchSolution2(arr,element,start,end);
		}
	}

	/*
		Time Complexity : O(logn)
		Space Complexity : O(1) 
		Its a Binary Search
	*/
	public int searchSolution3(int[] arr, int element)
	{
			int start = 0; 
			int end = arr.length-1;  

			while(start <= end)
			{
				int mid  = start + (end-start)/2; 
				if( arr[mid] == element)
						{
							return mid;
						}
				else if(arr[mid] > element)
				{
					end = mid - 1;
				}else // obviously arr[mid] < element
				{
					start = mid+1;
				}
			}

			return -1;

	}
}
public class FindElementApp
{
	public static void main(String args[])
	{
			Sample s = new Sample();
			int[] arr = {3,5,7,8,9,10,11,12};

			int iterationResult = s.searchSolution3(arr,7);
			System.out.println(" Index of element 7 [iterationResult]=> "+iterationResult);
	

			int recursionResult = s.searchSolution3(arr,7);
			System.out.println(" Index of element 7 [recursionResult]=> "+recursionResult);
	
			int iterationBinerySearchResult = s.searchSolution3(arr,7);
			System.out.println(" Index of element 7 [iterationBinerySearchResult]=> "+iterationBinerySearchResult);
	}
}







