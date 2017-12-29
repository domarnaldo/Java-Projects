package radix;

import java.util.*;

public class Buckets implements IBuckets {
	
	//Purpose: To create a new ArrayList of type Bucket.
	List<Bucket> b = new ArrayList<Bucket>();
	
	int size; //Purpose: The number of Bucket inside the ArrayList.
	
	//Purpose: Constructor of an ArrayList of Buckets
	public Buckets(int n) {	
		size = n;		
		//Accumulator Invarient: i <= n+1 && b.size() == i && b.get(i) == new Bucket                     
		for (int i = 0; i<=n; i++) {
			//i <= n && b.size() == i && b.get(i) == new Bucket             
			b.add(new Bucket());
			//i <= n && b.size() == i+1 && b.get(i+1) == new Bucket  
			//i = i+ 1
			//i <= n+1 && b.size() == i && b.get(i) == new Bucket             
		}
			//i <= n+1 && b.size() == i && b.get(i) == new Bucket && i > n  
			// i = n+1 ==> b.get(0...n) == new Bucket
		
		//Termination Argument: Every iteration i is increased by 1 and eventually i will become greater than or equal to n.
		//                      Therefore the loop will terminate.

	}

	//Purpose: To get the Bucket from the ArrayList of Buckets in index n.
	public Bucket getBucket(int n) {
		return b.get(n);
	}
	
	//Purpose: Move the elements of the buckets into the given Array.
	//Effect: Empties the Buckets and changes the current elements in the Array to the elements from the Buckets.
	public void dumpBuckets(Integer[] arr) {
		
		int z = 0; //Purpose: Index of the current bucket being dumped.
		int previous = 0; //Purpose: Index of the last element dumped from the previous bucket.
		
		//Accumulator Invarient: z <= size + 1 && newPrevious = previous + b.get(z-1).getSize() && 
		//                       arr[previous...b.get(z-1).getSize()] == this.getBucket(z-1)
		while (z <= size) {
			// z <= size && newPrevious = previous + b.get(z-1).getSize() && 
			// arr[previous...b.get(z-1).getSize()] == this.getBucket(z-1)
			int newPrevious = previous + b.get(z).getSize();
			// z <= size && newPrevious = previous + b.get(z).getSize() && 
			// arr[previous...b.get(z-1).getSize()] == this.getBucket(z-1)
			this.getBucket(z).toArray(arr, previous);
			// z <= size && newPrevious = previous + b.get(z).getSize() && 
			// arr[previous...b.get(z).getSize()] == this.getBucket(z)
			previous = newPrevious;
			z++;
			// z <= size && newPrevious = previous + b.get(z-1).getSize() && 
			// arr[previous...b.get(z-1).getSize()] == this.getBucket(z-1)
		}
		// z <= size + 1 && newPrevious = previous + b.get(z-1).getSize() && 
		// arr[previous...b.get(z-1).getSize()] == this.getBucket(z-1)
		
		// z = size + 1 ==> newPrevious = previous + b.get(size).getSize() && 
		// arr[previous...b.get(size).getSize()] == this.getBucket(size)
	}
	//Termination Argument: Every iteration z is increased by 1 and eventually z will be greater than or equal to size
	//                      Therefore the loop will terminate.
}
