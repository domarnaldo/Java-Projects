package dictionaries;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Hashing<K,E> implements IDictionary<K, E> {
	
	//Purpose: Deleted cell item
	protected Item<K, E> AVAILABLE = new Item<K, E>(null, null); 
	//Purpose: Number of elements in the hash table.
	protected int n;
	//Purpose: Size of the Array.
	protected int N; 
	//Purpose: An ArrayList of items (a key and an element)
	protected ArrayList<Item<K, E>> A;
	//Purpose: Provides hashIndex and Equals.
	protected HashComparator<K> h;
	//Purpose: The collision counter.
	protected int collisions = 0;
	
	//Purpose: To create a new Hashing constructor from int s, and HashComparator hc of type K.
	public Hashing(int s, HashComparator<K> hc) { 
		n = 0; 
		h = hc; 
		N = s; 
		int i = -1;
		A = new ArrayList<Item<K, E>>(s);
		//INV: i <= s-1 && the elements in A[0...i] have null  
		while (i < s-1) { 
			//i < s-1 && the elements in A[0...i] have null 
			i = i + 1;
			// i+1 < s-1 && the elements in A[0...i] have null 
			A.add(i, null);
			//i <= s-1 && the elements in A[0...i] have null 
		}
		//i <= s-1 && the elements in A[0...i] have null 
		//!(i < s-1) ==> i = s-1
		//==>  the elements in A[0...s-1] have null 
		//Termination Argument: Every loop iteration, 1 is added to i. Eventually, i will become >= to (s-1).
	}
	
	//auxiliary methods
	protected boolean available(int i) { 
		return(A.get(i) == AVAILABLE); 
	}
	
	protected boolean empty(int i) { 
		return(A.get(i) == null);
	}
	
	protected K key(int i) {
		return(A.get(i).getKey());
	}
	
	private E elem(int i) {
		return(A.get(i).getElem());
	}
	
	// Dictionary methods
	public Integer size() {
		return(n);
	}
		
	public Boolean isEmpty() {
		return(n == 0);
	}
		
	public Iterator<E> elements() { 
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<E> elems = new ArrayList<E>();
		Item<K, E> k;	
		
		// INV: htlooper.hasNext() ==> not all elements of A are added &&
		// Elements of A added are A[0..i], i == looper pos - 1
		// !looper.hasNext() ==> all elements of A are added &&
		// Elements of A added are A[0..i-1], i == A.size()
		while (htlooper.hasNext()) { 
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)) { 
				elems.add(k.getElem()); 
			}
		}
		//Termination Argument: The loop will only run as long as htlooper has a next. 
		//						Since the htlooper is of finite size, eventually htlooper will have no next
		//						after looping through each element, thus terminating the loop.
		
		return(elems.iterator());
	}
		
	public Iterator<K> keys() {
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<K> keys = new ArrayList<K>();
		Item<K, E> k;
		// INV: htlooper.hasNext() ==> not all keys from A are added &&
		// Keys from A added are A[0..i], i == looper pos - 1
		// !looper.hasNext() ==> all keys from A are added &&
		// Keys from A added are A[0..i-1], i == A.size()
		while (htlooper.hasNext()) { 
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)) { 
				keys.add(k.getKey()); 
			}
		}
		//Termination Argument: The loop will only run as long as htlooper has a next. 
		//						Since the htlooper is of finite size, eventually htlooper will have no next
		//						after looping through each element, thus terminating the loop.
		
		return(keys.iterator());
	}
		
	public E findElement(K k) {
		int i = find(k);
		if (i < 0) { 
			return (null); 
		}
		else { 
			return (elem(i)); 
		}
	}
		
	public void delete(K k) {
		int i = find(k);
		if (i > -1) {
			A.set(i, AVAILABLE);
			n = n - 1;
		}
	}
	
	//Abstract functions
	public abstract int find (K k);
		
	public abstract void insert(K k, E e);
	
	//Purpose: to return the number of collisions 
	public int getCollisions() {
		return collisions;
	}
	
	
}
