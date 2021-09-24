class Sample
{

	/*
		Time Complexity = O(2^n)
		Space Complexity = O(n)
	*/
	public boolean recursiveApparoch(int[] arr, 
		int currentIndex, int targetSum)
	{

			int n = arr.length;


			if(targetSum == 0)
			{
				return true;
			}

			if(currentIndex >= n)
			{
				return false;
			}


			if(arr[currentIndex] <= targetSum)
			{
					//Including Element
				boolean  includeFlag = recursiveApparoch(arr,currentIndex+1, 
					targetSum-arr[currentIndex]);

				//without Including Element
				boolean excludeFlag = recursiveApparoch(arr,currentIndex+1,targetSum);

				return includeFlag || excludeFlag;
			}else // arr[currentIndex] > targetSum
			{
				return recursiveApparoch(arr, currentIndex+1 , targetSum);
			}

	}
}



public class TargetSubSetSumApp
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] arr = {1,3,5};
		int currentIndex = 0;
		int  targetSum= 7;
	boolean result =	s.recursiveApparoch(arr,currentIndex,targetSum);
	System.out.println("Is Element Found "+targetSum+"? " +result); 
		

	}
}











