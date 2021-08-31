public class ArrayEx
{

	public static void main(String args[])
	{
		int[] arr = {10,20,30,40};  

		int index = 0;
		boolean flag = false;

		while(index < arr.length )
		{
			if(arr[index] == 20)
			{
				flag = true;
				break;
			}
			index++;
		}

		if(flag == true)
		{
System.out.println("Element is Found");
		}else

		{
System.out.println("Element is Not Found");

		}

	}
}