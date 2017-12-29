package dictionaries;

public interface HashComparator<K> {
	
	//Purpose: To return a hash index of the key given
	public int hashIndex(K k);
	
	//Purpose: To return a hash index of the key given
	// 		   by subtracting the hashIndex % prime (997 in this case) from a prime (997 in this case)
	public int hashPrime(K k);
	
	//Purpose: To check if two keys are equal
	public Boolean keyEqual(K k1, K k2);
	
}