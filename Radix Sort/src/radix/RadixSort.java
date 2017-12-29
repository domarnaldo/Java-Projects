package radix;

import java.util.*;

public class RadixSort {
	
	//Purpose: To get the length of the given int n.
	//Example: 21 would return 2, 5 would return 1.
	public static int getLength(int n) {
		return String.valueOf(n).length();
	}
	
	//Purpose: To calculate the length of the longest number in a vector of
    //         natural numbers.
	public static int getLargest(Integer[] n, int greatest, int index) {
		if (index == -1) return greatest;
		else if (greatest < getLength(n[index])) {
			return getLargest(n, getLength(n[index]), index-1);
		}
		else return getLargest(n, greatest, index-1);
	}
	
	//Purpose: To return the digit at the given index of the input number,
	//Example: getDigit(1234, 1) would return 4, getDigit(1234, 2) would return 3
	//         and getDigit(5, 3) would return 0
	public static int getDigit(int n, int index) {
		return Math.floorDiv((n % ((int) Math.pow(10, index))), ((int) Math.pow(10, index-1)));
	}
	
	//Purpose: To loop through the given ArrayList and place each element into a Bucket based on the digit of the number's index.
	//Effect:  Places elements from the array into the Bucket.
	private static void sortHelper(Integer[] arr, Buckets b, int index) {
		//Purpose: Index of Bucket being mutated.
		int y = 0; 
		//Accumulator Invarient: y < arr.length+1 && b.getBucket(getDigit(arr[y-1], index)) == arr[y-1] 
		while (y < arr.length) {
			// y < arr.length && b.getBucket(getDigit(arr[y-1], index)) == arr[y-1]
			b.getBucket(getDigit(arr[y], index)).add(arr[y]);
			// y < arr.length && b.getBucket(getDigit(arr[y], index)) == arr[y]
			y++;
			// y < arr.length && b.getBucket(getDigit(arr[y-1], index)) == arr[y-1]
		}
		// y < arr.length+1 && b.getBucket(getDigit(arr[y-1], index)) == arr[y-1]
		
		// y > arr.length+1 ==> b.getBucket(getDigit(arr[arr.length+2], index)) == arr[arr.length+2]
	}
	//Termination Argument: Every iteration y is increased by 1 and eventually z will be greater than arr.length+1
	//                      Therefore the loop will terminate.
	
	
	//Purpose: To sort the given ArrayList using Radix Sort algorithm.
	//Effect: To sort the array of integers from least to greatest.
	public static void sort(Integer[] arr) {
		//Purpose: The length of the longest number in the vector.
		int largest = getLargest(arr, 0, arr.length-1);
		//Purpose: represents the place of the single, tenth, hundreds, and so on.
		//Example: i=1 -> singles, i=2 -> tenths, i=3 -> hundreds...
		int i = 1;
		//Purpose: constructs the arraylist with a length of 10 which represents all the digits
		//         from 0 - 9.
		Buckets b = new Buckets(9);
		//Accumulator Invarient: i <= largest + 1 && arr[] is sorted && b is dumped to arr.
		while (i <= largest) {	
			//i <= largest && arr[] is sorted && b is dumped to arr.
			sortHelper(arr, b, i);
			//i <= largest && arr[] is sorted && b is dumped to arr.
			b.dumpBuckets(arr);
			//i <= largest && arr[] is sorted && b is dumped to arr.
			i++;
			//i <= largest + 1 && arr[] is sorted && b is dumped to arr.
		}
		//i <= largest + 1 && arr[] is sorted && b is dumped to arr.
		
		//i = largest + 1 ==> arr[] is sorted && b is dumped to arr.
	}
	//Termination Argument: Every iteration i is increased by 1 and eventually i will be greater than or equal to largest
	//                      Therefore the loop will terminate.
	
	
	
	//We had a hard time with the Inveriants, we know they aren't completely right.
	
	
	public static void main(String[] args) {
		Integer[] x = new Integer[]{105,34,22,12,75,99,1203,4200};
		sort(x);
		for (int i = 0; i<x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
}
