package dictionaries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class StringGenerator {
	
	//Purpose: the generated items (key and an element)
	private static ArrayList<Item<String, String>> items = new ArrayList<Item<String, String>>();
	//Purpose: the used keys and elements in one array
	private static ArrayList<String> used = new ArrayList<String>();
	
	//Purpose: to generate a string of random length between 1 and the given length
	//		   length must be a natural number greater than 0
	public static String generateString(int length) {
		//Purpose: a new random class
		Random rand = new Random();
		//Purpose: a random number between 1 and the given length
		int randomLength = rand.nextInt(length) + 1;
		//Purpose: the index of the current random letter generated for the random word
		int i = 0;
		//If i becomes >= to the given length, the loop will not run
		//Purpose: a string of all the letters, lowercase and uppercase
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//Purpose: the randomly generated string of a random length between 1 and length
		String randomString = new String();
		
		//INV: i <= randomLength && i == randomString.length 
		while (i < randomLength) {
			// i < randomLength && i == randomString.length 
			//Purpose: a new random class for the index to get the letter from to generate the string
			Random randIndex = new Random();
			// i < randomLength && i == randomString.length 
			
			//Purpose: a random index from 0 to the length of the alphabet string
			int randomStringIndex = randIndex.nextInt(alphabet.length());
			
			// i < randomLength && i == randomString.length 
			randomString += alphabet.substring(randomStringIndex, randomStringIndex+1);
			// i < randomLength && i + 1 == randomString.length
			
			i++;
			// i <= randomLength && i == randomString.length 
		}
		// i <= randomLength && i == randomString.length 
		// ==> i = randomLength && randomLength == randomString.length
		
		//Termination Argument: i increases by 1 every loop iteration (every time the loop executes).
		//						Eventually, i will become greater than the input length.
		//Return the newly created string of a random length between 1 and the length inclusive
		return randomString;
	}
	
	//Purpose: to recursively check if a key or element has been already generated
	//		   if the input key and element has not been used, add them to the itemsArray and add
	//		   each to the usedItems array
	//		   otherwise, recursively call the inArray function again with newly generated strings
	public static void inArray(String k, String e, ArrayList<Item<String, String>> itemsArray, ArrayList<String> usedItems) {
		//The built in contains method for ArrayLists checks if an element is in an ArrayList
		//Here, we check if either the given k (key) or e (element) is in the usedItems ArrayList
		if (!usedItems.contains(k) && !usedItems.contains(e)) {
			//If the given key and element are not in the usedItems ArrayList,
			//add them to the given itemsArray ArrayList
			itemsArray.add(new Item<String,String>(k, e));
			//Here, we add the given key and element to the usedItems ArrayList
			usedItems.add(k);
			usedItems.add(e);
		} else {
			//If they are in the ArrayList, then it recursively calls the function "inArray" with a newly
			//generated key (a string of random length between 1 and 20) and 
			//a generated element (a string of random length between 1 and 20)
			inArray(generateString(20), generateString(20), itemsArray, usedItems);
		}
	}
	
	//Purpose:  to generate a list of items (key and element pairs) of the given length
	// 			it passes the itemsArray and usedItems to the recursive inArray function
	//			length must be a natural number greater than 0
	public static ArrayList<Item<String, String>> generateItems(int length, ArrayList<Item<String, String>> itemsArray, ArrayList<String> usedItems) {
		//Purpose: to index the amount of strings generated
		int i = 0;
		//If i becomes >= to the given length, the loop will not run
		
		//INV: i <= length && i == itemsArray.size() 
		while (i < length) {
			// i < length && i == itemsArray.size() 
			String randomKey = generateString(20);
			// i < length && i == itemsArray.size() 
			String randomElement = generateString(20);
			// i < length && i == itemsArray.size() 
			inArray(randomKey, randomElement, itemsArray, usedItems);
			// i < length && i + 1 == itemsArray.size() 
			
			i++;
			// i <= length && i == itemsArray.size() 
		}
		// i <= length && i == itemsArray.size() 
		// ==> i = length && length == itemsArray.size() 
		//Termination Argument: i increases by 1 every loop iteration (every time the loop executes).
		//						Eventually, i will become greater than the input length.
		//Returns the newly populated itemsArray ArrayList
		return itemsArray;
	}
	
	//Purpose: to test the two hashing functions (Linear Probing and Double Hashing)
	//         creates the a new ArrayList of items IN of n length
	//Effect: prints out the number of collisions produced from both the Linear Probing and Double Hashing
	// 		  functions
	private static void testData(int n) {
		//Purpose: a new String Comparator class
		HashComparator<String> scomp = new StringComparator();
				
		//1000
		LPHash<String, String> LPN = new LPHash<String, String>(10007, scomp);
		DoubleHash<String, String> DHN = new DoubleHash<String, String>(10007, scomp);
		ArrayList<Item<String, String>> IN = generateItems(n, items, used);
		Iterator<Item<String, String>> LooperN = IN.iterator();
				
		// INV: (LooperN.hasNext()) => not all elements of LooperN are inserted &&
		//								  Items of IN added are IN[0..i], i == LooperN pos - 1
		//      (!LooperN.hasNext()) => all elements of IN are added &&
		//								   Elements of IN added are IN[0..i-1], i == IN.size()
		while (LooperN.hasNext()) {
			Item<String, String> currentItem = LooperN.next();
			LPN.insert(currentItem.getKey(), currentItem.getElem());
			DHN.insert(currentItem.getKey(), currentItem.getElem());
		}
			
		System.out.println("Linear Probing Collisions (" + n + " Items): " + LPN.getCollisions());
		System.out.println("Double Hashing Collisions (" + n + " Items): " + DHN.getCollisions());
	}
	
	public static void main (String[] args) {
		
		/*
		 * TESTS FOR DATA
		 * Each test ran on its own.
		 * For example, if test 2000 was ran, every other test was commented out.
		 * 
		 */
		
		//1000
		testData(1000);
		
		//2000
		testData(2000);
		
		//3000
		testData(3000);
		
		//4000
		testData(4000);
		
		//5000
		testData(5000);
		
		//6000
		testData(6000);
		
		//7000
		testData(7000);
		
		//8000
		testData(8000);
		
		//9000
		testData(9000);
		
		//10000
		testData(10000);
		
	}
	
}
