class ArrayList
{
     private int capacity = 5;
     private int[] array = new int[capacity];
     private int size = 0;
     private int currentIndex = 0;


     /* 
        Time Complexity :: O(1) 
        Space Complexity :: O(n)
     */

    public void add(int element)
    {


        if( size >= capacity/2)
        {
            capacity = 2 * capacity; // Just simplicity, I made size double, we can optimise it with math

            copy(array,size,capacity);
        }

        array[currentIndex] = element;
        currentIndex++;
        size++;
    }

    public void copy(int[] original, int oldSize , int newSize)
    {
        int[] copyArr = new int[newSize];
        for(int i = 0 ; i < oldSize; i++)
        {
            copyArr[i] = array[i];
        }

        array = copyArr;
        copyArr = null;
    }

    /*
        Time Complexity O(1)
        Space Complexity O(1)
    */
    public int get(int index)
    {
        if( index < 0  || index >= size)
        {
            return -1;
        }

        return array[index];
    }

    /*
        Time Complexity O(n)
        Space Complexity O(1)
    */
    public boolean search(int element)
    {
        for(int i = 0 ; i < size ; i++)
        {
            if(array[i] == element)
            {
                return true;
            }
        }

        return false;

    }

    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
    public boolean remove(int index)
    {

        if( index < 0  || index >= size)
        {
            return false;
        }

        for(int i = index ; i+1 < size ; i++)
        {
            array[i] = array[i+1];
        }
        currentIndex--;
        size--;
        return true;
    }

        /*
        Time Complexity = O(1)
        Space Complexity = O(1)
        */
    public int size()
    {

        return size;
    }


    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
    public boolean isEmpty()
    {
        return size != 0;
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
    public void print()
    {
        System.out.println();
        for(int i = 0 ; i < size ; i++)
        {
            System.out.print(array[i]+" ->  ");
        }
      System.out.println();

    }
}

public class ArrayListEx
{

    public static void main(String args[])
    {
        ArrayList list  = new ArrayList();

        System.out.println(" Before add isEmpty "+list.isEmpty());
         list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(" After add isEmpty "+list.isEmpty());
         list.print();
         list.add(4);
         list.add(5);
         list.print();
         list.add(6);
         list.add(7);
         list.add(8);
         list.add(9);
         list.add(10);
         list.add(11);
         list.add(12);
         list.add(13);

         list.print();

         list.remove(7); // index 7
         list.add(14);
         list.add(14);

         System.out.println(" After Removal of Element 8 => ");
         list.print();
         
    }

}









