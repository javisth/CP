// create a node class for doubly linked list

class Node {
	int key, val;
	Node next, prev;

	Node(int k, int v){
		this.key = k;
		this.val = v;
	}
}

// create a double linked class to implement a doubly linked list

class DoubleList {
	public void addFirst(Node x);
	public void remove(Node x);
	public Node removeLast();
	public int size();
}

// class implementing the LRU cache using hash linked list

class LRUCache {
	// define instance variables

	// we need a map for fast search
	// map to store integer key and nodes made of key, value pairs
	private HashMap<Integer, Node> map;
	// a cache doubly linked list for ordered items and fast insertion and delete
	private DoubleList cache;
	// variable to keep track of capacity of cache
	int cap;

	// LRUCache constructor
	LRUCache(int capacity){
		this.cap = capacity;
		map = new HashMap<>();
		cache = new DoubeList();
	}

	// the accessor method to retrieve something from a map and linked list
	public int get(int key){
		// if the key is not in our cache, return it
		if(!map.containsKey(key))
			return -1;
		// otherwise just get the value of the key to be returned
		int val = map.get(key).val;
		// since we accessed the key, lets put it in front of the cache
		put(key, val);
		return val;
	}

	// the mutator method to put something in the cache
	public void put(int key, int val){
		// create the node that needs to be inserted
		Node x = new Node(key, val);
		// if the map contains our key, we delete it and insert it at the beginning of cache
		if(map.containsKey(key)){
			// remove the key from cache
			cache.remove(map.get(key));
			// add it to the front of the cache
			cache.addFirst(x);
			// also update its new value in the map
			map.put(key, x);
		}
		// if the cache doesnt contain key, just add it to the beginning of cache
		else{
			// before adding check if we exceed cache capacity
			if(cap == cache.size()){
				// if we do, we remove the least accessed or last node from our list and also map
				Node last = cache.removeLast();
				map.remove(last.key);
			}
			// otherwise we just add the new item to the beginning of cache
			cache.addFirst(x);
			map.put(key, x);
		}
	}
}