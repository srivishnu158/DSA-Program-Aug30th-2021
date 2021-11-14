import java.util.Map;
import java.util.HashMap;

class DLLNode
{
     int key;
     int value;
     int counter;
     DLLNode prev;
     DLLNode next;
    
    public DLLNode()
    {
        
    }
    
    public DLLNode(int key, int value)
    {
        this.key = key;
        this.value = value;
        counter = 1;
        prev = null;
        next = null;
    }
    
}

class LRUCache
{
     DLLNode dummyHead;
     DLLNode dummyTail;
    
    public LRUCache()
    {
       dummyHead = new DLLNode(); 
       dummyTail = new DLLNode(); 

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public void add(DLLNode currentNode)
    {
        DLLNode next = dummyHead.next;
        
        currentNode.next = next;
        currentNode.prev = dummyHead;
        
        dummyHead.next = currentNode;
        next.prev = currentNode;
        
    }
    
    public void remove(DLLNode currentNode)
    {
        DLLNode next = currentNode.next;
        DLLNode prev = currentNode.prev;

        next.prev = prev;
        prev.next = next;
        
    }
    
    public DLLNode removeTail()
    {
        DLLNode tail = dummyTail.prev;
        remove(tail);
        return tail;
    }
}




class LFUCache {
    
    Map<Integer,DLLNode> elementsMap = new HashMap<>();
    Map<Integer,LRUCache> counterMap = new HashMap<>();
    int minFrequencyCounter = Integer.MAX_VALUE;
    int size = 0 ;
    int capacity = 0;
    
    

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
       DLLNode currentNode =  elementsMap.get(key);
        if( currentNode == null )
        {
            return -1;
        }
        
        // DeLink the currentNode From LRUCache
        LRUCache cache = counterMap.get(currentNode.counter);
        cache.remove(currentNode);
        
        /* When only currentNode exist with  LRUCache for the 
            currentNode.counter
         Then next minFrequencyCounter would be currentNode.counter+1
         */
        if(
            cache.dummyHead.next == cache.dummyTail 
           && currentNode.counter == minFrequencyCounter 
          )
        {
            minFrequencyCounter = currentNode.counter+1;
        }
        
        // Link the currentNode with incrementedCounter of LRUCache
        currentNode.counter = currentNode.counter+1;
        counterMap.putIfAbsent(currentNode.counter, new LRUCache());
        counterMap.get(currentNode.counter).add(currentNode);
        
        return currentNode.value;
        
    }
    
    public void add(int key, int value) {

        // base check when capacity is 0  No need to add
        if(capacity == 0)
        {
            return;
        }
          
       DLLNode currentNode =  elementsMap.get(key);
        if( currentNode == null )
        {
            /*
               By adding currentNode if it reaching out of capacity
               Then remove the LFU element.
               minFrequencyCounter help us to get  LRUCache  of LFU nodes simply
               remove the tail from LRUCache then that is going to be the old LFUNode.
            */
            if(size+1 > capacity)
            {
                LRUCache cache = counterMap.get(minFrequencyCounter);
                DLLNode tail = cache.removeTail();
                elementsMap.remove(tail.key);
                size--;
            }
            currentNode = new DLLNode(key,value);
           
               minFrequencyCounter = 1; 
               // As we are adding  minFrequencyCounter would be blindly 1
            
            counterMap.putIfAbsent(1,new LRUCache());
            counterMap.get(1).add(currentNode);
            elementsMap.put(key,currentNode);
            size++;
            
        }
        
    
        // As its the update Request DeLink the currentNode From LRUCache
        LRUCache cache = counterMap.get(currentNode.counter);
        cache.remove(currentNode);
        
         /* When only currentNode exist with  LRUCache for the 
            currentNode.counter
         Then next minFrequencyCounter would be currentNode.counter+1
         */
        if(
            cache.dummyHead.next == cache.dummyTail
           && currentNode.counter == minFrequencyCounter )
        {
            minFrequencyCounter = currentNode.counter+1;
        }
        
        /*
         Link the currentNode with incrementedCounter of LRUCache
        
         */

        currentNode.counter = currentNode.counter+1;
        currentNode.value = value;
        counterMap.putIfAbsent(currentNode.counter, new LRUCache());
        counterMap.get(currentNode.counter).add(currentNode);
        
    }
}

public class LFUCacheApp
{
    public static void main(String args[])
    {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.add(10,101);
        lfuCache.add(20,201);

        System.out.println(" get(20) => "+lfuCache.get(20));
        lfuCache.add(20,202);
        System.out.println(" get(10) => "+lfuCache.get(10));

        lfuCache.add(30,301);

        System.out.println(" get(30) => "+lfuCache.get(30));

       lfuCache.add(40,401);
       lfuCache.add(50,501);


       System.out.println(" \n Final Results ");
        System.out.println(" get(10) => "+lfuCache.get(10));
        
        System.out.println(" get(20) => "+lfuCache.get(20));

        System.out.println(" get(30) => "+lfuCache.get(30));

        System.out.println(" get(40) => "+lfuCache.get(40));

        System.out.println(" get(50) => "+lfuCache.get(50));



    }
}

