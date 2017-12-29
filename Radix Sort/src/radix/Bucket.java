package radix;

import java.util.*;

public class Bucket<X> implements IBucket<X> { 
	
	//Purpose: ArrayList of Buckets
	List<X> B; 
	
	//Purpose: The size of the ArrayList.
	public int size;
	
	//Purpose: Constructor of the Bucket
	public Bucket() { 
		B = new ArrayList<X>();
		size = 0; 
	}
	
	//Purpose: To get the size of the ArrayList.
	public int getSize() {
		return size;
	}
	
	//Purpose: To add an element X to the ArrayList.
	//Effect: Adds an element of type X to the ArrayList of type X and it increases the size by 1.
	public void add(X elem) { 
		B.add(elem);
		size = size + 1; 
	}
	
	//Purpose: To get an element of type X from the index in this ArrayList.
	public X getElem(int index) {
		return B.get(index);
	}
	
	// Purpose: To dump b into A in the given vector interval
	// Effect: A contains b && b is cleared
	// ASSUMPTION: size == upper-lower+1
	private int toArrayHelper(X[] A, int lower, int upper) { 
		int k = 0; // Purpose: The index of the next bucket element to dump into A
		int next = lower; // Purpose: The next index of A to dump an element into
		// INV: lower <= next <= (upper+1) && k = next-lower &&
		// A[lower..next-1] == b[0..k-1]
		while (next <= upper) { 
			// lower <= next <= upper && k = next-lower && A[lower..next-1] == b[0..k-1]
			A[next] = B.get(k);
			// lower <= next <= upper && k = next-lower && A[lower..next] == b[0..k]
			next = next + 1;
			// lower<=next<= (upper+1) && k=next-1-lower && A[lower..next-1]== b[0..k]
			k = k + 1;
			// lower<=next<=(upper+1) && k=next-lower && A[lower..next-1]==b[0..k-1] 
		}
		//lower<=next<=(upper+1) && k=next-lower && A[lower..next-1]==b[0..k-1] &&
		//next > upper
		// ==> next==(upper+1) ==> k==upper-lower ==> A[lower..upper] == b[0..size-1]
		B.clear();
		size = 0;
		return(upper-lower+1); 
	}
	
	// Purpose: Place bucket elements into the given array starting at index i
	// Effect: Clears the bucket
	public int toArray(X[] A, int i) { 
		return(toArrayHelper(A, i, i+this.size-1)); 
	}
	
}