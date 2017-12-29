package dictionaries;

public class Item<K, E> { 
	
	//Purpose: The key 
	private K key;
	//Purpose: the element
	private E elem;
	
	//Purpose: the Item constructor
	public Item(K k, E e) { 
		key = k;
		elem = e;
	}
	
	//Purpose: To return the key of this Item. 
	public K getKey() {
		return(key);
	}
	
	//Purpose: To return the element of this Item.
	public E getElem() {
		return(elem);
	}
}