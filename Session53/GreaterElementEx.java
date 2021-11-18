import java.util.Stack;

class Sample
{
		/*
			 input :  2 -> 5 -> 3 -> 6 : Expected Output :  5 -> 6 -> 6 -> 0

			 output:  0 -> 0 -> 0 -> 0
			 stack: []

			Step1 :
			currentIndex = 0 : input[0] = element = 2
			As stack is Empty push currentIndex to stack 
				stack: [0]

			Step2 :
			input :  2 -> 5 -> 3 -> 6 : 
			currentIndex = 1 : input[1] = currentElement = 5
			As stack is not Empty stack: [0] => element[0] 
							= stackTopElement = 2

			
			while(!stack.isEmpty() && currentElement (5) > stackTopElement(2))
			{
					popTop index from stack: index : 0 
					:: stack[] becomes Empty

					output[popIndex] = currentElement : 
					output:  5 -> 0 -> 0 -> 0

			}
			push the currentIndex into Stack :
			stack=>[1]

			
			Step3 :
			input :  2 -> 5 -> 3 -> 6 : 
			currentIndex = 2 : input[2] = currentElement = 3
			output:  5 -> 0 -> 0 -> 0
			stack=>[1]

				while(!stack.isEmpty() &&
					 currentElement(3) > stackTopElement (5)) //condition Fails
					 {
						...
					 }
				push the currentIndex stack:

			stack => [1 -> 2]


			Step4 :
			input :  2 -> 5 -> 3 -> 6 : 
			currentIndex = 3 : input[3] = currentElement = 6
			output:  5 -> 0 -> 0 -> 0
			stack=>[1->2]

				while(!stack.isEmpty() &&
					 currentElement(6) > stackTopIndexElementValue (3)) 
					 {
					 	 step 1:  stack [1->2]
					 	pop the TopIndex from stack:
					 	int topIndex = stack.pop(); // index : 2
					 	
						output[topIndex] = currentElement; 
						output:  5 -> 0 -> 6 -> 0
						// now stack becomes stack -> [1]
						

					 }

						stack [1]
						output:  5 -> 0 -> 6 -> 0
						input :  2 -> 5 -> 3 -> 6 
						currentElement : 6
					 while(!stack.isEmpty() &&
					 currentElement(6) > stackTopIndexElementValue (5)) 
					 {

							pop The stackIndex : 1 : stack will be []

							output[1] = currentElement;
							output:  5 -> 6 -> 6 -> 0

					 }
				push the currentIndex stack:

					stack[3]


Step4 :
currentIndex 4 > n-1 break the loop
			

		TimeComplexity O(2n) = O(n) forward + O(n) backward = O(n)	
		Space Complexity : O(n) 

		*/
	public int[] nextGreater(int[] elements)
	{
		int n = elements.length;
		int[] output = new int[n];
		Stack<Integer> stack = new Stack<>();
		if(n == 1)
		{
			return output;
		}

		int currentIndex = 0;

		// input -> 5 -> 4 -> 3 -> 2 -> 1 -> 6
		// output : 6 -> 6 -> 6 -> 6 -> 6-> 0
	
		// output: [6 -> 6 -> 6 -> 6 -> 6 -> 0 ]
		// stack : [   -> interation index: 5  ]

		//	currentInde 6 > n-1


		while(currentIndex < n)
		{
			int currentElement = elements[currentIndex];

				while(!stack.isEmpty() && 
					currentElement > elements[stack.peek()] )
				{
					int prevIndex = stack.pop();
					output[prevIndex] = currentElement;
				}

				stack.push(currentIndex);
				currentIndex++;
		}
		return output;
	}
}

public class GreaterElementEx
{
	public static void main(String args[])
	{
		Sample s = new Sample();
		int[] input = {2,7,4,3,5,7,7}; // ExOuput : {7,0,5,5,7,0,0}
		int[] output = s.nextGreater(input);

		for(int i = 0 ; i < output.length ; i++)
		{
			System.out.print(output[i]+" , "); // 7 , 0 , 5 , 5 , 7 , 0 , 0 
		}


	}
}








