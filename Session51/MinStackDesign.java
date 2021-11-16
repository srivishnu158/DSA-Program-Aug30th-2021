import java.util.List;
import java.util.ArrayList;

class Data
{
	int element;
	int minValue;

	public Data(int element, int minValue)
	{
		this.element = element;
		this.minValue = minValue;
	}

	public String toString()
	{
		return "["+element +" : " + minValue+ "] ->";
	}
}


class Stack
{
	List<Data> arrayList = new ArrayList<>();

	/*
		Time Complexity : O(1)
	*/
	public void push(int element) 
	{
		Data data = null;
		if(isEmpty())
		{
			data = new Data(element,element);
			arrayList.add(data);
			return;
		}

		Data top = peek();

		if(element < top.minValue)
		{
			data = new Data(element, element);
		}else
		{
			data = new Data(element, top.minValue);
		}

		arrayList.add(data);
	}

	/*
		Time Complexity : O(1)
	*/
	public Data pop()
	{
	
		if(isEmpty())
		{
				throw new RuntimeException("Stack is Empty ");
		}

		int lastIndex = arrayList.size() - 1;

		Data data = arrayList.remove(lastIndex);

		return data;
	}

	/*
		Time Complexity : O(1)
	*/
	public boolean isEmpty()
	{
		return arrayList.size() == 0;
	}

	/*
		Time Complexity : O(1)
	*/
	public Data peek()
	{
		if(isEmpty())
		{
				throw new RuntimeException("Stack is Empty ");
		}

		int lastIndex = arrayList.size() - 1;

		return arrayList.get(lastIndex);
	}

	/*
		Time Complexity : O(1)
	*/

	public int getMin()
	{
		return peek().minValue;
	}

	public List<Data> getStackData()
	{
		return arrayList;
	}
}

public class MinStackDesign
{
	public static void main(String args[])
	{
			Stack s = new Stack();

			s.push(10);
			s.push(20);
			s.push(5);
			s.push(3);

				// 10:10 -> 20:10 -> 5:5 -> 3:3
			System.out.println("\n After add Stack :: "+s.getStackData());
			System.out.println("top => " +s.peek());
			System.out.println("min => " +s.getMin());


			s.pop();

			// 10:10 -> 20:10 -> 5:5
			System.out.println("\n after pop1()"+s.getStackData());
			System.out.println("top => " +s.peek());
			System.out.println("min => " +s.getMin());

			s.pop();

			System.out.println("\n after pop2()"+s.getStackData());
			System.out.println("top => " +s.peek());
			System.out.println("min => " +s.getMin());


			s.pop();

			System.out.println("\n after pop3()"+s.getStackData());
			System.out.println("top => " +s.peek());
			System.out.println("min => " +s.getMin());


	}
}











