
class  Sample
{
	/*
		Time Complexity => O(nlogn)
		Space Complexity => O(n)
	*/

	public void mergeSort(int[] arr)
	{
		divide(arr);
	}

	private void divide(int[] arr)
	{
		if(arr.length == 1)
		{
			return;
		}

		int start  = 0;
		int end  = arr.length;
		int mid  = arr.length/2;
		int[] leftArr = copyOfRange(start,mid,arr);
		int[] rightArr = copyOfRange(mid,end,arr);


		divide(leftArr);  
		divide(rightArr);

		conquer(leftArr,rightArr,arr);
	}

	public void conquer(int[] leftArr, int[] rightArr , int[] sourceArray)
	{
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;

		while(leftIndex < leftArr.length && rightIndex < rightArr.length)
		{
			if(leftArr[leftIndex] < rightArr[rightIndex])
			{
				sourceArray[index] = leftArr[leftIndex];
				index++;
				leftIndex++;
			}else
			{
				sourceArray[index] = rightArr[rightIndex];
				index++;
				rightIndex++;
			}
		}

		while(leftIndex < leftArr.length)
		{
			sourceArray[index] = leftArr[leftIndex];
			index++;
			leftIndex++;
		}

		while(rightIndex < rightArr.length)
		{
			sourceArray[index] = rightArr[rightIndex];
			index++;
			rightIndex++;
		}
		

	}

	private int[] copyOfRange(int start, int end, int[] sourceArray)
	{
		int size = end - start;

		int[] result = new int[size];
		int index  = 0;
		while(start < end)
		{
			result[index] = sourceArray[start];
			index++;
			start++;
		}
		return result;
	}

}


public class MergeSortApp
{
	public static void main(String args[])
	{
			Sample  s = new Sample();
			int[] arr = {5,1,7,3,2,8,6,4};
			s.mergeSort(arr);

			for(int i = 0 ; i < arr.length ; i++)
			{
				System.out.print(arr[i] + " ");
			}
	}
}











