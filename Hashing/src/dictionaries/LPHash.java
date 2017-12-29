package dictionaries;

public class LPHash<K, E> extends Hashing<K, E> {

	//Purpose: The super constructor of LPHash.
	public LPHash(int s, HashComparator<K> hc) { 
		super(s, hc);
	}
	
	public int find(K k) { 
		//Purpose: Division method compression map.
		int i = (h.hashIndex(k) % N); 
		int j = i;
		int res = -1;
		//Purpose: Indicates that the search is done.
		boolean done = false; 
		//INV: (done)  => empty(j) && res=-1                  ||
		//            = > available(j) && j==i                ||
		//            =>  (h.keyEqual(key(j), k)) && res = j  ||
		//            =>  j = (j + 1) % N && j==i             ||
		//
		//     (!done) => j = (j + 1) % N && j!=i             ||
		//             => res = -1
		//      && 0 < j < N
		while (!done) {
			if (empty(j)) { 
				done = true; 
			}
			else if (available(j)) { 
				j = (j + 1) % N;
				if (j == i) { 
					done = true; 
				}	 
			}
			else if (h.keyEqual(key(j), k)) { 
				res = j;
				done = true;
			}
			else { 
				j = (j + 1) % N; //allows us to wrap around to the beginning, start back at 0
				if (j == i) { 
					done = true; 
				}
			}
		}
		//Termination Argument: Every loop iteration, j is evaluated against several conditions
		//						eventually, j will meet one of these conditions because of the wrap around.
		//						If a condition is satisfied, done = true which would exit the loop.
		return(res); 
	}
	
	//Assumption: This HT is not full
	public void insert(K k, E e) {
		int i = h.hashIndex(k) % N;
		int j = i;
		boolean done = false;
		//INV: (done)  => (empty(j) || available(j)) && A.set(j,new Item<K, E>(k, e)) && n = n + 1
		//     (!done) => this.collisions += 1 && j = (j + 1) % N
		//		&& 0 < j < N
		while (!done) { 
			if (empty(j) || available(j)) 
			{ 
				A.set(j, new Item<K, E>(k, e));
				n = n + 1;
				done = true;
			}
			else {
				this.collisions += 1;
				}
			j = (j + 1) % N;
		} 
		//Termination Argument: Every loop iteration, j is checked if it is empty or available.
		//						If it is not, then j gets a new index ((j + h.hashPrime(k)) % N)
		//						Eventually, j will become empty or available and the loop will terminate
	}

}
