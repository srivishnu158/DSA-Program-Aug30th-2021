
class Sample
{
	/*
		Time Complexity : O(n)
		Space Complexity : O(1) 
	*/
	public int firtOccurrenceSolution1(int[] arr, int element )
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
	public int firtOccurrenceSolution2(int[] arr, int element, 
		int start, int end, int result )
	{
		if( start > end)
		{
			return result;
		}

		int mid  = start + (end-start)/2; 

		if(arr[mid] == element )
		{
			result = mid;
			end = mid-1;
		   return firtOccurrenceSolution2(arr,element,start,end,result);
		}
		else if( arr[mid] > element)
		{
			end = mid - 1;	
			return firtOccurrenceSolution2(arr,element,start,end,result);
		}else // obviously arr[mid] < element
		{
			start = mid+1;
			return firtOccurrenceSolution2(arr,element,start,end,result);
		}
	}

	/*
		Time Complexity : O(logn)
		Space Complexity : O(1) 
		Its a Binary Search
	*/
	public int firtOccurrenceSolution3(int[] arr, int element)
	{
			int start = 0; 
			int end = arr.length-1; 
			int result = -1; 

			while(start <= end)
			{
				int mid  = start + (end-start)/2; 
				if( arr[mid] == element)
						{
							result = mid;
							end = mid-1;
						}
				else if(arr[mid] > element)
				{
					end = mid - 1;
				}else // obviously arr[mid] < element
				{
					start = mid+1;
				}
			}

			return result;

	}
}
public class FirstOccuranceElementApp
{
	public static void main(String args[])
	{
			Sample s = new Sample();
			int[] arr = {3,5,7,8,8,8,9,10,11,12};
			

			int iterationResult = s.firtOccurrenceSolution1(arr,8);
			System.out.println(" First Occurrence of element 8 [iterationResult] => "+iterationResult);

			int recursionResult = s.firtOccurrenceSolution2(arr,8,0,arr.length-1,-1);
			System.out.println(" First Occurrence of element 8 [recursionResult] => "+recursionResult);
	
			int iterationBinarySearchResult = s.firtOccurrenceSolution3(arr,8);
			System.out.println(" First Occurrence of element 8 [iterationBinarySearchResult] => "+iterationBinarySearchResult);


	}
}







