Design Queue using Stack Algorithm :

popStack : []

pushStack : 
		Time Complexity : O(1)

		enQueue(1)
		  	1

		 enQueue(2)
		  	 <-(top) 2 <- 1

		  enQueue(3)
		  	 <-(top)3 <- 2 <- 1




deQueue(): popStack : []
			Reverse of the Stack can performs Queue behaviour:
				 => Pop the elements from pushStack
				 => Stores the elements in popStack


		
					 	popStack: <- 1 <- 2 <- 3
					 	pushStack:[]

					 		popStack.pop() : 1 (true)
					 			popStack : <- 2 <- 3




push(4)
			pushStack : <- 4
			popStack : <- 2 <- 3

push(5)
			pushStack : <- 5 <- 4
			popStack : <- 2 <- 3

	pop():
popStack is not Empty then remove the top : popStack.poll() 2 (true)

	pushStack : <- 4
	popStack  : <- 3


	Average Case O(1)


********************************
  Design Stack using Queue: 

  public abstract boolean add(E);  => adds to rear
  public abstract boolean offer(E); => adds to rear

  public abstract E remove(); => removes the front
  public abstract E poll(); => removes the front

  public abstract E element(); => return front
  public abstract E peek(); => returns front


  =>
  	pushQueue: []
  	popQueue: []

  	push(1) : O(1)
  				pushQueue: [1]
  			    popQueue: []

  	push(2)
  				pushQueue: [2 -> 1]
  			    popQueue: []


  	push(3)
  				pushQueue: [3 -> 2 -> 1]
  			    popQueue: []



   pop()
   				pushQueue: [3 -> 2 -> 1]

   				if the pushQueue is not Empty :
   							pop the elements pushQueue, 
   							store into popQueue before the last element of pushQueue.

   						popQueue: [2 -> 1]
   						pushQueue: [3]

   					remove element from pushQueue 3[True]
   					popQueue: [2 -> 1]
   					pushQueue: []

   					swap popQueue as pushQueue 

   						pushQueue: [2 -> 1]
   						popQueue: []



push(4)
  			pushQueue:[4 -> 2 -> 1]
  			popQueue: []


push(5)
  			pushQueue:[5 -> 4 -> 2 -> 1]
  			popQueue: []


pop() :
			pushQueue:[5 -> 4 -> 2 -> 1]
  			popQueue: []

  			if the pushQueue is not Empty :
   						pop the elements from pushQueue, 
  						store into popQueue before the last element of pushQueue

   						popQueue: [4 -> 2 -> 1]
   						pushQueue: [5]

   					remove element from pushQueue 5 [true]
   					popQueue: [4 -> 2 -> 1]
   					pushQueue: []

   					swap popQueue as pushQueue 

   						pushQueue: [4 -> 2 -> 1]
   						popQueue: []



pop() :

						pushQueue: [4 -> 2 -> 1]
   						popQueue: []


