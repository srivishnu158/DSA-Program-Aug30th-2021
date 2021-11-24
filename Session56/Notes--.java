  java.util.LinkedList is the implementation of Deque : 

  public abstract void addFirst(E);
  public abstract boolean offerFirst(E);  // Adds to front


  public abstract void addLast(E);
  public abstract boolean offerLast(E);
   public abstract boolean add(E);
  public abstract boolean offer(E); // Adds to rear


  public abstract E removeFirst();
  public abstract E pollFirst();
   public abstract E remove();
  public abstract E poll(); // removes front


  public abstract E removeLast();
  public abstract E pollLast(); // removes rear


  public abstract E getFirst();
  public abstract E peekFirst();
  public abstract E element();
  public abstract E peek(); // returns front

  public abstract E getLast();
  public abstract E peekLast();   // returns rear


  ******************

Stream of size : 3
    
    when size the is reached , older element has to be removed.

    Every time get the avarage of stream.util


  stream(3) :  

        1 =>  avg  = 1/1

        2 -> 1 => avg = 1+2/2 = 1.5

        3 -> 2 -> 1 => avg = 3+2+1/3 = 2

        4 -> 3 -> 2 => avg 4+3+2/3 = 3

        5 -> 4 -> 3 => avg 5+4+3/3 = 4

        6 -> 5 -> 4 => avg 6+5+4/3 = 5

  Make use of deque/queue, when the capacity is reached : 
                           removeFront & addToRear

















 