package radix;

public interface IBucket<X> { 
	
	// Purpose: To add the given element to this bucket
	// Effect:  The bucket has the given element as its last element added
	public void add(X elem);
	
	// Purpose: Place bucket elements into the given array starting at index i
	// Effect:  Clears the bucket
	public int toArray(X[] A, int i);
	
	//Purpose: To get the size of the ArrayList.
	public int getSize();
	
	//Purpose: To get an element of type X from the index in this ArrayList.
	public X getElem(int x);
	
}