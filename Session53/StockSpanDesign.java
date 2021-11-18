import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class StockSpan
{
	Stack<Node> stack = new Stack<>(); 

	/*
		Time Complexity : O(n) 
	   Average Case : O(1)
	*/
	public int nextSpan(int currentPrice)
	{
			int span = 1;
			while(!stack.isEmpty() && currentPrice >= stack.peek().price)
			{
				Node prevSpan = stack.pop();
				span = span + prevSpan.spanCount;
			}

			Node node = new Node(currentPrice,span);
			stack.push(node);

			return span;
	}


}

class Node
{
	 int price;
	 int spanCount;

	 public Node(int price, int spanCount)
	 {
	 	this.price = price;
	 	this.spanCount = spanCount;
	 } 
}

public class StockSpanDesign
{
	public static void main(String args[])
	{
		StockSpan s = new StockSpan();

		List<Integer> inputList = List.of(100,80,60,70,60,75,85,75,75);

		List<Integer> outputList = new ArrayList<>();

		for(Integer price : inputList)
		{
			int span = s.nextSpan(price);
			outputList.add(span);
		}

		System.out.println(inputList);
		System.out.println(outputList);



	}
}