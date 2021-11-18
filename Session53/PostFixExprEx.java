import java.util.Stack;



class Sample
{
	Stack<Integer> stack = new Stack<>(); 

	/*
		Time Complexity  : O(n) 
		Space Complexity : O(n)
	   Input: tokens = ["2","1","+","3","*"]

	*/
	public int evaluatePostFixExpression(String[] tokens)
	{
		String operators = "-+/*";
			for(int i = 0 ; i < tokens.length ; i++)
				{
					String value = tokens[i];
					if(! operators.contains(value))
					{
						 stack.push(Integer.valueOf(value));
					}else
					{
						int number2 = stack.pop();
						int number1 = stack.pop();
						int result = 0;
						switch(value)
							{
								 case "+":
								 		result = number1+number2;
								   break;

								  case "-":
								  		result = number1 - number2;
								   break;

								   case "*":
								   		result = number1*number2;

								   break;

								   case "/":
								   		result = number1/number2;

								   break;
							}
							stack.push(result);
					}
				}

			return stack.pop();
	}


}


public class PostFixExprEx
{
	public static void main(String args[])
	{
			Sample s = new Sample();

			String[] input1 = {"2","1","+","3","*"};

			String[] input2 = {"4","13","5","/","+"};


			String[] input3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

		System.out.println( " input1  Result => "
			+s.evaluatePostFixExpression(input1));
		System.out.println( " input2  Result => "
			+s.evaluatePostFixExpression(input2));
		System.out.println( " input3  Result => "
			+s.evaluatePostFixExpression(input3));
	}
}