import java.util.Map;
import java.util.HashMap;

class DLLNode
{
	int key;
	int value;
	DLLNode prev;
	DLLNode next;

	public DLLNode()
	{

	}

	public DLLNode(int key, int value)
	{
		this.key = key;
		this.value = value;
		prev = null;
		next  = null;
	}


}

class LRUCache
{
	 Map<Integer,DLLNode> map = new HashMap<>();
	 DLLNode dummyHead = null;
	 DLLNode dummyTail = null;
	 int size = 0;
	 int capacity = 0;

	 public LRUCache(int capacity)
	 {
	 	this.capacity = capacity;
	 	dummyHead = new DLLNode();
	 	dummyTail = new DLLNode();

	 	dummyHead.next = dummyTail;
	 	dummyTail.prev = dummyHead;
	 }

	 // This logic makes new Pair is going MRU Element
	 public void addToHead(DLLNode currentNode)
	 {
	 	DLLNode headNext = dummyHead.next;
	 	dummyHead.next = currentNode;

	 	headNext.prev = currentNode;

	 	currentNode.next = headNext;
	 	currentNode.prev = dummyHead;

	 	map.put(currentNode.key, currentNode);
	 	size++;
	 }

	 public void removeNode(DLLNode currentNode)
	 {
	 	DLLNode prev = currentNode.prev;
	    DLLNode next = currentNode.next;

	    prev.next = next;
	    next.prev = prev;

	    map.remove(currentNode.key);
	    size--;

	 }

	 // dummyTail.prev always maps to LRU Element
	 public void removeTail()
	 {
	 	DLLNode tailPrev = dummyTail.prev;
	 	removeNode(tailPrev);
	 }


	 public void add(int key , int value)
	 {
	 		DLLNode currentNode = map.get(key);

	 		if(currentNode == null)
	 		{
	 			currentNode = new DLLNode(key,value);
	 			addToHead(currentNode);
	 			
	 			if(size > capacity)
	 			{
	 				removeTail();
	 			}

	 		}else
	 		{
	 			currentNode.value = value;
	 			removeNode(currentNode);
	 			addToHead(currentNode);
	 		}
	 }


	 public int get(int key)
	 {
		DLLNode currentNode = map.get(key);

		if( currentNode == null)
		{
			return -1;
		}

		removeNode(currentNode);
	 	addToHead(currentNode);

	 	return currentNode.value;
	 }

	 public Map<Integer,DLLNode> getCache()
	 {
	 	return map;
	 }
}


public class LRUCacheApp
{

	public static void main(String args[])
	{
		LRUCache cache = new LRUCache(2);

		cache.add(1,10);
		cache.add(2,20);
		Map<Integer,DLLNode> map = cache.getCache();
		System.out.println(" \nAfter Addint 1,2 keys Elements in Cache :: "+map);

		System.out.println(" get(1) => "+cache.get(1));


		cache.add(3,30);
		System.out.println(" \nAfter Adding key(3) Elements in Cache :: "+map);

		System.out.println(" get(2) => "+cache.get(2));
		System.out.println(" get(3) => "+cache.get(3));

		cache.add(4,40);
		System.out.println(" \nAfter Adding key(4) Elements in Cache :: "+map);

		System.out.println(" get(1) => "+cache.get(1));
		System.out.println(" get(4) => "+cache.get(4));

	   cache.add(3,35);
	   	System.out.println(" \nAfter updating key(3) Elements in Cache :: "+map);
	   	System.out.println(" get(3) => "+cache.get(3));


	}
}












