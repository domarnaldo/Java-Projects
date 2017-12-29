package dictionaries;

public class StringComparator implements HashComparator<String> { 
	
	//Purpose: A prime number for the hashIndex method
	int a = 11;
	
	//Purpose: The constructor of StringComparator.
	public StringComparator() {}
	
	public int hashIndex(String k) { 
		int slen = k.length(); //Purpose: The length of the given string k
		int i = -1; //Purpose: The index of the current letter in the string
		int code = 0; //The accumulator for the hashing formula
		
		//INV: i < slen && code = (int) k.charAt(i) + a * code
		while (i < slen - 1) { 
			// i < slen - 1 && code = (int) k.charAt(i) + a * code
			i = i + 1;
			// i < slen - 1 && code = (int) k.charAt(i+1) + a * code
			code = (int) k.charAt(i) + a * code;
			// i < slen - 1 && code = (int) k.charAt(i) + a * code
		}
		// i < slen && code = (int) k.charAt(i) + a * code
		return(Math.abs(code));
		// i > slen ==> code = (int) k.charAt(slen+2) + a * code
		// Termination Argument: Every loop iteration, i is increased by 1. Eventually, i will become
		//					     greater than (slen - 1) and the loop will terminate.
	}
	
	public int hashPrime(String k) {
		int prime = 997; //Purpose: A prime number to be used for the hashPrime method
		return prime - (hashIndex(k) % prime);
	}
	
	public Boolean keyEqual(String k1, String k2) { 
		return(k1.equals(k2)); 
	}
} 