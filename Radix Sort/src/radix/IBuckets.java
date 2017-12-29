package radix;

public interface IBuckets {
	
	//Purpose: Move the elements of the buckets into the given Array.
	//Effect: Empties the Buckets and changes the current elements in the Array to the elements from the Buckets.
	public void dumpBuckets(Integer[] arr);
	
	//Purpose: To get the Bucket from the ArrayList of Buckets in index i.
	public Bucket getBucket(int i);
	
}
