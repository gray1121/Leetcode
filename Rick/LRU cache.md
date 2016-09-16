From the question itself, we can see that the problem of O(n) operations arises when querying the linked list. Therefore, we need an alternative data structure. We need to be able to update the items' last access time from the HashMap without searching.

We can keep two separate data structures. A **HashMap with (Key,Pointer)** pairs and a **doubly linked list** which will work as the priority queue for deletion and store the Values. From the HashMap, we can point to an element in the doubly linked list and update its' retrieval time. Because we go directly from the HashMap to the item in the list, our time complexity remains at O(1)

For example, our doubly linked list can look like:

`least_recently_used  -> A <-> B <-> C <-> D <-> E <- most_recently_used`

We need to keep a pointer to the LRU and MRU items. The entries' values will be stored in the list and when we we query the HashMap, we will get a pointer to the list. On get(), we need to put the item at the right-most side of the list. On put(key,value), if the cache is full, we need to remove the item at the left-most side of the list from both the list and the HashMap.

The following is an example implementation in Java:
```Java
    public class LRUCache<K, V>{
    
    	// Define Node with pointers to the previous and next items and a key, value pair
    	class Node<T, U> {
    		Node<T, U> previous;
    		Node<T, U> next;
    		T key;
    		U value;
    		
    		public Node(Node<T, U> previous, Node<T, U> next, T key, U value){
    			this.previous = previous;
    			this.next = next;
    			this.key = key;
    			this.value = value;
    		}
    	}
    	
    	private HashMap<K, Node<K, V>> cache;
    	private Node<K, V> leastRecentlyUsed;
    	private Node<K, V> mostRecentlyUsed;
    	private int maxSize;
    	private int currentSize;
    	
    	public LRUCache(int maxSize){
    		this.maxSize = maxSize;
    		this.currentSize = 0;
    		leastRecentlyUsed = new Node<K, V>(null, null, null, null);
    		mostRecentlyUsed = leastRecentlyUsed;
    		cache = new HashMap<K, Node<K, V>>();
    	}
    	
    	public V get(K key){
    		Node<K, V> tempNode = cache.get(key);
    		if (tempNode == null){
    			return null;
    		}
    		// If MRU leave the list as it is
    		else if (tempNode.key == mostRecentlyUsed.key){
    			return mostRecentlyUsed.value;
    		}
    		
    		// Get the next and previous nodes
    		Node<K, V> nextNode = tempNode.next;
    		Node<K, V> previousNode = tempNode.previous;
    		
    		// If at the left-most, we update LRU 
    		if (tempNode.key == leastRecentlyUsed.key){
    			nextNode.previous = null;
    			leastRecentlyUsed = nextNode;
    		}
    		
    		// If we are in the middle, we need to update the items before and after our item
    		else if (tempNode.key != mostRecentlyUsed.key){
    			previousNode.next = nextNode;
    			previousNode.previous = nextNode;
    		}
    		
    		// Finally move our item to the MRU
    		tempNode.previous = mostRecentlyUsed;
    		mostRecentlyUsed.next = tempNode;
    		mostRecentlyUsed = tempNode;
    		mostRecentlyUsed.next = null;
    		
    		return tempNode.value;
    		
    	}
    	
    	public void put(K key, V value){
    		if (cache.containsKey(key)){
    			return;
    		}
    		
    		// Put the new node at the right-most end of the linked-list
    		Node<K, V> myNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
    		mostRecentlyUsed.next = myNode;
    		cache.put(key, myNode);
    		mostRecentlyUsed = myNode;
    		
    		// Delete the left-most entry and update the LRU pointer
    		if (currentSize == maxSize){
    			cache.remove(leastRecentlyUsed.key);
    			leastRecentlyUsed = leastRecentlyUsed.next;
    			leastRecentlyUsed.previous = null;
    		}
    		
    		// Update cache size, for the first added entry update the LRU pointer
    		else if (currentSize < maxSize){
    			if (currentSize == 0){
    				leastRecentlyUsed = myNode;
    			}
    			currentSize++;
    		}
    	}
    }
    ```