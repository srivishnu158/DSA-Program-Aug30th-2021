import java.util.Stack;

class ValidateExpression
{
		public boolean validate(String expr)
		{

			int n = expr.length();
			if( n % 2 == 1)
					{
						return false;
					}
			Stack<Character> stack = new Stack<>();

			for(int i = 0 ; i < expr.length() ; i++)
			{
				char ch = expr.charAt(i);

				if(ch == '(' || ch == '{' ||  ch ==  '[')
				{
					stack.push(ch);
				}else // ")" || " } " || "]"
				{
						if(stack.isEmpty())
								return false;
					if(ch == ')'  )
					{
						char topCh = stack.pop();
						if( topCh != '(')
								return false;
					}else if(ch == '}'  )
					{
						char topCh = stack.pop();
						if( topCh != '{')
								return false;
					}else if(ch == ']'  )
					{
						char topCh = stack.pop();
						if( topCh != '[')
								return false;
					}
				}
			}

				return stack.isEmpty();
		}
}

public class ExpressionEx
{
	public static void main(String args[])
	{
		ValidateExpression expr = new ValidateExpression();

		System.out.println(" [()]  => "+expr.validate("[()]"));

	 	 System.out.println(" [({})] =>  "+expr.validate("[({})]"));

	 	 System.out.println(" [()]  => "+expr.validate("[()]"));

	 	 System.out.println(" )[({})] => "+expr.validate(")[({})]"));

	 	 System.out.println(" )))  => "+expr.validate(")))"));

	 	 System.out.println(" [({)}]  => "+expr.validate("[({)}]"));

	}
}











