import java.util.List;
import java.util.ArrayList;

class Stack
{
	List<Integer> arrayList = new ArrayList<>();

	/*
		Time Complexity : O(1)
	*/
	public void push(int element) 
	{
		arrayList.add(element);
	}

	/*
		Time Complexity : O(1)
	*/
	public void pop()
	{
		if(isEmpty())
		{
			return;
			//throw new RuntimeException("Stack is Empty");
		}

		int lastIndex = arrayList.size() - 1;

		arrayList.remove(lastIndex);

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
	public int top()
	{
		if(isEmpty())
		{
			
				throw new RuntimeException("Stack is Empty !!!");
		}

		int lastIndex = arrayList.size() - 1;

		return arrayList.get(lastIndex);
	}

	public List<Integer> getStackData()
	{
		return arrayList;
	}
}

public class StackEx
{
	public static void main(String args[])
	{
			Stack s = new Stack();

			s.push(1);
			s.push(2);
			s.push(3);

			System.out.println("\n after push of 1,2,3"+s.getStackData());
			System.out.println("top() " +s.top());


			s.pop();

			System.out.println("\n after pop1()"+s.getStackData());
			System.out.println("top() " +s.top());

			s.pop();

			System.out.println("\n after pop2()"+s.getStackData());
			System.out.println("top() " +s.top());


			s.pop();

			System.out.println("\n after pop3()"+s.getStackData());
			// System.out.println("top() " +s.top()); returns Runtime Excetion as the stack is empty


	}
}











